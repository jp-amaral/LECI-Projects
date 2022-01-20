/*
 *  \author António Rui Borges - 2012-2015
 *  \authur Artur Pereira - 2016-2020
 */

//Autor : João Amaral 
//Nmec : 98373

#include "freedatablocks.h"
#include "bin_freedatablocks.h"
#include "grp_freedatablocks.h"

#include "core.h"
#include "devtools.h"
#include "daal.h"

#include <stdio.h>
#include <errno.h>
#include <string.h>
#include <iostream>
using namespace std;

namespace sofs21
{
    /* only fill the current block to its end */
    void grpDeplete(void)
    {
        soProbe(444, "%s()\n", __FUNCTION__);

        SOSuperblock* sbp = soGetSuperblockPointer();

        //Dividir por 8k, depois dividir isso inteiramente por 32. O resultado da divisao é o indice do bloco a aceder, o resto é o bit que se tem que por a 1

        //Se a cache não estiver cheia
        if(sbp->insertion_cache.idx  < REF_CACHE_SIZE){
            return;
        }

        for(int i = 0; i < REF_CACHE_SIZE; i++){
            //Transfer the reference from insertion_cache to bitmap
                //Get the reference of the free data block
                uint32_t bn  = sbp->insertion_cache.ref[i];
                //Dividir inteiramente a referencia por 8k
                uint32_t b = bn / (8 * BlockSize);
                uint32_t r = bn % (8 * BlockSize);


                //Get the bitmap pointer
                uint32_t* bt = soGetBitmapBlockPointer(b);
                //Find the word index
                uint32_t w = r / 32;
                //Get the word bases on its index
                uint32_t current_word = bt[w];
                //Get the bit that needs to change to 1
                uint32_t bp = r % 32;
                
                //Operations to set bit
                uint32_t aux = 1 << bp;
                uint32_t final_word = current_word | aux;
                //Save the new word to bitmap
                bt[w] = final_word;
                soSaveBitmapBlock();

            //....

            sbp->insertion_cache.ref[i] = NullBlockReference;
            
            if(sbp->rbm_idx == NullBlockReference){
                sbp->rbm_idx = 0;
            }
                

        }
        //Reset insertion_cache idx
        sbp->insertion_cache.idx = 0;
        soSaveSuperblock();
        soSaveBitmapBlock();
    }
};

