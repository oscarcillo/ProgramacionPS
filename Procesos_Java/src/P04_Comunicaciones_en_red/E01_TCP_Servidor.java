package P04_Comunicaciones_en_red;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Clase que se conecta con el cliente por medio de sockets
 * @author ifc
 *
 */
public class E01_TCP_Servidor{
	
	static Scanner teclado;

	public static void main(String[] args) throws IOException {
		
		int numeroPuerto = 6000;// Puerto
		ServerSocket servidor = new ServerSocket(numeroPuerto);
		Socket clienteConectado = null;
		System.out.println("Esperando al cliente.....");
		clienteConectado = servidor.accept();

		// CREO FLUJO DE ENTRADA DEL CLIENTE
		InputStream entrada = null;
		entrada = clienteConectado.getInputStream();
		DataInputStream flujoEntrada = new DataInputStream(entrada);

		// EL CLIENTE ME ENVIA UN MENSAJE
		System.out.println("Recibiendo del CLIENTE: \n\t" + 
	                      flujoEntrada.readUTF());

		// CREO FLUJO DE SALIDA AL CLIENTE
		OutputStream salida = null;
		salida = clienteConectado.getOutputStream();
		DataOutputStream flujoSalida = new DataOutputStream(salida);

		// ENVIO UN SALUDO AL CLIENTE
		flujoSalida.writeUTF("Saludos al cliente del servidor");

		// CERRAR STREAMS Y SOCKETS
		entrada.close();
		flujoEntrada.close();
		salida.close();
		flujoSalida.close();
		clienteConectado.close();
		servidor.close();
	}
}