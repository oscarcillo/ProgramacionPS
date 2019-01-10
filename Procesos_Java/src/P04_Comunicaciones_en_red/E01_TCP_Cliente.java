package P04_Comunicaciones_en_red;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.Scanner;

/**
 * Clase que se conecta con el servidor por medio de sockets
 * @author ifc
 *
 */
public class E01_TCP_Cliente {
	
	static Scanner teclado;

	public static void main(String[] args) throws IOException{
		
		String Host = "localhost";
		int Puerto = 6000;//puerto remoto	
		
		System.out.println("PROGRAMA CLIENTE INICIADO....");
		Socket Cliente = new Socket(Host, Puerto);

		// CREO FLUJO DE SALIDA AL SERVIDOR	
		DataOutputStream flujoSalida = new
	            DataOutputStream(Cliente.getOutputStream());

		// ENVIO UN SALUDO AL SERVIDOR
		flujoSalida.writeUTF("Saludos al SERVIDOR DESDE EL CLIENTE");

		// CREO FLUJO DE ENTRADA AL SERVIDOR	
		DataInputStream flujoEntrada = new 
	            DataInputStream(Cliente.getInputStream());

		// EL SERVIDOR ME ENVIA UN MENSAJE
		System.out.println("Recibiendo del SERVIDOR: \n\t" + 
	               flujoEntrada.readUTF());

		// CERRAR STREAMS Y SOCKETS	
		flujoEntrada.close();	
		flujoSalida.close();	
		Cliente.close();	
	}

}
