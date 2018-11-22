package P03_Hilos_Java_Estados;

public class E03_HiloPrioridad2 extends Thread {
    E03_HiloPrioridad2(String nom) {
        this.setName(nom);
    }
    
    public void run() {
        System.out.println("Ejecutando [" + getName() + "]");
        for (int i = 1; i <= 5; i++) 
            System.out.println("\t("+getName()+": " + i+")");   
    } 
    
    public static void main(String[] args) {
       E03_HiloPrioridad2 h1 = new E03_HiloPrioridad2("Uno");
       E03_HiloPrioridad2 h2 = new E03_HiloPrioridad2("Dos");
       E03_HiloPrioridad2 h3 = new E03_HiloPrioridad2("Tres");
       E03_HiloPrioridad2 h4 = new E03_HiloPrioridad2("Cuatro");
       E03_HiloPrioridad2 h5 = new E03_HiloPrioridad2("Cinco");    
       
       //asignamos prioridad
       h1.setPriority(Thread.MIN_PRIORITY);
       h2.setPriority(3); 
       h3.setPriority(Thread.NORM_PRIORITY);
       h4.setPriority(7); 
       h5.setPriority(Thread.MAX_PRIORITY);
       
       //se ejecutan los hilos
       h1.start();
       h2.start();
       h3.start();
       h4.start();
       h5.start();
    }

}