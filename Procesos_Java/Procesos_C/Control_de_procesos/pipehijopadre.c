#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>

int main(){

	int fd[2];
	pid_t pid;
	char saludoDelHijo[]="Hola papa que pasa";
	char buffer[20];


	pipe(fd);

	pid=fork();

	switch(pid){

		case -1: //error
			printf("no se ha podido crear el hijo\n");
			exit(-1);

		case 0:
			close (fd[0]);
			write (fd[1],saludoDelHijo,strlen(saludoDelHijo));
			printf("El hijo envia un mensaje al padre.\n");
			break;

		default:
      wait(NULL); //espero a que termine el proceso hijo
			close (fd[1]);
			read (fd[0], buffer,sizeof(buffer));
			printf("EL padre recibe el mensaje %s\n",buffer);
			break;

  }
}
