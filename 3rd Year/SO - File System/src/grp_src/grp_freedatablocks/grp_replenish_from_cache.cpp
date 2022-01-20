/*
 *  \author António Rui Borges - 2012-2015
 *  \authur Artur Pereira - 2016-2020
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
    void grpReplenishFromCache(void)
    {
        soProbe(443, "%s()\n", __FUNCTION__);

        /* replace this comment and following line with your code */
        // binReplenishFromCache();

        SOSuperblock *sb_pointer = soGetSuperblockPointer();

        if(sb_pointer->retrieval_cache.idx != REF_CACHE_SIZE){
            return;
        }

        uint32_t n = sb_pointer->insertion_cache.idx;

        for(uint32_t i1 = 0, i2 = REF_CACHE_SIZE - n; i2 < n; i1++, i2++){
            sb_pointer->retrieval_cache.ref[i1] = sb_pointer->insertion_cache.ref[i2];
            sb_pointer->insertion_cache.ref[i2] = NullBlockReference;
        }

        sb_pointer->retrieval_cache.idx = REF_CACHE_SIZE - n;
        sb_pointer->insertion_cache.idx = 0;

        soSaveSuperblock();
        
    }
};

