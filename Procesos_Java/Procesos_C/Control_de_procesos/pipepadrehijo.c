//
// PADRE => hijo
//
//

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>

int main(){
	int fd[2];
	pid_t pid;
	char saludoPadre[]="Pequeño saltamontes";
	char buffer[80];


	pipe(fd);

	pid=fork();

	switch(pid){
		case -1: //error
			printf("no se ha podido crear el hijo\n");
			exit(-1);
		case 0:
			close (fd[1]);
			read (fd[0],buffer,sizeof(buffer));
			printf("el hijo recibe un mensaje del pipe %s \n", buffer);
			break;
		default:
			close (fd[0]);
			write (fd[1],saludoPadre, strlen(saludoPadre));
			printf("el padre envia un mensaje al pipe...\n");
			wait(NULL); // espero al proceso
			break;
	}
}
