/*Ejercicio 7 - Escribir un programa que pida por teclado
la arista (dato real) de un cubo. En el caso de que
la arista sea menor o igual que 0, muestre por pantalla
el mensaje: "ERROR: La arista debe ser mayor que cero."
Repita los pasos anteriores mientras que, la arista
introducida sea incorrecta. Muestre por pantalla:
"El área de un cubo de arista es: <área>."
Nota: utilizar un bucle while. */

#include <stdio.h>

int main()
{

  float arista;
  float volumen;
  int bucle = 1;

  while(bucle)
  {

    printf("Introduce la media del arista\r\n");
      scanf("%f", &arista);

    if(arista<=0)
    {
      printf("El arista tiene que ser mayor a 0");
    }
    else
    {
      bucle = 0;
    }
  }

  volumen = arista*arista*arista;

   printf("El volumen de un cubo de arista %f es: %f", arista, volumen);

  return 0;

}
