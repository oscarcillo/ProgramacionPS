//Escribir un programa que muestre por pantalla la tabla de multiplicar
//de un número entero introducido por el usuario. El proceso debe repetirse
//mientras que el usuario lo desee.

#include <stdio.h>

int main()
{

  int numero;

  do {

    printf("Introduce un numero para ver su tabla de multiplicar\r\n");
      scanf("%i", &numero);

    if(numero==0){break;}

    for(int i = 1; i<=10; i++)
    {

      printf("%d x %d = %d\r\n", numero, i, (numero*i));

    }

  } while(numero!=0);



  return 0;

}
