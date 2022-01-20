/*
 *  \authur Artur Pereira - 2016-2021
 */

#include "inodeblocks.h"
#include "bin_inodeblocks.h"
#include "grp_inodeblocks.h"

#include "daal.h"
#include "core.h"
#include "devtools.h"

#include <errno.h>

namespace sofs21
{
    /* ********************************************************* */

//#if false
    /* Considering bn is the number of a data block containing references to
     * data blocks, return the value of its idx position
     */
    static uint32_t grpGetIndirectInodeBlock(uint32_t bn, uint32_t idx);

    /* Considering bn is the number of a data block containing references
     * to data blocks containing references to data blocks (double indirection),
     * return the value of its idx position
     */
    static uint32_t grpGetDoubleIndirectInodeBlock(uint32_t bn, uint32_t idx);
//#endif

    /* ********************************************************* */

    uint32_t grpGetInodeBlock(int ih, uint32_t ibn)
    {
        soProbe(301, "%s(%d, %u)\n", __FUNCTION__, ih, ibn);


        SOSuperblock* sbp = soGetSuperblockPointer();
        if(ih  > sbp->itotal ){
            throw SOException(EINVAL, __FUNCTION__);
        }

        SOInode* inode = soGetInodePointer(ih);

        if((ibn >= N_DIRECT + RPB + RPB*RPB) || (ibn < 0)){
            throw SOException(EINVAL, __FUNCTION__);
        }
        uint32_t aux;
        if(ibn < N_DIRECT){
            aux = inode->d[ibn];
        }
        else if(ibn < N_DIRECT + RPB){
            aux = grpGetIndirectInodeBlock(inode->i1, ibn - N_DIRECT);
        }
        else if(ibn < N_DIRECT + RPB + RPB*RPB){
            aux = grpGetDoubleIndirectInodeBlock(inode->i2, ibn);
        }
        return aux;
    }

    /* ********************************************************* */

//#if false
    static uint32_t grpGetIndirectInodeBlock(uint32_t bn, uint32_t idx)
    {
        soProbe(301, "%s(%d, %d)\n", __FUNCTION__, bn, idx);

        /* replace the following two lines with your code */

        if(bn == NullBlockReference) {
            return NullBlockReference;
        }

        uint32_t array[RPB];
        soReadDataBlock(bn, array);
        return array[idx];
    }
//#endif

    /* ********************************************************* */

//#if false
    static uint32_t grpGetDoubleIndirectInodeBlock(uint32_t bn, uint32_t idx)
    {
        soProbe(301, "%s(%d, %d)\n", __FUNCTION__, bn, idx);

        /* replace the following two lines with your code */
        
        if(bn == NullBlockReference) {
            return NullBlockReference;
        }

        uint32_t i2_idx = (idx - (RPB+N_DIRECT))/RPB;
        uint32_t i2_array[RPB];
        soReadDataBlock(bn, i2_array);
        uint32_t i1 = i2_array[i2_idx];
        uint32_t i1_idx = idx - N_DIRECT - (RPB*(i2_idx+1));
        
        return grpGetIndirectInodeBlock(i1, i1_idx);
    }
//#endif
}

