#include "grp_mksofs.h"

#include "rawdisk.h"
#include "core.h"
#include "devtools.h"
#include "bin_mksofs.h"

#include <string.h>
#include <inttypes.h>

namespace sofs21
{
    void grpFillInSuperblock(const char *name, uint32_t ntotal, uint16_t itsize, uint32_t dbtotal)
    {
        soProbe(602, "%s(%s, %u, %u, %u)\n", __FUNCTION__, name, ntotal, itsize, dbtotal);

        SOSuperblock sb;
        sb.magic = MAGIC_NUMBER;
        sb.version = VERSION_NUMBER;
        sb.itotal = itsize*IPB;
        sb.ntotal = ntotal;
        sb.dbtotal = dbtotal;
        sb.dbfree = sb.dbtotal - 1;
        sb.dbp_start = ntotal - dbtotal;

        sb.rbm_start = 1 + itsize;
        sb.rbm_size = 1;
        sb.rbm_idx = 0;

        for(int i=0; i<sizeof(sb.name); i++)
            sb.name[i]=name[i];

        // free all inodes
        for(int i=0; i < MAX_INODES/32; i++)
            sb.ibitmap[i] = 0; 

        if(itsize == 1)
          sb.ibitmap[0] = (NullBlockReference >> 16) xor 0x1;    
        else
            sb.ibitmap[0] = NullBlockReference xor 0x1;         
      

        for (int i = 1; i < itsize/2; i++)
            sb.ibitmap[i] = NullBlockReference;               


        if(sb.itotal % 32 != 0)
            sb.ibitmap[(itsize/2) - 1] = (NullBlockReference >> 16) xor 0x1;
        else
            sb.ibitmap[(itsize/2) - 1] = NullBlockReference;


        sb.ifree = sb.itotal - 1;
        sb.iidx = 1;
        sb.iqhead = 0;
        sb.iqcount = 0;

        for(int i=0; i < DELETED_QUEUE_SIZE; i++)
            sb.iqueue[i] = NullInodeReference;

        for(int i=0; i < REF_CACHE_SIZE; i++){
            sb.insertion_cache.ref[i]=NullBlockReference; 
            sb.retrieval_cache.ref[i]=NullBlockReference; 
        }

        sb.insertion_cache.idx = 0;
        sb.retrieval_cache.idx = REF_CACHE_SIZE;

        soWriteRawBlock(0,&sb);
    }
};

