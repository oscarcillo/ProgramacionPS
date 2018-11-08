/*Ejercicio anterior, pero esta vez vamos a hacer tres procesos: padre, hijo, nieto
*/
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>

int main(){

	pid_t pid,pid2,pid_hijo,pid_hijo2;

	pid = fork();

	if(pid == -1){ // error
		printf("No se ha podido crear el proceso hijo....\n");
	}
	else if( pid == 0 ){ // hijo
    pid2=fork();
    if(pid2 == -1){ // error
  		printf("No se ha podido crear el proceso hijo....\n");
  	}
  	else if( pid2 == 0 ){ // nieto
  		printf("Soy el proceso nieto... \n");
  		printf("Mi PID es: %d, y mi proceso padre es: %d\n\n", getpid(), getppid());
  	}else{ // hijo
  		pid_hijo2 = wait(NULL); // Espera a la finalización del proceso hijo, el padre se bloquea
  		printf("Soy el proceso hijo... \n\t"
            	 " Mi PID es %d, el PID de mi padre es: %d. \n\t"
             	 "Mi hijo: %d terminó.\n",
             	 getpid(), getppid(), pid2);
  		printf("El id del hijo es: %d\n", getpid());
  	}
	}else{ // padre
		pid_hijo = wait(NULL); // Espera a la finalización del proceso hijo, el padre se bloquea
		printf("\r\nSoy el proceso padre... \n\t"
          	 " Mi PID es %d, el PID de mi padre es: %d. \n\t"
           	 "Mi hijo: %d terminó.\n",
           	 getpid(), getppid(), pid);
		printf("El id del padre es: %d\n", getpid());
	}
	exit(0);
}
