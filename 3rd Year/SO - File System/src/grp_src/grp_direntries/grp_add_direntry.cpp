#include "direntries.h"

#include "core.h"
#include "devtools.h"
#include "daal.h"
#include "inodeblocks.h"
#include "bin_direntries.h"

#include <errno.h>
#include <string.h>
#include <sys/stat.h>
#include <assert.h>

namespace sofs21
{
    void grpAddDirentry(int pih, const char *name, uint16_t cin)
    {
        soProbe(202, "%s(%d, %s, %u)\n", __FUNCTION__, pih, name, cin);

        // pih is a valid inode handler of a directory where the user has write access
        soCheckInodeAccess(pih, W_OK);

        // name is a valid base name (it doesn't contain '/')
        for(int i=strlen(name); i > 0; i--){
            assert(name[i] != '/');
        }

        // cin is a valid inode number
        assert(cin < NullInodeReference);

        SOInode *pin = soGetInodePointer(pih);
        assert((pin->mode & S_IFDIR) == S_IFDIR);
        unsigned free_block_fbn = NullBlockReference;    
        unsigned free_ref_index = NullInodeReference;
        unsigned free_block_fbn_2nd = NullBlockReference;
        unsigned free_ref_index_2nd = NullInodeReference;

        char name1[DIRECTORY_SLOT];
        char name2[DIRECTORY_SLOT];
        int flag_search_for_2nd = 0;

        if (strlen(name) > DIRECTORY_SLOT){
            strncpy(name1,name,DIRECTORY_SLOT);
            strncpy(name2,name+DIRECTORY_SLOT,DIRECTORY_SLOT);
        }

        for (unsigned i=0; i < pin->blkcnt; i++) {
            
            SODirectorySlot entries[DPB];
            soReadInodeBlock(pih,i,entries);

            for (unsigned j=0; j < DPB; j++) {
                if (strcmp(name, entries[j].nameBuffer) == 0) {
                    throw SOException(EEXIST, __FUNCTION__);
                }
                // check if the name only occupies 1 slot
                if (strlen(name) <= DIRECTORY_SLOT){
                    if (free_block_fbn == NullBlockReference && entries[j].nameBuffer[0] == '\0') {
                        free_block_fbn = i;
                        free_ref_index = j;
                    }
                }else{
                    if (flag_search_for_2nd == 0){
                        // check if the first slot is empty (of 2 slots in a row)
                        if (entries[j].nameBuffer[0] == '\0' &&  entries[j].in == NullInodeReference){
                            free_block_fbn = i;
                            free_ref_index = j;
                            flag_search_for_2nd = 1;
                        }
                    }else if (flag_search_for_2nd == 1){
                        if (entries[j].nameBuffer[0] == '\0' &&  entries[j].in == NullInodeReference){
                            free_block_fbn_2nd = i;
                            free_ref_index_2nd = j;
                            flag_search_for_2nd = -1; // flag has the value -1 to prevent to search furthermore
                        }else{
                            flag_search_for_2nd = 0;
                        } 
                    }
                }
            }
        }

        SODirectorySlot entries[DPB];
        if (free_block_fbn == NullBlockReference) {
            free_block_fbn = pin->size/BlockSize;
            free_ref_index = 0;
            soAllocInodeBlock(pih, free_block_fbn);
            pin->size += BlockSize;

            for (unsigned long i = 0; i < DPB; i++) {
                entries[i].in = NullInodeReference;
                memset(entries[i].nameBuffer,0x0,DIRECTORY_SLOT);
            }
            soWriteInodeBlock(pih, free_block_fbn, entries);
           
        }
        if (strlen(name) > DIRECTORY_SLOT){
            if (free_block_fbn_2nd == NullBlockReference) {
                free_block_fbn_2nd = pin->size/BlockSize;
                free_ref_index = 0;
                soAllocInodeBlock(pih, free_block_fbn_2nd);
                pin->size += BlockSize;

                for (unsigned long i = 0; i < DPB; i++) {
                    entries[i].in = NullInodeReference;
                    memset(entries[i].nameBuffer,0x0,DIRECTORY_SLOT);
                }
                soWriteInodeBlock(pih, free_block_fbn_2nd, entries);
            }
        }


        if (strlen(name) <= DIRECTORY_SLOT){
            soReadInodeBlock(pih, free_block_fbn,entries);
            entries[free_ref_index].in = cin;
            strncpy(entries[free_ref_index].nameBuffer, name,DIRECTORY_SLOT);
            soWriteInodeBlock(pih, free_block_fbn, entries);
        }else{
            //printf("%u , %u\n\r",(unsigned int)free_block_fbn,(unsigned int)free_ref_index);
            soReadInodeBlock(pih, free_block_fbn,entries);
            entries[free_ref_index].in = NullInodeReference;
            strncpy(entries[free_ref_index].nameBuffer, name1,DIRECTORY_SLOT);
            soWriteInodeBlock(pih, free_block_fbn, entries);
            //printf("%u , %u\n\r",(unsigned int)free_block_fbn_2nd,(unsigned int)free_ref_index_2nd);
            soReadInodeBlock(pih, free_block_fbn_2nd,entries);
            entries[free_ref_index_2nd].in = cin;
            //printf("%u\n\r",(unsigned int)cin);
            strncpy(entries[free_ref_index_2nd].nameBuffer, name2,DIRECTORY_SLOT);
            soWriteInodeBlock(pih, free_block_fbn_2nd, entries);
        }
    }
};

