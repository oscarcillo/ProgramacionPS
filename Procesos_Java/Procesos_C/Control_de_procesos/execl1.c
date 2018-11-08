//Programa que muestra los procesos en ejecución

#include <stdio.h>
#include <errno.h>

int main(){

	printf("Ejemplo de uso de execl\r\n");

	printf("Mostrando procesos en ejecucion\r\n");

	if(execl("/bin/ps","ps","-f",(char*)NULL)<0)
		printf("Error: %d",errno);

	printf("Esto no se ejecuta");

	return 0;
}
