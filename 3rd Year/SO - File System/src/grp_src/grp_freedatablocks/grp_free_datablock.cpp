/*
 *  \author António Rui Borges - 2012-2015
 *  \authur Artur Pereira - 2016-2020
 */

//Autor : João Amaral 
//Nmec : 98373

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
    void grpFreeDataBlock(uint32_t bn)
    {
        soProbe(442, "%s(%u)\n", __FUNCTION__, bn);

        SOSuperblock* sbp = soGetSuperblockPointer();
        
        //STILL NEED TO VERIFY THE BLOCK NUMBER (EXCEPTION EINVAL)
        //...
        //not correct
        if(bn > sbp->dbtotal){
            throw SOException(EINVAL, __FUNCTION__);
        }
        

        //If insertion cache is full (first free idx is greater than the last possible)
        if(sbp->insertion_cache.idx >= REF_CACHE_SIZE){
            //We call the soDeplete function
            soDeplete();
        }
        //The reference (bn) is inserted in the first empty cell (insertion_cache.idx) of the insertion cache
        sbp->insertion_cache.ref[sbp->insertion_cache.idx] = bn;
        //We increase the number of free datablocks
        sbp->dbfree++;
        //We increse the idx of the next free cell
        sbp->insertion_cache.idx++;

        soSaveSuperblock();
    }
};

