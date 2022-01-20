
#include "direntries.h"

#include "core.h"
#include "devtools.h"
#include "daal.h"
#include "inodeblocks.h"
#include "bin_direntries.h"

#include <errno.h>
#include <string.h>
#include <sys/stat.h>

namespace sofs21
{
    uint16_t grpDeleteDirentry(int pih, const char *name)
    {
        soProbe(203, "%s(%d, %s)\n", __FUNCTION__, pih, name);

        /* replace this comment and following line with your code */
        //return binDeleteDirentry(pih, name);
        soCheckInodeAccess(pih,W_OK);
        char name1[DIRECTORY_SLOT];
        char name2[DIRECTORY_SLOT];

        int numero_slots = 1; // 1 ou 2s
        int find = 0; // 1 ou 0
        
        int anterior_block_index;
        int anterior_entry_index;

        for(size_t i = 0; i < strlen(name); i++) {
            if(name[i] == '/') {
                throw SOException(EINVAL, __FUNCTION__);
            }
        }



        if (strlen(name) > DIRECTORY_SLOT){ //2 slots
            strncpy (name1,name,DIRECTORY_SLOT);
            strncpy (name2,name+DIRECTORY_SLOT,DIRECTORY_SLOT);
            numero_slots = 2;
        }

        uint32_t result;
        SODirectorySlot ref[DPB];
        SOInode* ipointer = soGetInodePointer(pih);
        
        

        for (uint32_t i = 0; i < ipointer->blkcnt ; i++){

            soReadInodeBlock(pih,i,ref);

            for (uint32_t k = 0; k < DPB; k++){
                if(numero_slots ==1){
                    if (strncmp(ref[k].nameBuffer,name,DIRECTORY_SLOT) == 0 && ref[k].in != NullInodeReference){
                        result = ref[k].in;
                        memset(ref[k].nameBuffer,'\0',DIRECTORY_SLOT);
                        ref[k].in = NullInodeReference;
                        soWriteInodeBlock(pih,i,ref);
                        return result;
                    }
                }else{
                    if(!find){
                        if ( strncmp(name1, ref[k].nameBuffer,DIRECTORY_SLOT) == 0 && (ref[k].in == NullInodeReference)){
                            find = 1;
                            anterior_block_index=i;
                            anterior_entry_index=k;
                        }
                    }else{
                        if ((strncmp(name2, ref[k].nameBuffer,DIRECTORY_SLOT) == 0) && (ref[k].in != NullInodeReference)){
                            //remove o second_entry 
                            result = ref[k].in;
                            memset(ref[k].nameBuffer,'\0',DIRECTORY_SLOT);
                            ref[k].in = NullInodeReference;
                            soWriteInodeBlock(pih,i,ref);
                            
                            //remove o first_entry
                            soReadInodeBlock(pih,anterior_block_index,ref);
                            memset(ref[anterior_entry_index].nameBuffer,'\0',DIRECTORY_SLOT);
                            ref[anterior_entry_index].in = NullInodeReference;
                            soWriteInodeBlock(pih,anterior_block_index,ref);
                            return result;
                        }else{
                            find = 0;
                        }
                    }
                }
                
            }
        }
        throw SOException(ENOENT, __FUNCTION__ );
    }
};
