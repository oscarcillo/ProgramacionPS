#include <stdio.h>

//Escribir un programa que pida por teclado dos numero enteros. Calcula la suma y multiplicacion
//de dos numeros introducidos..

int main()
{

	int a;
	int b;
	int suma;
	int mult;

	printf("Introduce dos números\r\n");

	scanf("%d", &a);
	scanf("%d", &b);

	suma = a + b;
	mult = a * b;

	printf("La suma de los dos números es %i - Multiplicacion es %i \r\n", suma, mult);

	return 0;

}
