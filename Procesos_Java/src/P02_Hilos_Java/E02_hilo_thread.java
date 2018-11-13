package P02_Hilos_Java;

public class E02_hilo_thread extends Thread {
	
	// constructor
	public E02_hilo_thread(String nombre) 
	{
		super(nombre);
		System.out.println("CREANDO HILO:" + getName());
	}

	// método run
	public void run() 
	{
		for (int i=0; i<5; i++) 
			System.out.println("Hilo:" + getName() + " C = " + i);
	}

	//
	public static void main(String[] args) 
	{
		E02_hilo_thread h1 = new E02_hilo_thread("Hilo 1");
		E02_hilo_thread h2 = new E02_hilo_thread("Hilo 2");
		E02_hilo_thread h3 = new E02_hilo_thread("Hilo 3");
			
		h1.start();
		h2.start();
		h3.start();
		
		System.out.println("3 HILOS INICIADOS...");
	}// main
	

}
