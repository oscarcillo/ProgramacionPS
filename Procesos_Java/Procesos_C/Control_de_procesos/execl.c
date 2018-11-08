//Programa que muestra los directorios
#include <stdio.h>

int main(){

	printf("Ejemplo de uso de execl\r\n");

	printf("Mostrando directorios\r\n");

	execl("/bin/ls","ls","-f",(char*)NULL);

	printf("Esto no se ejecuta");

	return 0;
}
