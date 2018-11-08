//1. el padre envia 2 señales con manejadores diferentes, cada manejador imprime un mensaje diferente
//2. el padre NO recibe señal del hijo
//3. el hijo solo recibe señales
//4. el hijo no envia señal al padre

#include <stdio.h>
#include <signal.h>
#include <stdlib.h>
#include <fcntl.h>

void manejador_1 (int senial){
  printf("El Hijo recibe la primera señal... %d\n", senial);
}

void manejador_2 (int senial){
  printf("El HIJO recibe la segunda señal.. %d\n", senial);
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
    pause();
      signal(SIGUSR1, manejador_1);
    //  wait();
    //  signal(SIGUSR1, manejador_2);

      while(1)
      {
        pause(); // esperando señal de respuesta
      }
      break;

    default:// Padre


        kill(pid_hijo, SIGUSR1); // Envio de señal al HIJO
      //  sleep(1);
      //  kill(pid_hijo, SIGUSR1);

      break;
  }
}
