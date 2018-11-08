//Escribir un programa que pida por teclado un
//número (dato entero). Muestre por pantalla:
//"ES PAR", en el caso de que el número sea divisible
//entre 2. "ES IMPAR", en el caso de que el número no
//sea divisible entre 2.

#include <stdio.h>

int main()
{

  int numero;

  printf("Introduce un número\r\n");
    scanf("%i", &numero);

  if(numero%2==0)
  {
    printf("El número es par");
  }
  else
  {
    printf("El número es impar");
  }

  return 0;
}
