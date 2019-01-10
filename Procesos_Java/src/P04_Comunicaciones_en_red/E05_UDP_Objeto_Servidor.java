package P04_Comunicaciones_en_red;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;

public class E05_UDP_Objeto_Servidor {
	
	public static void main(String[] arg) throws IOException,
	ClassNotFoundException {
		
		DatagramSocket socket = new DatagramSocket(9999);   

		//ESPERANDO DATAGRAMA
		System.out.println("Esperando Datagrama .......... ");  
		byte[] bufer = new byte[1024];
		DatagramPacket recibo = new DatagramPacket(bufer, bufer.length);
		socket.receive(recibo);//recibo datagrama

		//System.out.println("Datagrama recibido");
		
		//Pasamos bytes a objeto
		ByteArrayInputStream bais = new ByteArrayInputStream(bufer);
		ObjectInputStream in = new ObjectInputStream(bais);
		Persona persona = (Persona)in.readObject(); //Se obtiene el objeto recibido como bytes
		in.close();
		
		System.out.println("Nombre -> " + persona.getNombre() + " | Edad -> " + persona.getEdad());
		}
}
