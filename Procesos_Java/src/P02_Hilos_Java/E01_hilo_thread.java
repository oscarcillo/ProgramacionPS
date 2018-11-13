/**
 * Clase que crea hilos con la clase Thread
 */

package P02_Hilos_Java;

public class E01_hilo_thread extends Thread{
	
	private int x;

	E01_hilo_thread(int x) 
	{
		this.x = x;
	}

	public void run() 
	{
		for (int i = 0; i < x; i++)
			System.out.println("En el Hilo... " + i);
	}

	public static void main(String[] args) 
	{
		E01_hilo_thread p = new E01_hilo_thread(5);
		p.start();
	}// main
}