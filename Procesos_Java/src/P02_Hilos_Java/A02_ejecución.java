package P02_Hilos_Java;

public class A02_ejecución {

	public static void main(String[] args) {

		A02_Tic hilotic = new A02_Tic("HiloTic");
		A02_Tac hilotac = new A02_Tac("HiloTic");
		
		hilotic.start();
		hilotac.start();

	}

}
