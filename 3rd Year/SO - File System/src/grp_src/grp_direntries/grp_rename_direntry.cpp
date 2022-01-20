#include "direntries.h"

#include "core.h"
#include "devtools.h"
#include "daal.h"
#include "inodeblocks.h"
#include "bin_direntries.h"

#include <string.h>
#include <errno.h>
#include <cassert>
#include <sys/stat.h>
// Autor : Bruno Bragues Costa Lemos
// Nmec  : 98221
namespace sofs21
{
    void grpRenameDirentry(int pih, const char *name, const char *newName){
        soProbe(204, "%s(%d, %s, %s)\n", __FUNCTION__, pih, name, newName);
        assert(strlen(newName) <= FILENAME_MAXLEN);
        soCheckInodeAccess(pih,W_OK);
        char newName1[DIRECTORY_SLOT];
        char newName2[DIRECTORY_SLOT];
        char name1[DIRECTORY_SLOT];
        char name2[DIRECTORY_SLOT];
        for(size_t i = 0; i < strlen(name); i++) {
            assert(name[i]!='/');
        }
        for(size_t i = 0; i < strlen(newName); i++) {
           assert(name[i]!='/');
        }
        if (strlen(newName) > DIRECTORY_SLOT){
            strncpy (newName1,newName,DIRECTORY_SLOT);
            strncpy (newName2,newName+DIRECTORY_SLOT,DIRECTORY_SLOT);
        }
        if (strlen(name) > DIRECTORY_SLOT){
            strncpy (name1,name,DIRECTORY_SLOT);
            strncpy (name2,name+DIRECTORY_SLOT,DIRECTORY_SLOT);
        }
        SOInode* pin=soGetInodePointer(pih);
        
        uint32_t block_index=NullBlockReference;
        uint32_t entry_index=NullBlockReference;
        uint32_t anterior_block_index=NullBlockReference;
        uint32_t anterior_entry_index=NullBlockReference;

        uint32_t block_index_free=NullBlockReference;
        uint32_t entry_index_free=NullBlockReference;
        uint32_t anterior_block_index_free=NullBlockReference;
        uint32_t anterior_entry_index_free=NullBlockReference;
        
        uint16_t inode = NullInodeReference;
        int free_slots = 0;
        int findnext = 0;
        int notend = 1;
        int encontrou = 0;
        int name_ok = 0;
        int newname_ok = 0;
        int see = 1;
        for (uint32_t i=0;i<pin->blkcnt;i++) { //iterate through all blocks to find entry
            SODirectorySlot dir[DPB];
            soReadInodeBlock(pih,i,dir);
            for (uint32_t j=0;j<DPB;j++){
                //check new name
                if(strlen(newName) <= DIRECTORY_SLOT){
                    if (strncmp(newName, dir[j].nameBuffer,DIRECTORY_SLOT) == 0 && see == 1 && (dir[j].in != NullInodeReference)){
                        throw SOException(EEXIST, __FUNCTION__);
                    }else{
                        see = 1;
                    }
                    if(strlen(dir[j].nameBuffer) != 0 && (dir[j].in == NullInodeReference)){
                        see = 0;
                    }
                }
                else{
                    if (!newname_ok){
                        if ( strncmp(newName1, &dir[j].nameBuffer[0],DIRECTORY_SLOT) == 0 && (dir[j].in == NullInodeReference)){
                            newname_ok = 1;
                        }
                    }else{
                        if ((strncmp(newName2, dir[j].nameBuffer,DIRECTORY_SLOT) == 0)){
                            throw SOException(EEXIST, __FUNCTION__);
                        }else if ( strncmp(newName1, &dir[j].nameBuffer[0],DIRECTORY_SLOT) == 0 && (dir[j].in == NullInodeReference)){
                            newname_ok = 1;
                        }else{
                            newname_ok = 0;
                        }
                    }
                }
                if (strlen(name) > DIRECTORY_SLOT && strlen(newName) <= DIRECTORY_SLOT){ // name = 2dirslots and newname = 1 dirslot
                    if (notend){
                        if (!findnext){
                            if ( strncmp(name1, &dir[j].nameBuffer[0],DIRECTORY_SLOT) == 0 && (dir[j].in == NullInodeReference)){
                                findnext = 1;
                                anterior_block_index=i;
                                anterior_entry_index=j;
                            }
                        }else{
                            if ((strncmp(name2, dir[j].nameBuffer,DIRECTORY_SLOT) == 0)){
                                notend = 0;
                                name_ok = 1;
                                block_index=i;
                                entry_index=j;
                                inode = dir[j].in;
                            }else{
                                findnext = 0;
                            }
                        }
                    }
                }else if(strlen(name) <= DIRECTORY_SLOT && strlen(newName) <= DIRECTORY_SLOT){ // name = 1dirslots and newname = 1 dirslot
                    if (strncmp(name,dir[j].nameBuffer,DIRECTORY_SLOT)==0 && dir[j].in != NullInodeReference) {
                        block_index=i;
                        entry_index=j;
                        name_ok = 1;
                    }
                }else if(strlen(name) > DIRECTORY_SLOT && strlen(newName) > DIRECTORY_SLOT){ // name = 2dirslots and newname = 2 dirslot
                    if (notend){
                        if(!findnext){
                            if ( strncmp(name1, &dir[j].nameBuffer[0],DIRECTORY_SLOT) == 0 && (dir[j].in == NullInodeReference)){
                                findnext = 1;
                                anterior_block_index=i;
                                anterior_entry_index=j;

                            }
                        }else{
                            if ((strncmp(name2, dir[j].nameBuffer,DIRECTORY_SLOT) == 0)){
                                block_index=i;
                                entry_index=j;
                                notend = 0;
                                name_ok = 1;
                                //inode = dir[j].in;
                            }else{
                                findnext = 0;
                            }
                        }
                    }
                }else{ // name = 1dirslots and newname = 2 dirslot                       
                    if (free_slots!=2){
                        if((strlen(dir[j].nameBuffer) == 0) && dir[j].in == NullInodeReference){
                            free_slots +=1;
                            if(free_slots == 1){
                                anterior_block_index_free=i;
                                anterior_entry_index_free=j;
                            }
                            if(free_slots == 2){
                                block_index_free = i;
                                entry_index_free=j;
                            }
                        }else{
                            free_slots = 0;
                        }
                    }
                    if (!encontrou){
                        if(findnext==0){
                            if(strncmp(name, &dir[j].nameBuffer[0],DIRECTORY_SLOT) == 0){
                                findnext = 1;
                                anterior_block_index=i;
                                anterior_entry_index=j;
                                name_ok = 1;
                                inode = dir[j].in;
                            }
                        }else{
                            if((strlen(dir[j].nameBuffer) == 0) && dir[j].in == NullInodeReference){
                                block_index=i;
                                entry_index=j;
                                encontrou = 1;
                            }else{
                                findnext = 0;
                            }
                        }
                    }

                }
            }
        }
        if (name_ok ==0){
            throw SOException(ENOENT, __FUNCTION__);
        }
        SODirectorySlot dir[DPB];
        
        if (strlen(name) > DIRECTORY_SLOT && strlen(newName) <= DIRECTORY_SLOT){ // feito
            //strncpy(dir[anterior_entry_index].nameBuffer,,DIRECTORY_SLOT);
            soReadInodeBlock(pih,anterior_block_index,dir);
            //printf("name - 2slot | newname - 1slot\n\r");
            strncpy(dir[anterior_entry_index].nameBuffer,newName,DIRECTORY_SLOT);
            dir[anterior_entry_index].in = inode;
            soWriteInodeBlock(pih,anterior_block_index,dir);

            soReadInodeBlock(pih,block_index,dir);
            memset(dir[entry_index].nameBuffer,0x0,DIRECTORY_SLOT);
            dir[entry_index].in = NullInodeReference;
            soWriteInodeBlock(pih,block_index,dir);
        }else if(strlen(name) <= DIRECTORY_SLOT && strlen(newName) <= DIRECTORY_SLOT){ //feito
            //printf("name - 1slot | newname - 1slot\n\r");
            soReadInodeBlock(pih,block_index,dir);
            strncpy(dir[entry_index].nameBuffer,newName,DIRECTORY_SLOT);
            soWriteInodeBlock(pih,block_index,dir);
        }else if(strlen(name) > DIRECTORY_SLOT && strlen(newName) > DIRECTORY_SLOT){ // feito
            //printf("name - 2slot | newname - 2slot\n\r");
            soReadInodeBlock(pih,block_index,dir);
            strncpy(dir[entry_index].nameBuffer,newName2,DIRECTORY_SLOT);
            soWriteInodeBlock(pih,block_index,dir);
            //dir[anterior_entry_index].in = NullInodeReference;

            soReadInodeBlock(pih,anterior_block_index,dir);
            strncpy(dir[anterior_entry_index].nameBuffer,newName1,DIRECTORY_SLOT);

            soWriteInodeBlock(pih,anterior_block_index,dir);
        }else{// feito
            //printf("name - 1slot | newname - 2slot\n\r");
            if (encontrou){
                soReadInodeBlock(pih,block_index,dir);
                strncpy(dir[entry_index].nameBuffer,newName2,DIRECTORY_SLOT);
                dir[entry_index].in = inode;
                soWriteInodeBlock(pih,block_index,dir);

                soReadInodeBlock(pih,anterior_block_index,dir);
                strncpy(dir[anterior_entry_index].nameBuffer,newName1,DIRECTORY_SLOT);
                dir[anterior_entry_index].in = NullInodeReference;
                soWriteInodeBlock(pih,anterior_block_index,dir);
            }else{
                soReadInodeBlock(pih,anterior_block_index_free,dir);
                strncpy(dir[anterior_entry_index_free].nameBuffer,newName1,DIRECTORY_SLOT);
                dir[anterior_entry_index_free].in = NullInodeReference;
                soWriteInodeBlock(pih,anterior_block_index_free,dir);

                soReadInodeBlock(pih,block_index_free,dir);
                strncpy(dir[entry_index_free].nameBuffer,newName2,DIRECTORY_SLOT);
                dir[entry_index_free].in = inode;
                soWriteInodeBlock(pih,block_index_free,dir);

                soReadInodeBlock(pih,anterior_block_index,dir);
                memset(dir[anterior_entry_index].nameBuffer,0x0,DIRECTORY_SLOT);
                dir[anterior_entry_index].in = NullInodeReference;
                soWriteInodeBlock(pih,anterior_block_index,dir);
            }

        }

        /* replace this comment and following line with your code */
        //binRenameDirentry(pih, name, newName);
    }
};