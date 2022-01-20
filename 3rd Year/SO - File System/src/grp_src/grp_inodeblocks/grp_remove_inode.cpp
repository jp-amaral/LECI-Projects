/*
 *  \authur Artur Pereira - 2016-2021
 */

#include "inodeblocks.h"
#include "bin_inodeblocks.h"
#include "grp_inodeblocks.h"
#include "freeinodes.h"

#include "daal.h"
#include "core.h"
#include "devtools.h"

#include <string.h>
#include <inttypes.h>

namespace sofs21
{
    void grpRemoveInode(uint16_t in)
    {
        soProbe(334, "%s(%d)\n", __FUNCTION__, in);

        /* replace this comment and following line with your code */
        //binRemoveInode(in);

        bool x = soHideInode(in);
        if(x == false){
            uint16_t u_in = soUnqueueHiddenInode();
            int i_in = soOpenInode(u_in);
            soFreeInodeBlocks(i_in, 0);
			soSaveInode(i_in);
			soFreeInode(u_in);
			soHideInode(u_in);
        }
        
    }
};

