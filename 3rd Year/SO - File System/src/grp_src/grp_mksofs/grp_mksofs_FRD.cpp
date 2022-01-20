#include "grp_mksofs.h"

#include "rawdisk.h"
#include "core.h"
#include "devtools.h"
#include "bin_mksofs.h"

#include <string.h>
#include <inttypes.h>

namespace sofs21
{
    /*
       filling in the contents of the root directory:
       the first 2 entries are filled in with "." and ".." references
       the remainding of the block is filled with zeros.
       */
    void grpFillInRootDir(uint32_t ntotal, uint16_t itsize, uint32_t dbtotal)
    {
        soProbe(606, "%s(%u, %u, %u)\n", __FUNCTION__, ntotal, itsize, dbtotal);

        /* replace this comment and following line with your code */
        // binFillInRootDir(ntotal, itsize, dbtotal);

        SODirectorySlot dirEntry[DPB];  // DPB --> numero de direntries por bloco

        dirEntry[0].in = 0;
        dirEntry[1].in = 0;
        strcpy(dirEntry[0].nameBuffer, ".");
        strcpy(dirEntry[0].nameBuffer, ".");

        for(int i = 2; i < DPB; i++) {
            dirEntry[i].in = NullInodeReference;
            strcpy(dirEntry[i].nameBuffer, "\0");
        }

        soWriteRawBlock(ntotal - dbtotal, dirEntry);    // ntotal - dbtotal --> inicio do data block pool
        

        



    }
};

