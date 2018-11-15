package P02_Hilos_Java;

public class E05_hilo_runnable implements Runnable{
	
	/* Al utilizar la interfaz Runnable, se implementa obligatoriamente
	 * @see java.lang.Runnable#run()
	 */
	public void run()
	{
		for(int i=0; i<5; i++)
			System.out.println("Soy el hilo, me estoy ejecutando :-p");
		
	}

	public static void main(String[] args) 
	{

		E05_hilo_runnable h4 = new E05_hilo_runnable();
		
		Thread t = new Thread(h4);
		
		t.start();
		
		for(int i=0; i<5; i++)
			System.out.println("Soy la clase principal");

	}

}
