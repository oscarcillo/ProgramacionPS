package P03_Hilos_Java_Estados;

public class E02_JoinEjecucion {
	  
	public static void main(String[] args) 
	{
	  E02_HiloJoin h1 = new E02_HiloJoin("Hilo1",2);
	  E02_HiloJoin h2 = new E02_HiloJoin("Hilo2",5);
	  E02_HiloJoin h3 = new E02_HiloJoin("Hilo3",7);
   
	  h1.start();
	  h2.start();
	  h3.start();
  
	  //hace que un hilo espere a que termine la ejecucion de los anteriores
	  try 
	  {
       	h1.join(); h2.join(); h3.join(); 
   	  } 
	  catch (InterruptedException e) { }	
	  
	  
  System.out.println("FINAL DE PROGRAMA");	
  
 }

}