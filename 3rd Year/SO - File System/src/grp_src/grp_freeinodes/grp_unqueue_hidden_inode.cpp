/*
 *  \author António Rui Borges - 2012-2015
 *  \authur Artur Pereira - 2016-2020
 */
//Nome: João António Silva Viegas
//NMec: 98372
#include "freeinodes.h"
#include "bin_freeinodes.h"
#include "grp_freeinodes.h"

#include <stdio.h>
#include <errno.h>
#include <inttypes.h>
#include <time.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <string.h>

#include <iostream>

#include "core.h"
#include "devtools.h"
#include "daal.h"
namespace sofs21
{
    uint16_t grpUnqueueHiddenInode()
    {
        /* replace this comment and following line with your code */
        //return binUnqueueHiddenInode();
        soProbe(404, "%s()\n", __FUNCTION__);
        uint16_t *queue = soGetSuperblockPointer()->iqueue;
        uint8_t iqhead = soGetSuperblockPointer()->iqhead;
        uint8_t num_elem = soGetSuperblockPointer()->iqcount;
        uint8_t i;
        if (num_elem == 0){
            return NullInodeReference;
        }
        uint16_t old_idx = queue[iqhead];
        
        queue[iqhead] = NullInodeReference;
        soGetSuperblockPointer()->iqcount-=1;
        if (iqhead == 35){
            soGetSuperblockPointer()->iqhead=0;
        }else{
            soGetSuperblockPointer()->iqhead+=1;
        }           
        soSaveSuperblock();
        return old_idx;
        
    }
};


