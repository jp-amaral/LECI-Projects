/*
 *  \authur Artur Pereira - 2016-2021
 */
//Nome:João Viegas
//NMEC:98372

#include "inodeblocks.h"
#include "bin_inodeblocks.h"
#include "grp_inodeblocks.h"

#include "freedatablocks.h"
#include "daal.h"
#include "core.h"
#include "devtools.h"

#include <errno.h>

#include <iostream>

namespace sofs21
{


    static uint32_t grpAllocIndirectInodeBlock(int ih, uint32_t & i1, uint32_t idx);

    static uint32_t grpAllocDoubleIndirectInodeBlock(int ih, uint32_t & i2, uint32_t idx);


    /* ********************************************************* */

    uint32_t grpAllocInodeBlock(int ih, uint32_t ibn)
    {
        soProbe(302, "%s(%d, %u)\n", __FUNCTION__, ih, ibn);

        /* replace the following two lines with your code */
        //return binAllocInodeBlock(ih, ibn);

        SOSuperblock* sbp = soGetSuperblockPointer();
        if(ih  > sbp->itotal ){
            throw SOException(EINVAL, __FUNCTION__);
        }

        SOInode* inode = soGetInodePointer(ih);

        if((ibn >= N_DIRECT + RPB + RPB*RPB) || (ibn < 0)){
            throw SOException(EINVAL, __FUNCTION__);
        }

        //Dentro do d
        if(ibn < N_DIRECT){
            if(inode->d[ibn] == NullBlockReference){
                uint32_t block = soAllocDataBlock();
                inode->blkcnt++;
                inode->d[ibn] = block;
                return block;
            }else{
                throw SOException(ESTALE, __FUNCTION__);
            }
        }

        //Dentro do i1
        uint32_t block;
        if(ibn < N_DIRECT + RPB){
            block  = grpAllocIndirectInodeBlock(ih, inode->i1, ibn-N_DIRECT);
        }else{
        //Dentro do i2
            block = grpAllocDoubleIndirectInodeBlock(ih, inode->i2, ibn);
        }
        return block;
    }

    /* ********************************************************* */


    static uint32_t grpAllocIndirectInodeBlock(int ih, uint32_t & i1, uint32_t idx)
    {
        soProbe(302, "%s(%d, %u, %u)\n", __FUNCTION__, ih, i1, idx);

        /* replace the following two lines with your code */
        // throw SOException(ENOSYS, __FUNCTION__); 
        // return 0;
        SOInode* inode = soGetInodePointer(ih);
        if((inode->i1 == NullBlockReference) && (inode->i2 == NullBlockReference)){
            uint32_t i1_block = soAllocDataBlock();
            inode->blkcnt++;
            inode->i1 = i1_block;
            //Limpeza do bloco i1
            uint32_t i1_array[RPB];
            soReadDataBlock(inode->i1, i1_array);
            for(uint32_t i = 0; i < RPB; i++){
                i1_array[i] = NullBlockReference;
            }
            soWriteDataBlock(inode->i1, i1_array);
        }else if(i1==NullBlockReference){
            uint32_t i1_block = soAllocDataBlock();
            inode->blkcnt++;
            i1 = i1_block;
            //Limpeza do bloco i1
            uint32_t i1_array[RPB];
            soReadDataBlock(i1, i1_array);
            for(uint32_t i = 0; i < RPB; i++){
                i1_array[i] = NullBlockReference;
            }
            soWriteDataBlock(i1, i1_array);
        }
        uint32_t i1_array[RPB];
        soReadDataBlock(i1, i1_array);
        if(i1_array[idx] == NullBlockReference){
            uint32_t block = soAllocDataBlock();
            inode->blkcnt++;
            i1_array[idx] = block;
            soWriteDataBlock(i1, i1_array);
            return block;
        }else{
            throw SOException(ESTALE, __FUNCTION__);
        }
    }


    /* ********************************************************* */


    /*
    */
    static uint32_t grpAllocDoubleIndirectInodeBlock(int ih, uint32_t & i2, uint32_t idx)
    {
        soProbe(302, "%s(%d, %u, %u)\n", __FUNCTION__, ih, i2, idx);

        /* replace the following two lines with your code */
        //throw SOException(ENOSYS, __FUNCTION__); 
        //return 0;

        //Get the respective index in i2
        uint32_t i2_idx = (idx - (RPB+N_DIRECT))/RPB;
        SOInode* inode = soGetInodePointer(ih);
        //Check if i2 is Null
        if(i2 == NullBlockReference){
            uint32_t i2_block = soAllocDataBlock();
            inode->blkcnt++;
            inode->i2 = i2_block;
            uint32_t i2_array[RPB];
            soReadDataBlock(inode->i2, i2_array);
            for(uint32_t i = 0; i < RPB; i++){
                i2_array[i] = NullBlockReference;
            }
            soWriteDataBlock(inode->i2, i2_array);
        }
        //Go to the respective index in i2
        uint32_t i2_array[RPB];
        soReadDataBlock(inode->i2, i2_array);
        //Get the corresponding i1
        
        uint32_t i1 = i2_array[i2_idx];
        //Get the corresponding idx inside i1
        uint32_t i1_idx = idx - N_DIRECT - (RPB*(i2_idx+1));

        uint32_t block = grpAllocIndirectInodeBlock(ih, i1, i1_idx);
        i2_array[i2_idx] = i1;
        soWriteDataBlock(inode->i2, i2_array);
        return block;


    }

}