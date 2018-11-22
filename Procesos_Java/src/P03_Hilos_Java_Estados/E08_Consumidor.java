package P03_Hilos_Java_Estados;

public class E08_Consumidor extends Thread {
    private E08_Cola cola;
    private int n;

    public E08_Consumidor(E08_Cola c, int n) {
        cola = c;
        this.n = n;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            cola.put(i); //pone el n�mero
            System.out.println(i + "=>Productor : " + n
                               + ", produce: " + i);
            try {
                sleep(100);
            } catch (InterruptedException e) { }			
			
        }
    }
}