/*Ejemplo de uso para lectura y escritura de un fichero*/

#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <string.h>

int main(){

  char mensaje[] = "Hola\n";
  char buffer[10];
  int fd, bytesLeidos;//fd quiere decir descriptor del fichero

  //Hay que poner un 0 para lectura
  // 1 para escritura
  // 2 para lectura escritura

  //Abrimos el fichero para escritura (1)
  fd = open("fichero.txt",1);

  if(fd == -1){
    	printf("Error al abrir el fichero\n");
      exit(-1);
  }
  //Vamos a escribir en el fichero
  printf("Vamos a comenzar a escribir en el fichero\n\n");
  write(fd,mensaje,strlen(mensaje));
  close(fd);

  //Abrimos el fichero para lectura (0)
  fd = open("fichero.txt",0);
  //Ahora vamos a leer el fichero
  printf("Vamos a comenzar a leer en el fichero\n");
  bytesLeidos = read(fd,buffer,1);//Ponemos un 1 porque vamos a leer un bytesLeidos
  while(bytesLeidos!=0){
    printf("%1c",buffer[0]);
    bytesLeidos=read(fd,buffer,1);
  }
  close(fd);
}
