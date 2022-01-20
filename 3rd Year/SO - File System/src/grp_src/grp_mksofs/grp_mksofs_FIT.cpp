//Nome: João António Silva Viegas
//NMec: 98372

#include "grp_mksofs.h"

#include "rawdisk.h"
#include "core.h"
#include "devtools.h"
#include "bin_mksofs.h"

#include <string.h>
#include <time.h>
#include <unistd.h>
#include <sys/stat.h>
#include <inttypes.h>
#include <inode.h>

namespace sofs21
{
    void grpFillInInodeTable(uint16_t itsize, bool date)
    {
        soProbe(604, "%s(%u)\n", __FUNCTION__, itsize);

        /* replace this comment and following line with your code */
        //binFillInInodeTable(itsize, date);
        // SOInode inodes[IPB]; 
        // soWriteRawBlock #utilizar para introduzar informaçao de o bloco esta inicializado com um "Inode Limpo"

        SOInode Inodes[IPB];
        uint16_t aut = (S_IFDIR|0755);
        //Falta fazer ponteiros
        for(unsigned long i = 1;i<=itsize;i++){
            for(unsigned long k = 0; k<IPB;k++){
                if(i == 1 &&k == 0){
                    Inodes[k].mode = aut;
                    Inodes[k].lnkcnt = 2;
                    Inodes[k].owner = getuid();
                    Inodes[k].group = getuid();
                    Inodes[k].size = BlockSize;
                    Inodes[k].blkcnt = 1;
                    if(date){
                        Inodes[k].atime=time(NULL);
                        Inodes[k].mtime=time(NULL);
                        Inodes[k].ctime=time(NULL);
                    }else{
                        Inodes[k].atime=0;
                        Inodes[k].mtime=0;
                        Inodes[k].ctime=0;
                    }
                }else{
                    Inodes[k].mode = 0;
					Inodes[k].lnkcnt = 0;
					Inodes[k].owner = 0;
					Inodes[k].group = 0;
					Inodes[k].size = 0;
					Inodes[k].blkcnt = 0; 
					Inodes[k].atime = 0;
					Inodes[k].mtime = 0;
					Inodes[k].ctime = 0;
                }
                for(int idx=0;idx<N_DIRECT;idx++){
                    if(k == 0 && idx == 0){
                        Inodes[k].d[idx] =0;
                    }else{
                        Inodes[k].d[idx] = NullBlockReference;
                    }
                    Inodes[k].i1 = NullBlockReference;
                    Inodes[k].i2 = NullBlockReference;
                }
            }
            soWriteRawBlock(i,&Inodes);
        }
    }
};

