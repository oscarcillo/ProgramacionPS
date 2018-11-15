package P02_Hilos_Java;

public class A02_Tic extends Thread{
	
	public A02_Tic(String nombre)
	{
		super(nombre);
	}
	
	//método run
	public void run()
	{
		while(true)
		{
			System.out.println("TIC...");
			
			//parar ejecución durante 1 segundo
			try 
			{
				sleep(2000);
			}catch (InterruptedException e) {}	
		}
	}

}
