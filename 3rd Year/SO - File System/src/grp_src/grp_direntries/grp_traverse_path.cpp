#include "direntries.h"

#include "core.h"
#include "devtools.h"
#include "daal.h"
#include "inodeblocks.h"
#include "direntries.h"
#include "bin_direntries.h"

#include <errno.h>
#include <string.h>
#include <libgen.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/stat.h>

namespace sofs21
{
    uint16_t grpTraversePath(char *path)
    {
        soProbe(221, "%s(%s)\n", __FUNCTION__, path);

        /* replace this comment and following line with your code */
        //return binTraversePath(path);

        if(strcmp(path,"/")==0){
            return 0;
        }

        char *baseName = basename(strdupa(path));
        char *dirName = dirname(strdupa(path));

        uint32_t inode = grpTraversePath(dirName);

        uint32_t ih = soOpenInode(inode);
        SOInode* ip = soGetInodePointer(ih);

        if((ip->mode & S_IFDIR) != S_IFDIR){
            throw SOException(ENOTDIR, __FUNCTION__);
        }

        if(!soCheckInodeAccess(ih, X_OK)){
            throw SOException(EACCES, __FUNCTION__);
        }
            
        uint32_t in = soGetDirentry(ih,baseName);

        if(in == NullInodeReference)
            throw SOException(ENOENT, __FUNCTION__);
        

        soCloseInode(ih);
        return in;
    }
};