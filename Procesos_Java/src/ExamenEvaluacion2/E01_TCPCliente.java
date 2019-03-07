package ExamenEvaluacion2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class E01_TCPCliente {

	public static void main(String[] args) throws UnknownHostException, IOException {

		String Host = "localhost";
		int Puerto = 5050;
		
		Socket Cliente = new Socket(Host, Puerto);

		//Se crea flujo de salida al servidor
		DataOutputStream flujoSalida = new
	            DataOutputStream(Cliente.getOutputStream());

		//Se envia mensaje al servidor
		flujoSalida.writeUTF("Esto es un ejercicio del examen");

		//Se crea flujo de entrada al servidor	
		DataInputStream flujoEntrada = new 
	            DataInputStream(Cliente.getInputStream());

		//Recibo el mensaje del servidor
		System.out.println("Recibiendo del SERVIDOR: \n\t" + 
	               flujoEntrada.readUTF());

		flujoEntrada.close();	
		flujoSalida.close();	
		Cliente.close();	

	}

}
