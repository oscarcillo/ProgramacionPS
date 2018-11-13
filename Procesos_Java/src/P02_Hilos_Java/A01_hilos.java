/**
 * Crea una clase para visualizar el mensaje "Hola Mundo!". 
 * A continuación, crea un programa que visualice el mensaje 
 * anterior cinco veces creando para ello cinco hilos diferenes 
 * usando la clase anterior. Modifica el mensaje "Hola mundo!" en 
 * el hilo para incluir el identificador de hilo.
 */
package P02_Hilos_Java;

public class A01_hilos extends Thread {
	
	// constructor
	public A01_hilos(String nombre) 
	{	
		super(nombre);
	}

	// método run
	public void run() 
	{
		System.out.println(this.getName() + " - Hola Mundo - Id de hilo: " 
						 + this.getId());
	}

	//
	public static void main(String[] args) 
	{
		A01_hilos h1 = new A01_hilos("Hilo 1");
		A01_hilos h2 = new A01_hilos("Hilo 2");
		A01_hilos h3 = new A01_hilos("Hilo 3");
		A01_hilos h4 = new A01_hilos("Hilo 4");
		A01_hilos h5 = new A01_hilos("Hilo 5");
			
		h1.start();
		h2.start();
		h3.start();
		h4.start();
		h5.start();
		
		
	}// main
	

}