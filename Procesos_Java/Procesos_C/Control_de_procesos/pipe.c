/*pipe (tuberia) hace que la salida de un dato, sea la entrada de obtenerlo
POr ejemplo: echo "mensaje" | cat
                  salida      ENtrada */

#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>


int main(){

  int fd[2]; // fd[0] -> lectura / fd[1] -> escritura
  char buffer[30];
  pid_t pid;

  pipe(fd); // se crea el pipe sin nombre

  pid = fork(); // se crea el proceso hijo

  switch (pid) {
    case -1: // ERROR
            printf("ERROR al crear el proceso hijo...\n" );
            exit(-1);
            break;
    case 0: // HIJO
            printf("El proceso hijo escribe en el pipe...\n" );
            write(fd[1], "Hola!", 5);
            break;
    default: // PADRE
            wait(NULL);
            printf("El proceso padre lee del pipe...\n" );
            read(fd[0], buffer, 10);
            printf("\tMensaje leido: %s\n", buffer );
            break;
  }
}
