/*Ejemplo de la función fork, utilizando una variable*/
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>

int main(){

  int variable=7;
	pid_t pid, hijo_pid;

  printf("La variable es: %d\r\n",variable);

	pid = fork();

	if(pid == -1){ // error
		printf("No se ha podido crear el proceso hijo....\n");
	}
	else if( pid == 0 ){ // hijo
    printf("\r\nSoy el proceso hijo y sumo 5 a la variable\r\n");
    variable +=5;
    printf("La variable es: %d\r\n",variable);
	}else{ // padre
		hijo_pid = wait(NULL); // Espera a la finalización del proceso hijo, el padre se bloquea
    printf("\r\nSoy el proceso padre y resto 5 a la variable\r\n");
    variable -=5;
    printf("La variable es: %d\r\n",variable);
	}
	exit(0);
}
