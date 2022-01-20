/*
 *  \author António Rui Borges - 2012-2015
 *  \authur Artur Pereira - 2016-2021
 */

#include "freeinodes.h"
#include "bin_freeinodes.h"
#include "grp_freeinodes.h"

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
    void grpFreeInode(uint16_t in)
    {
        soProbe(402, "%s(%u)\n", __FUNCTION__, in);
        
        if (in < 0 || in > MAX_INODES){
            throw SOException(EINVAL, __FUNCTION__);
        }

        int ih = soOpenInode(in);
        uint32_t aux = in/32;
        

        SOSuperblock* sbPointer = soGetSuperblockPointer();
        SOInode* inodePointer = soGetInodePointer(ih);
    
        uint32_t word = sbPointer->ibitmap[aux];

        uint32_t pos = in % 32;
        uint32_t mask = 1 << pos;         


        uint32_t finalword = (mask | word);
        sbPointer->ibitmap[aux] = finalword;

        sbPointer->ifree = sbPointer->ifree + 1;
        sbPointer->iidx = sbPointer->iidx + 1;


        inodePointer->mode = 0;
        inodePointer->owner = 0;
        inodePointer->group = 0;
        
        soSaveInode(ih);
        soCloseInode(ih);
        soSaveSuperblock();
    }
};

