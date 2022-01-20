#include "grp_mksofs.h"
#include "rawdisk.h"
#include "core.h"
#include "devtools.h"
#include "bin_mksofs.h"
#include <string.h>
#include <inttypes.h>
// Autor : Bruno Bragues Costa Lemos
// Nmec  : 98221
namespace sofs21{
    void grpZeroFreeDataBlocks(uint32_t ntotal, uint16_t itsize, uint32_t dbtotal){
        soProbe(607, "%s(%u, %u, %u)\n", __FUNCTION__, ntotal, itsize, dbtotal);
        u_int32_t buff[RPB] = {0x0};
        u_int32_t nblockbitmap = ntotal - dbtotal - itsize +1 ;
        for(u_int32_t i=nblockbitmap + itsize ; i<ntotal; i++) {
            soWriteRawBlock(i, buff);
        }
        //binZeroFreeDataBlocks(ntotal, itsize, dbtotal);
    }
}