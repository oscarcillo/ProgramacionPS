package P03_Hilos_Java_Estados;

public class E08_Productor extends Thread {
    private E08_Cola cola;
    private int n;

    public E08_Productor(E08_Cola c, int n) {
        cola = c;
        this.n = n;
    }

    public void run() {
        int valor = 0;

        synchronized (cola) {
    	  for (int i = 0; i < 5; i++) {
              valor = cola.get(); //recoge el número
              System.out.println(i + "=>Consumidor: " + n
                                 + ", consume: " + valor);
              cola.notify();
              try {
					cola.wait();//esperar a que llegue un notify 
				 } catch (InterruptedException e) {}		
          }
        }
    }
}