package P03_Hilos_Java_Estados;

/*
 * Permite retirar dinero cuando el saldo es cero.
 * 
 */

class Cuenta {
	private int saldo ;
	Cuenta (int s) {saldo = s;}
	
	int getSaldo() {return saldo;}
	void restar(int cantidad){saldo=saldo-cantidad;}
	
	void RetirarDinero(int cant, String nom) {	
		if (getSaldo() >= cant) {
			System.out.println(nom+": SE VA A RETIRAR SALDO (ACTUAL ES: "+getSaldo()+ ")" );
			try {
				Thread.sleep(500);
			} catch (InterruptedException ex) {	}
			
			restar(cant);	
			
			System.out.println("\t"+nom+ " retira =>"+cant + " ACTUAL("+getSaldo()+")" );	
		} else {
			System.out.println(nom+ " No puede retirar dinero, NO HAY SALDO("+getSaldo()+")" );
		}
		if (getSaldo() < 0) {
			System.out.println("SALDO NEGATIVO => "+getSaldo());
		}		
	}
}

class SacarDinero extends Thread {
	private Cuenta c;	
	public SacarDinero(String n, Cuenta c) {		
		super(n);
		this.c = c;
	}
	public  void run() {
		//se pone synchronized para que una vez acceda un hilo a la variable de
		//cuenta, otro hilo no pueda acceder, para que el fucnionamiento sea
		//correcto
		synchronized (c) 
		{
		for (int x = 1; x<= 2; x++) {		
			c.RetirarDinero(10, getName());		
		}
		}		
	}// run	
}

public class E06_CuentaBancariaSincronizado {
	public static void main(String[] args) {
		Cuenta c = new Cuenta(40);
		SacarDinero h1 = new SacarDinero("Ana", c);
		SacarDinero h2 = new SacarDinero("Juan", c);

		h1.start();
		h2.start();
	}
}