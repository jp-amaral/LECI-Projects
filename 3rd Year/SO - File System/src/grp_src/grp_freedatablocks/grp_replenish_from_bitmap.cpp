/*
 *  \author AntÃ³nio Rui Borges - 2012-2015
 *  \authur Artur Pereira - 2016-2021
 */

#include "freedatablocks.h"
#include "bin_freedatablocks.h"
#include "grp_freedatablocks.h"

#include <string.h>
#include <errno.h>
#include <iostream>

#include "core.h"
#include "devtools.h"
#include "daal.h"

namespace sofs21
{
    void grpReplenishFromBitmap(void)
    {
        soProbe(445, "%s()\n", __FUNCTION__);

        /* replace this comment and following line with your code */
        //binReplenishFromBitmap();
        
        SOSuperblock* sbp = soGetSuperblockPointer();                                
        int empty_cache;                                                            
        int free_bits = sbp->dbfree - sbp->insertion_cache.idx;                       
        if (free_bits >= REF_CACHE_SIZE)
            free_bits = REF_CACHE_SIZE;                 
                                                                                    
        // cache ->  empty
        if (sbp->retrieval_cache.idx == REF_CACHE_SIZE) 
            empty_cache = 1; 
        else 
            empty_cache = 0;

        if (empty_cache == 1) {
            for (int block = free_bits; block > 0;) {
                int num_block = sbp->rbm_idx / (BlockSize*8);                        
                int aux_bitblock = sbp->rbm_idx % (BlockSize*8);
                int word = aux_bitblock / 32;
                int bit = aux_bitblock % 32;

                uint32_t* bitmap = soGetBitmapBlockPointer(num_block);
                uint32_t mask = 1 << bit;

                //  bit=1 -> block is free
                if ( (bitmap[word] & mask) ) {
                    sbp->retrieval_cache.ref[REF_CACHE_SIZE - block] = sbp->rbm_idx;
                    bitmap[word] &= ~mask; 
                    soSaveBitmapBlock();
                    sbp->retrieval_cache.idx--; 
                    block--;
                }
                sbp->rbm_idx++;
            }
        }
        
        // cbitmap->empty
        if (sbp->dbfree - sbp->insertion_cache.idx == REF_CACHE_SIZE)
            sbp->rbm_idx = NullBlockReference;

        soSaveSuperblock();
    }
};