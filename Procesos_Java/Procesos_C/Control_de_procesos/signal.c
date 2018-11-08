#include <stdio.h>
#include <signal.h>
#include <stdlib.h>
#include <fcntl.h>

void manejador_padre (int senial){
  printf("El PADRE recibe señal... %d\n", senial);
}

void manejador_hijo (int senial){
  printf("El HIJO recibe señal... %d\n", senial);
}

int main() {
  int pid_padre, pid_hijo;

  pid_padre = getpid();
  pid_hijo = fork();

  switch (pid_hijo) {

    case -1:
      printf("No se ha podido crear el proceso hijo....\n");
      exit(-1);

    case 0: // Hijo
      signal(SIGUSR1, manejador_hijo);
      while(1){
        sleep(1);
        kill(pid_padre, SIGUSR1); // Envio de señal al PADRE
        pause(); // esperando señal de respuesta
      }
      break;

    default:// Padre
      signal(SIGUSR1, manejador_padre);
      while(1){
        pause(); // esperando señal del hijo
        sleep(1);
        kill(pid_hijo, SIGUSR1); // Envio de señal al HIJO

      }
      break;
  }
}
