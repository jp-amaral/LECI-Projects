/*
 *  \author António Rui Borges - 2012-2015
 *  \authur Artur Pereira - 2016-2020
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
#include <sys/stat.h>
#include <string.h>

#include <iostream>

#include "core.h"
#include "devtools.h"
#include "daal.h"
// Autor : Bruno Bragues Costa Lemos
// Nmec  : 98221
namespace sofs21
{
    bool grpHideInode(uint16_t in)
    {
        soProbe(403, "%s(%u)\n", __FUNCTION__, in);

        SOSuperblock *pointer_block = soGetSuperblockPointer();         //pointer to the block
        int inodehandler = soOpenInode(in);                             //open the inode
        SOInode *pointer_node = soGetInodePointer(inodehandler);        //pointer to the inode

        if(in > pointer_block->itotal){
            throw SOException(EINVAL, __FUNCTION__);         // if given inode number is not valid, EINVAL exception must be thrown
        }
        if(pointer_block->iqcount == DELETED_QUEUE_SIZE){  //if the deleted queue is full 
            return false;
        }
        pointer_node->mode = ~pointer_node->mode; //complementear [0 passa a 1 e 1 passa a 0]
        uint8_t index = (pointer_block->iqhead + pointer_block->iqcount)%DELETED_QUEUE_SIZE;
        pointer_block->iqueue[index]=in;
        pointer_block->iqcount +=1;
        soSaveInode(inodehandler);
        soCloseInode(inodehandler);  // close the inodehandler
        soSaveSuperblock();
        return true;
        //return binHideInode(in);
    }
};