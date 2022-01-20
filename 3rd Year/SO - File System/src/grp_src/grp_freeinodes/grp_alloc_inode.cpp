/*
 *  \author António Rui Borges - 2012-2015
 *  \authur Artur Pereira - 2016-2020
 */

//Autor : João Amaral 
//Nmec : 98373

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
    uint16_t grpAllocInode()
    {
        soProbe(401, "%s()\n", __FUNCTION__);

        /* replace this comment and following line with your code */
        
        SOSuperblock* sbp = soGetSuperblockPointer();

        uint16_t max = sbp->itotal + sbp->iidx;

        //Percorrer todas as 32bit words do bitmap
        for(uint16_t i = sbp->iidx; i < max; i++, sbp->iidx++){

            //Circularidade 
            if(sbp->iidx >= sbp->itotal) sbp->iidx = 0;
            uint16_t index = sbp->iidx / 32;        //Indice da 32word do bitmap
            uint16_t bit_pos = sbp->iidx % 32;      //Bit position (0 .. 31)

            uint32_t word = sbp->ibitmap[index];    //Vai buscar a 32bit word atual

            
            uint32_t mask = 1 << bit_pos;           //Criamos uma mascara (ex 0000 0000 0000 0001 0000 0000 0000 0000)
            
            uint32_t result = (mask & word);        //Aplicamos essa mascara para isolar o bit atual
            
            if(result != 0){                        //Se esse bit estiver a 1
                
                word = word & ~mask;                //Pomos o bit a 0
                
                sbp->ibitmap[index] = word;         //Voltamos a guardar no bitmap
                
                sbp->ifree--;                       //Diminuimos o numero de inodes livres
                
                
                
                uint32_t aux = sbp->iidx;
                sbp->iidx++;
                if(sbp->iidx == sbp->itotal) sbp->iidx = 0;
                soSaveSuperblock();                 //Guardamos o SuperBlock;            
                return aux;
            }
        }
        
        return NullInodeReference;                  //Return NullInodeReference se não houver nenhum inode livre
    }
};

