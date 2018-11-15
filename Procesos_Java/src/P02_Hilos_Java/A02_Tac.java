package P02_Hilos_Java;

public class A02_Tac extends Thread{
	
	public A02_Tac(String nombre)
	{
		super(nombre);
	}
	
	//método run
	public void run()
	{
		while(true)
		{
			
			try 
			{
				sleep(1000);
			}catch (InterruptedException e) {}
			
			System.out.println("TAC...");		
			
			try 
			{
				sleep(1000);
			}catch (InterruptedException e) {}
			
		}
	}

}
