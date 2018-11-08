/*Escribir un programa que pida por teclado
tres números (datos enteros). Muestre el mayor
de los tres números introducidos. */

#include <stdio.h>

int main()
{

  int n;
  int n_mayor = 0;

  for(int i = 0; i < 3; i++)
  {
    printf("Introduce 3 números\r\n");
      scanf("%d", &n);

    if(n > n_mayor)
    {
      n_mayor = n;
    }
  }

  printf("El numero mayor de los 3 es %d" , n_mayor);

  return 0;

}
