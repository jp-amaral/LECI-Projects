//Nome: João António Silva Viegas
//NMec: 98372
#include "grp_mksofs.h"

#include "rawdisk.h"
#include "core.h"
#include "devtools.h"
#include "bin_mksofs.h"

#include <inttypes.h>
#include <string.h>
#include <daal.h>
#include <stdio.h>

namespace sofs21
{
    void grpFillInBitmapTable(uint32_t ntotal, uint16_t itsize, uint32_t dbtotal)
    {
        soProbe(605, "%s(%u, %u, %u)\n", __FUNCTION__, ntotal, itsize, dbtotal);

        /* replace this comment and following line with your code */
        //binFillInBitmapTable(ntotal, itsize, dbtotal);

        uint32_t bitmap_start = 1 + itsize;
        uint32_t nblocks = ntotal - dbtotal - itsize + 1;

        for (uint32_t b = 0; b < nblocks; b++) { // Percorre todos os blocos do bitmap
            uint32_t bitmap[RPB];               
            memset(bitmap, 0x00, RPB*4);         //Todos os blocos do bitmap são postos a 0x00
            for (uint32_t i = 0; i < dbtotal; i++) { //Todos os bits do bitmap são percorridos
                auto* word = &bitmap[i/32];          
                *word = *word | (1 << i % 32);          //Ultimo bit da word é colocado a 0
            }
            if(b == 0){
                bitmap[0] = bitmap[0] & ~1;
            }
            soWriteRawBlock(bitmap_start + b, bitmap);  //Escreve no bloco de bitmap
        }
    }
};

