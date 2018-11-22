package P03_Hilos_Java_Estados;

public class E08_Main {
	  public static void main(String[] args) {  
	    E08_Cola cola = new E08_Cola();
		
	    E08_Productor p = new E08_Productor(cola, 1);	
	    E08_Consumidor c = new E08_Consumidor(cola, 1);
		
	    p.start();
		c.start();

	  }
	}