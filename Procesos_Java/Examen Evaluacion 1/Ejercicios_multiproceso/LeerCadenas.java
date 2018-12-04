package Ejercicios_multiproceso;

import java.util.Scanner;

public class LeerCadenas {
	
	static String cadena;
	static Scanner teclado;
	
	public static void main(String[] args) {
		
		teclado = new Scanner(System.in);
		
		System.out.println("Introduce una cadena (* para finalizar)");
		cadena = teclado.nextLine();
		
		while(!cadena.equals("*")){
			System.out.println("Introduce una cadena (* para finalizar)");
			cadena = teclado.nextLine();
		}
		
	}

}
