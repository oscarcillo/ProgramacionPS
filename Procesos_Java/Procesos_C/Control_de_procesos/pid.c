/*Ejemplo de uso de las funciones para obtener el PID de los procesos*/
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>

int main(){

  //Cunado haces introduces en la terminal ps te sale el PID, para obtenerlo se utiliza el tipo de variable pid_t
  pid_t pid_actual, pid_padre;

  //Se obtiene el PID del proceso actual
  pid_actual=getpid();
  //Se obtiene el PID del proceso padre
  pid_padre=getppid();

  printf("PID de este proceso: %d\r\n",pid_actual);
  printf("PID del proceso padre: %d\r\n",pid_padre);
}
