package Multihilo_java;

public class Main {
	  public static void main(String[] args) {  
	    Cola cola = new Cola();
		
	    Productor p = new Productor(cola, 
	    		"C:\\Users\\ifc\\git\\ProgramacionPS\\Procesos_Java\\Examen Evaluacion 1\\Multihilo_java\\fichero.txt");	
	    Consumidor c = new Consumidor(cola, 1);
		
	    p.start();
		c.start();

	  }
	}