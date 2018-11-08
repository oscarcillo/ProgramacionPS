//Programa que muestra el nombre del equipo

#include <stdio.h>

int main(){

	printf("Ejemplo de uso de execl\r\n");

	printf("Mostrando el nombre del equipo\r\n");

	execl("/bin/hostname","hostname","-f",(char*)NULL);

	printf("Esto no se ejecuta");

	return 0;
}
