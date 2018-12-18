package P04_Comunicacion_en_red;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class E02_UDP_Origen {

	public static void main(String[] args) throws IOException {
		
		int puerto = 9999;
		InetAddress destino = InetAddress.getLocalHost(); // Obtenemos la IP del host local

		// Para decir cualquier otro host
		//InetAddress destino = InetAddress.getByName("192.168.4.139");

		byte[] mensaje = new byte[1024];

		String saludo = "Hola soy oscar";
		mensaje = saludo.getBytes(); // Hay que pasar la cadena a bytes para el envío

		DatagramPacket paqueteUDP = new DatagramPacket(mensaje, mensaje.length, destino, puerto);
		
		//enviamos el paquete de datos con el socket datagrama
		DatagramSocket socket = new DatagramSocket();
		socket.send(paqueteUDP);
	}
}
