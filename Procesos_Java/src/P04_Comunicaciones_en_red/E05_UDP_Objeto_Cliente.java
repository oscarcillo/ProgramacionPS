package P04_Comunicaciones_en_red;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

public class E05_UDP_Objeto_Cliente {

	 public static void main(String[] arg) throws IOException,ClassNotFoundException {
		    
		int puerto = 9999;
		InetAddress destino = InetAddress.getByName("192.168.7.22"); // Obtenemos la IP del host local
		 
		// OBJETO A BYTES
		Persona persona = new Persona("Juan", 25);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(baos);

		out.writeObject(persona); //Se escribe el objeto persona en el stream

		out.close(); // Se cierra el stream

		byte[] bytes = baos.toByteArray(); // se toma  el objeto transformado en bytes
		
		//enviar objeto
		DatagramPacket paqueteUDP = new DatagramPacket(bytes, bytes.length, destino, puerto);
		
		//enviamos el paquete de datos con el socket datagrama
		DatagramSocket socket = new DatagramSocket();
		socket.send(paqueteUDP);
	
		System.out.println("Objeto persona eviado");
	 }
}
