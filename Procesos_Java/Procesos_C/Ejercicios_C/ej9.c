/*Escribir un programa que muestre por pantalla todos los
números múltiplos de 4 que hay entre el 64 y el 44, ambos inclusive. */

#include <stdio.h>

int main()
{

  for(int i = 44; i <= 64; i++)
  {

    if(i%4==0)
    {
      printf("%d\r\n", i);
    }

  }

  return 0;

}
