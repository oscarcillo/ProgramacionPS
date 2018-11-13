package P02_Hilos_Java;

public class E03_metodos_thread extends Thread{
	
	
	  public void run() 
	  {
	     System.out.println(
	  	   "Dentro del Hilo  : " + getName() + 
	 	   "\n\tPrioridad    : " + getPriority() + 
	       "\n\tID           : " + getId() +	  	  
	       "\n\tHilos activos: " + activeCount());
	  }
	  //
	  public static void main(String[] args) 
	  {
		 
		Thread.currentThread().setName("Principal");
		
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().toString());		
		
		E03_metodos_thread h = null;	
		
		for (int i = 0; i < 3; i++) {
		  h = new E03_metodos_thread(); //crear hilo
		  h.setName("HILO"+i);    //damos nombre al hilo
		  h.setPriority(i+1);     //damos prioridad
		  h.start();              //iniciar hilo	  
		  
		  System.out.println(
			"Informacion del " + h.getName() + ": "+ h.toString());	  
	      }
		
		System.out.println("3 HILOS CREADOS...");	
		System.out.println("Hilos activos: " +Thread.activeCount());	
	  }
	  
	}