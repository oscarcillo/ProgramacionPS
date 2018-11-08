/**
 * Process & ProcessBuilder
 * Ejecutar una aplicaci�n del S.O.
 */
package P01_Procesos_Java;

import java.io.IOException;

public class E01_ejecutarApp {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		// LINUX
		// final String orden[] = {"ls", "/"};
		// Process proceso = new ProcessBuilder(orden).start();

		//WINDOWS
		Process proceso1 = new ProcessBuilder("NOTEPAD").start();
		Process proceso2 = new ProcessBuilder("EXPLORER").start();
		Process proceso3 = new ProcessBuilder("MSPAINT").start();
	}

}