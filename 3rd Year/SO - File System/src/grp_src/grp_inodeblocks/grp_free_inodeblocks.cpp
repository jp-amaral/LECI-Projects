/*
 *  \authur Artur Pereira - 2016-2021
 */


//Autor : João Amaral 
//Nmec : 98373
#include "inodeblocks.h"
#include "bin_inodeblocks.h"
#include "grp_inodeblocks.h"

#include "freedatablocks.h"
#include "daal.h"
#include "core.h"
#include "devtools.h"

#include <inttypes.h>
#include <errno.h>
#include <assert.h>

#define CHANGED 0x1
#define NOT_EMPTY 0x2

namespace sofs21
{

    /* free all blocks between positions idx and RPB - 1
        * existing in the block of references passed as argument.
        * The return value has the following meaning:
        * - bit CHANGED is raised if the block of references changed
        * - bit NOT_EMPTY is raised if the block of references contains non NullBlockReference references
        */
    static uint32_t grpFreeIndirectInodeBlocks(int ih, uint32_t *ref, uint32_t idx);


    /* free all blocks between positions idx and RPB*RPB - 1
        * covered by the block of indirect references passed as argument.
        * The return value has the following meaning:
        * - bit CHANGED is raised if the block of indirect references changed
        * - bit NOT_EMPTY is raised if the block of indirect references contains non NullBlockReference references
        */
    static uint32_t grpFreeDoubleIndirectInodeBlocks(int ih, uint32_t *iref, uint32_t idx);

    /* ********************************************************* */

    void grpFreeInodeBlocks(int ih, uint32_t fibn)
    {
        soProbe(303, "%s(%d, %u)\n", __FUNCTION__, ih, fibn);

        // /* replace this comment and following line with your code */
        // binFreeInodeBlocks(ih, fibn);

        //FALTA DAR CHECK DO INODE HANDLER

        SOSuperblock* sbp = soGetSuperblockPointer();
        if(ih  > sbp->itotal ){
            throw SOException(EINVAL, __FUNCTION__);
        }

        if((fibn > N_DIRECT + RPB + RPB*RPB) || (fibn < 0)){
            throw SOException(EINVAL, __FUNCTION__);
        }

        SOInode* inode = soGetInodePointer(ih);

        if (fibn > N_DIRECT + RPB + RPB*RPB){
            return;
        }

        //Primeiro caso: fibn é menor que o N_DIRECT, ou seja, temos que libertar o resto do inode.d[], o i1 e o i2
        if (fibn < N_DIRECT){
            //limpa o resto do inode.d[]
            for(int i = fibn;i<N_DIRECT;i++){
                if(inode->d[i]!=NullBlockReference){
                    soFreeDataBlock(inode->d[i]);
                }
                inode->d[i] = NullBlockReference;
            }

            //limpa o i1
            if(inode->i1 != NullBlockReference){
                grpFreeIndirectInodeBlocks(ih, &inode->i1, N_DIRECT);
            }

            //limpa o i2
            if(inode->i2 != NullBlockReference){
                grpFreeDoubleIndirectInodeBlocks(ih, &inode->i2, N_DIRECT + RPB);
            }
        }


        //Segundo caso: fibbn e maior ou igual a N_DIRECT mas e menor que N_DIRECT + RPB (ainda esta dentro do i1)
        if((fibn >= N_DIRECT) && (fibn < N_DIRECT + RPB)){
            //limpa o i1
            if(inode->i1 != NullBlockReference){
                grpFreeIndirectInodeBlocks(ih, &inode->i1, fibn);
            }

            //limpa o i2
            if(inode->i2){
                grpFreeDoubleIndirectInodeBlocks(ih, &inode->i2, N_DIRECT + RPB);
            }
        }


        //Terceiro caso : fibn e maior ou igual a RPB + N_DIRECT (dentro da gama do i2)
        if(fibn >= N_DIRECT + RPB){
            if(inode->i2){
                grpFreeDoubleIndirectInodeBlocks(ih, &inode->i2, fibn);
            }
        }

    }

    /* ********************************************************* */
    static uint32_t grpFreeIndirectInodeBlocks(int ih, uint32_t *ref, uint32_t idx)
    {
        soProbe(303, "%s(%d, %p, %u)\n", __FUNCTION__, ih, ref, idx);

        // /* replace this comment and following line with your code */
        // throw SOException(ENOSYS, __FUNCTION__); 

        //SOInode* inode = soGetInodePointer(ih);

        //printf("idx dentro do i1:%d", idx);

        uint32_t array[RPB];
        soReadDataBlock(*ref, array);

        //uint32_t j = N_DIRECT;
        //uint32_t aux = (idx - N_DIRECT);

        for(long unsigned int i = 0; i < RPB; i++){
            if((i + N_DIRECT) >= idx){
                if(array[i] != NullBlockReference){
                    //printf("dentro do i1, limpou o bloco: %d\n", array[i]);
                    soFreeDataBlock(array[i]);
                    array[i] = NullBlockReference;
                }
            }
        }
        soWriteDataBlock(*ref, array);

        //Verificacao se tudo dentro do i1 ficou null
        uint32_t confirmation = 0;
        for(uint32_t i=0; i < RPB;i++){
            if(array[i] == NullBlockReference){
                confirmation++;
            }
        }
        //Se o numero de posicoes de pointeiros a null dentro do bloco for igual ao tamanho do bloco, este ficou todo vazio e podemos por a null
        if(confirmation == RPB){
            *ref = NullBlockReference;
        }
        return 0;
    }

    /* ********************************************************* */


    static uint32_t grpFreeDoubleIndirectInodeBlocks(int ih, uint32_t *iref, uint32_t idx)
    {
        soProbe(303, "%s(%d, %p, %u)\n", __FUNCTION__, ih, iref, idx);

        // /* replace this comment and following line with your code */
        // throw SOException(ENOSYS, __FUNCTION__); 
        idx = idx - N_DIRECT;

        //SOInode* inode = soGetInodePointer(ih);

        uint32_t array[RPB];
        soReadDataBlock(*iref, array);

        uint32_t j = RPB;
        int flag = 0;
        uint32_t aux = (idx % RPB );
        for(long unsigned int i = 0; i < RPB; i++){
            //Se ja libertou o primeiro bloco (completamente ou parte dele), pode livremente libertar os seguintes
            if(flag == 1){
                if(array[i] != NullBlockReference){
                    //printf("entrou dentre deste i1 do i2: %d\n", array[i]);
                    grpFreeIndirectInodeBlocks(ih, &array[i], 0);
                }
            }
            //printf("aux + j: %d\n", j + aux);
            if(((j + aux) >= idx) && (flag == 0)){
                if(array[i] != NullBlockReference){
                    //printf("entrou dentre deste i1 do i2: %d\n", array[i]);
                    grpFreeIndirectInodeBlocks(ih, &array[i], aux+N_DIRECT);
                }
                flag = 1;
            }
            j += RPB;
        }
        soWriteDataBlock(*iref, array);

        //Verificacao se tudo dentro do i1 ficou null
        int confirmation = 0;
        for(uint32_t i=0; i < RPB;i++){
            if(array[i] == NullBlockReference){
                confirmation++;
            }
        }
        //printf("numero de nulls dentro do block %d: %d", *iref, confirmation);
        //Se o numero de posicoes de pointeiros a null dentro do bloco for igual ao tamanho do bloco, este ficou todo vazio e podemos por a null
        if(confirmation == RPB){
            *iref = NullBlockReference;
        }
        return 0;
    }
    /* ********************************************************* */
}
