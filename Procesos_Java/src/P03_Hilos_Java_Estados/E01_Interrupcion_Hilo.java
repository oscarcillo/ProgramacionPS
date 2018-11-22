package P03_Hilos_Java_Estados;

public class E01_Interrupcion_Hilo extends Thread 
{
	  public void run() 
	  {
		    try 
		    {
		      while (!isInterrupted()) 
		      {
		        System.out.println("En el Hilo");
			    Thread.sleep(1);
		      }
		      
		      }catch (InterruptedException e) {
			     System.out.println("HA OCURRIDO UNA EXCEPCIÓN");
			  }
		      
		      System.out.println("FIN HILO");
		   }
		  
		  
	   public void interrumpir() 
	   {
	       interrupt();
	   }
		   
	   public static void main(String[] args) 
	   {
		E01_Interrupcion_Hilo h = new E01_Interrupcion_Hilo();
	    h.start();
	    
		for(int i=0; i<1000000000; i++)//no hago nada
		{
			for(int j=0; j<1000000000; j++);
		}
		
		h.interrumpir();
	   }

	}