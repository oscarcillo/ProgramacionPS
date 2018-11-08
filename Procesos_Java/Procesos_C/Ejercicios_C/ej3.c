//Ejercicio 3 - Escribir un programa que pida por teclado una cantidad (dato entero) en pesetas. Calcule su equivalente en euros. Muestre por pantalla el resultado (dato real).

#include <stdio.h>

int main()
{

	int pesetas;
	float euros;

	printf("Introduce las pesetas\r\n");
		scanf("%i", &pesetas);

	euros = pesetas * 0.0060099765610914;

	printf("%i pesetas equivalen a %f euros", pesetas, euros);

	return 0;

}
