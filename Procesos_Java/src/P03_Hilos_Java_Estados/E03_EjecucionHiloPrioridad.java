package P03_Hilos_Java_Estados;


public class E03_EjecucionHiloPrioridad {
	public static void main(String args[]) {    
	    E03_HiloPrioridad h1 = new E03_HiloPrioridad("Hilo1");
	    E03_HiloPrioridad h2 = new E03_HiloPrioridad("Hilo2");
	    E03_HiloPrioridad h3 = new E03_HiloPrioridad("Hilo3");	
		  
		h1.setPriority(Thread.NORM_PRIORITY);
		h2.setPriority(Thread.MAX_PRIORITY);    
		h3.setPriority(Thread.MIN_PRIORITY);   
		
		h1.start();	
		h2.start();
	    h3.start();  	

	   try {
	      Thread.sleep(10000);
	    } catch (Exception e) { }


	    h1.pararHilo();
	    h2.pararHilo();
		h3.pararHilo();
		
	    System.out.println("h2 (Prioridad Maxima): " + h2.getContador());
		System.out.println("h1 (Prioridad Normal): " + h1.getContador());  	
		System.out.println("h3 (Prioridad Minima): " + h3.getContador());

	  }
}