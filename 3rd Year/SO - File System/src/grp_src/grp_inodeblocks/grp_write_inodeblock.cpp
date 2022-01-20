/*
 *  \authur Artur Pereira - 2016-2021
 */

#include "inodeblocks.h"
#include "bin_inodeblocks.h"
#include "grp_inodeblocks.h"

#include "daal.h"
#include "core.h"
#include "devtools.h"

#include <string.h>
#include <inttypes.h>
#include <assert.h>

namespace sofs21
{
    void grpWriteInodeBlock(int ih, uint32_t ibn, void *buf)
    {
        soProbe(332, "%s(%d, %u, %p)\n", __FUNCTION__, ih, ibn, buf);

        // the user has read permissions
        soCheckInodeAccess(ih, R_OK);
        
        uint32_t inBlock = soGetInodeBlock(ih, ibn);

        if (inBlock == NullBlockReference){ 
            inBlock = soAllocInodeBlock(ih, ibn); 
        }
        soWriteDataBlock(inBlock, buf);
    }
};

