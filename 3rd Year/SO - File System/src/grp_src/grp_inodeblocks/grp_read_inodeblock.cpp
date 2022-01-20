/*
 *  \authur Artur Pereira - 2016-2021
 */
//Nome: João António Silva Viegas
//NMec: 98372
#include "inodeblocks.h"
#include "bin_inodeblocks.h"
#include "grp_inodeblocks.h"

#include "daal.h"
#include "core.h"
#include "devtools.h"

#include <string.h>
#include <inttypes.h>
#include <unistd.h>

namespace sofs21
{
    void grpReadInodeBlock(int ih, uint32_t ibn, void *buf)
    {
        soProbe(331, "%s(%d, %u, %p)\n", __FUNCTION__, ih, ibn, buf);

        // /* replace this comment and following line with your code */
        //binReadInodeBlock(ih, ibn, buf);
        uint32_t block =  soGetInodeBlock(ih,ibn); //Return number of the corresponding data block
        //soCheckInodeHandler(ih);
        uint16_t inode_number = soGetInodeNumber(ih);
        uint16_t max_index =  soGetSuperblockPointer()->itotal;
        if(inode_number >= max_index || inode_number<0){
            throw SOException(EINVAL,__FUNCTION__);
        }
        if(block == NullBlockReference){
            char32_t a[BlockSize] = {'\0'};
            buf = &a;
        }
        soReadDataBlock(block,buf);
    }
}

