/*Escribir un programa que pida por teclado un número
(dato entero) del 1 al 10. Muestre por pantalla
su equivalente en letras (dato cadena). Nota:
si el número introducido es menor que 1 ó mayor que
10, se mostrará el mensaje: "ERROR: El número debe
ser >= 1 y <= 10.". Ejemplo: Entrada 1, Salida “uno”. */

#include <stdio.h>

int main()
{

  int numero;

  do
  {

    printf("Introduce un número entre 1 y 10\r\n");
      scanf("%i", &numero);

    if(numero<1 || numero>10)
    {
      printf("ERROR: Tienes que introducir un numero >= 1 y <=10\r\n");
    }

  }
  while(numero<1 || numero>10);

  switch(numero)
  {
    case 1:printf("Uno\r\n");break;
    case 2:printf("Dos\r\n");break;
    case 3:printf("Tres\r\n");break;
    case 4:printf("Cuatro\r\n");break;
    case 5:printf("Cinco\r\n");break;
    case 6:printf("Seis\r\n");break;
    case 7:printf("Siete\r\n");break;
    case 8:printf("Ocho\r\n");break;
    case 9:printf("Nueve\r\n");break;
    case 10:printf("Diez\r\n");break;
  }



  return 0;

}
