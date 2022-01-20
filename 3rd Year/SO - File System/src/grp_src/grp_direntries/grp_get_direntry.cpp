#include "direntries.h"

#include "core.h"
#include "devtools.h"
#include "daal.h"
#include "inodeblocks.h"
#include "bin_direntries.h"

#include <errno.h>
#include <string.h>
#include <sys/stat.h>
#include <cassert>
// Autor : Bruno Bragues Costa Lemos
// Nmec  : 98221
namespace sofs21
{
    uint16_t grpGetDirentry(int pih, const char *name)
    {
        soProbe(201, "%s(%d, %s)\n", __FUNCTION__, pih, name);
        /* replace the following line with your code */
        //return binGetDirentry(pih, name);
        soCheckInodeAccess(pih,R_OK);
        assert(strlen(name) <= FILENAME_MAXLEN);
        int number_dirslots = 1;
        char name1[DIRECTORY_SLOT];
        char name2[DIRECTORY_SLOT];

        // pih -> parent inode handler
        if (strlen(name) > DIRECTORY_SLOT){
            number_dirslots = 2;
            strncpy (name1,name,DIRECTORY_SLOT);
            strncpy (name2,name+DIRECTORY_SLOT,DIRECTORY_SLOT);
            //printf("teste1\n\r");
        }
        SOInode *pin = soGetInodePointer(pih);
        SODirectorySlot dir[DPB];
        int see = 1;
        //name is a valid base name (it doesn't contains '/')
        for(size_t i = 0; i < strlen(name); i++) {
            if(name[i] == '/') {
                throw SOException(EINVAL, __FUNCTION__);
            }
        }
        //------------------------DEBUG-------------------
        // for (uint32_t i = 0; i < pin->blkcnt ; i++){
        //     soReadInodeBlock(pih,i,dir);
        //     printf("Bloco %u\n\r",(unsigned int)i);
        //     for (uint32_t j = 0; j < DPB; j++){
        //         char bbbb[31];
        //         snprintf(bbbb,31,"%s",dir[j].nameBuffer);
        //         if (dir[j].in != NullInodeReference){
        //             printf("[%2.0u]%30s | %u\n\r",(unsigned int)j,bbbb,(unsigned int)dir[j].in);
        //         }else{
        //             printf("[%2.0u]%30s | NullInode\n\r",(unsigned int)j,bbbb);
        //         }
        //     }
        // }
        //----------------------------------------------

        int findnext = 0;
        for (uint32_t i = 0; i < pin->blkcnt ; i++){

            soReadInodeBlock(pih,i,dir);

            for (uint32_t j = 0; j < DPB; j++){
                if(number_dirslots == 1){
                    if (strncmp(name, dir[j].nameBuffer,DIRECTORY_SLOT) == 0 && see == 1 && (dir[j].in != NullInodeReference)){
                        return dir[j].in;
                    }else{
                        see = 1;
                    }
                    if(strlen(dir[j].nameBuffer) != 0 && (dir[j].in == NullInodeReference)){
                        see = 0;
                    }
                }
                else{
                    if (!findnext){
                        if ( strncmp(name1, &dir[j].nameBuffer[0],DIRECTORY_SLOT) == 0 && (dir[j].in == NullInodeReference)){
                            findnext = 1;
                        }
                    }else{
                        if ((strncmp(name2, dir[j].nameBuffer,DIRECTORY_SLOT) == 0)){
                            return dir[j].in;
                        }else if ( strncmp(name1, &dir[j].nameBuffer[0],DIRECTORY_SLOT) == 0 && (dir[j].in == NullInodeReference)){
                            findnext = 1;
                        }else{
                            findnext = 0;
                        }
                    }
                }
            }
        }
        //or returns InodeNullReference, if name doesn't exist
        return NullInodeReference;
    }
};