//EJercicio 8 - Escribir un programa que muestre
//por pantalla todos los números pares que hay entre
//el 1 y el 30, ambos inclusive.

#include <stdio.h>

int main()
{

  for(int i = 1; i <= 30; i++)
  {

    if(i%2==0)
    {
      printf("%d\r\n", i);
    }

  }

  return 0;

}
