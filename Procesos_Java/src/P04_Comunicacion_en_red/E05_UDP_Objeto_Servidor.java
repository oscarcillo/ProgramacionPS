package P04_Comunicacion_en_red;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;

public class E05_UDP_Objeto_Servidor {
	
	public static void main(String[] arg) throws IOException,
	ClassNotFoundException {
		
		/*int numeroPuerto = 6543;// Puerto local para el envío	

		//Se prepara un objeto y se envía 
		Persona persona = new Persona("Óscar", 43);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		System.out.println("Envio: " + persona.getNombre() +", "+ persona.getEdad());  
		
		//Se obtiene un stream para leer objetos
		ObjectInputStream objetoEntrada = new ObjectInputStream(cliente.getInputStream());
		Persona dato = (Persona) objetoEntrada.readObject();
		System.out.println("Recibo: "+dato.getNombre()+", "+dato.getEdad());
		
		//CERRAR STREAMS Y SOCKETS
		objSalida.close();
		objetoEntrada.close();
		cliente.close();
		servidor.close();*/
		}
}
