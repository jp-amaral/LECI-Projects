#include "direntries.h"

#include "core.h"
#include "devtools.h"
#include "daal.h"
#include "inodeblocks.h"
#include "bin_direntries.h"

#include <errno.h>
#include <string.h>
#include <sys/stat.h>

namespace sofs21
{
    bool grpCheckDirEmpty(int ih)
    {
        soProbe(205, "%s(%d)\n", __FUNCTION__, ih);
        soCheckInodeAccess(ih,R_OK);
        SOInode* Ip = soGetInodePointer(ih);            //pointer para o inode a verificar
        if ((Ip->mode & S_IFDIR) != S_IFDIR){
            throw SOException(ENOTDIR, __FUNCTION__);
        }

        uint32_t size = (Ip->blkcnt) ;

        for(unsigned i=0; i<size; i++){
            SODirectorySlot dir[DPB];
            soReadInodeBlock(ih,i,dir);
            for(unsigned j = 0; j<DPB;j++){             // =2 por causa do . e ..
                if(dir[j].nameBuffer[0] != '\0'){
                    return false;
                }
            }
        }
        return true;

        /* replace this comment and following line with your code */
        //return binCheckDirEmpty(ih);
    }
};