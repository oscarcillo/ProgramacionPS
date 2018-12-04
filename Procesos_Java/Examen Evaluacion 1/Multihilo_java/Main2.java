package Multihilo_java;

/**
 * Segundo main para el segundo apartado de el ejercicio de Multihilos
 * @author ifc
 *
 */
public class Main2 {
	  public static void main(String[] args) {  
	    Cola cola = new Cola();
		
	    Productor p = new Productor(cola, 
	    		"C:\\Users\\ifc\\git\\ProgramacionPS\\Procesos_Java\\Examen Evaluacion 1\\Multihilo_java\\fichero.txt");	
	    Consumidor c1 = new Consumidor(cola, 1);
	    Consumidor c2 = new Consumidor(cola, 2);
		
	    p.start();
		c1.start();
		c2.start();
		
		while(p.getState()!=Thread.State.TERMINATED) {
		}
		
		System.out.println("El estado del consumidor 1 es "+c1.getState());
		System.out.println("El estado del consumidor 2 es"+c2.getState());

	  }
	}