//Ejercicio 2 - Escribir un programa que pida por teclado una hora en horas, minutos y segundos (datos enteros). Calcule cuántos segundos han pasado desde las 0:0:0 horas. Muestre por pantalla el resultado (dato entero).

#include <stdio.h>

int main()
{
	
	int hor;
	int min;
	int seg;

	int resultado;

	printf("Introduce la hora\r\n");
		scanf("%i", &hor);

	printf("Introduce los minutos\r\n");
		scanf("%i", &min);

	printf("Introduce los segundos\r\n");
		scanf("%i", &seg);

	resultado = hor*3600 + min*60 + seg;

	printf("Los segundos totales son %i", resultado);

	return 0;

	

}
