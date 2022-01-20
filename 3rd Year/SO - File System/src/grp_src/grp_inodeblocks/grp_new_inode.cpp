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
#include <unistd.h>

namespace sofs21
{
    uint16_t grpNewInode(uint16_t type, uint16_t perm)
    {
        soProbe(333, "%s(%04x, %9o)\n", __FUNCTION__, type, perm);

        /* replace this comment and following line with your code */
        return binNewInode(type, perm);

        // Check if type is valid
		if (!(type == S_IFREG || type == S_IFDIR || type == S_IFLNK))
		{
			printf("\n error");
			throw SOException(EINVAL, __FUNCTION__);
		}
		if (!(perm > 0 && perm < 0777))
		{
			printf("\n error");
			throw SOException(EINVAL, __FUNCTION__);
		}

		// Check for free inodes
		uint16_t n = soAllocInode();
		uint16_t mode = type | perm;

		if (n == NullInodeReference) {
			uint16_t in_number = soUnqueueHiddenInode();
			
            if (in_number == NullInodeReference) {
				throw SOException(ENOSPC, __FUNCTION__);
			}

			int in_handler = soOpenInode(in_number);
			SOInode *in_pointer = soGetInodePointer(in_handler);
			soFreeInodeBlocks(in_handler, 0);
			soSaveInode(in_handler);

			in_pointer->mode = mode;
			in_pointer->owner = getuid();
			in_pointer->group = getgid();
			uint32_t current_time = 0;                  
			in_pointer->atime = current_time;
			in_pointer->ctime = current_time;
			in_pointer->mtime = current_time;

			soCloseInode(in_handler);
			soSaveSuperblock();
			return in_number;
		}
		else {
			uint16_t in_number = soUnqueueHiddenInode(); 
			int in_handler = soOpenInode(in_number);
			SOInode *in_pointer = soGetInodePointer(n);
			soFreeInodeBlocks(in_handler, 0);
			soSaveInode(in_handler);

			in_pointer->mode = mode;
			in_pointer->owner = getuid();
			in_pointer->group = getgid();
			uint32_t current_time = 0; 
			in_pointer->atime = current_time;
			in_pointer->ctime = current_time;
			in_pointer->mtime = current_time;

			soCloseInode(in_handler);
			soSaveSuperblock();
			return n;
		}
    }
};

