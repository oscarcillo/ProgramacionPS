/* mfifo (char * pathname, mode_t mode); -> 0 si todo OK / -1 no todo ok

S_IFREG -> Normal
S_IFCHAR -> caracteres
S_IFBLK -> Bloques
S_IFIFO -> Crear fifo */

#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h> // parametros de mkfifo
#include <sys/stat.h> // librerias que necesita mkfifo
#include <fcntl.h> // librerias que necesita mkfifo

int main(void){

  int fp;
  int p, bytesleidos;
  char buffer[10];

  p=mkfifo("FIFO", S_IFIFO); //permiso de lectura y escritura

  if (p==-1)
  {
    printf("ERROR al crear el FIFO...\n");
    exit(0);
  }

  while(1)
  {
    fp=open("FIFO",0);

    bytesleidos= read(fp,buffer,1);

    printf("Recogiendo datos del pipe...");

    while(bytesleidos != 0)
    {
      printf("%1c", buffer[0]);
      bytesleidos= read(fp,buffer,1);
    }
    close(fp);
  }
  return 0;
}
