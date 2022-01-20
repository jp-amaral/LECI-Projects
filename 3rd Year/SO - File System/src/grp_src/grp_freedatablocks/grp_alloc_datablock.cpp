/*
 *  \author António Rui Borges - 2012-2015
 *  \authur Artur Pereira - 2009-2020
 */

#include "freedatablocks.h"
#include "bin_freedatablocks.h"
#include "grp_freedatablocks.h"

#include <stdio.h>
#include <errno.h>
#include <inttypes.h>
#include <time.h>
#include <unistd.h>
#include <sys/types.h>

#include "core.h"
#include "devtools.h"
#include "daal.h"

namespace sofs21
{
    uint32_t grpAllocDataBlock()
    {
        soProbe(441, "%s()\n", __FUNCTION__);

        /* replace this comment and following line with your code */
        //return binAllocDataBlock();

        SOSuperblock* SB = soGetSuperblockPointer();

        // se não houverem free datablocks
        if(SB->dbfree == 0)
            throw SOException(ENOSPC, __FUNCTION__);


        if(SB->retrieval_cache.idx == REF_CACHE_SIZE)
            soReplenishFromBitmap();
        else
            soReplenishFromCache();

        
        SB->dbfree -= 1;
        uint32_t aux = SB->retrieval_cache.ref[SB->retrieval_cache.idx];
        SB->retrieval_cache.ref[SB->retrieval_cache.idx] = NullBlockReference;
        SB->retrieval_cache.idx++;

        soSaveSuperblock();
        
        return aux;
    }
};
