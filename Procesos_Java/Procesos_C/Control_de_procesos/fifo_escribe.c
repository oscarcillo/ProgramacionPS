//escribe texto en el pipo fifo

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(void){

  int fifo;
  char saludo[] = "Un saludo!!!\n", buffer[10];

  fifo=open("FIFO",1);

  if (fifo==-1)
    {
    printf("ERROR al abrir el FIFO...)\n" );
    exit(0);
   }

  printf("Enviando datos al FIFO...");
  write(fifo, saludo, strlen(saludo));
  close(fifo);

  return 0;
}
