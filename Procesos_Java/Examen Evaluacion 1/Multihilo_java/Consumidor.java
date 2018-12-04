package Multihilo_java;

public class Consumidor extends Thread {
    private Cola cola;

    public Consumidor(Cola c) {
        cola = c;
    }

    public void run() {
        char valor;
        
        synchronized(cola) {
        	
        	for (int i = 0; i < 7; i++) {
        		
        		try {
					cola.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		
                valor = (char)cola.get(); //recoge el número
                System.out.println(i+" - El consumidor consume " + valor);
                cola.notify();
            }
        }  
    }
}