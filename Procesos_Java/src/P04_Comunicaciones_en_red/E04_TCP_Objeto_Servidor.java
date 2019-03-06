package P04_Comunicaciones_en_red;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class E04_TCP_Objeto_Servidor {

	public static void main(String[] arg) throws IOException,
	ClassNotFoundException {
		
		int numeroPuerto = 6543;// Puerto local para el env�o
		ServerSocket servidor =  new ServerSocket(numeroPuerto);
		System.out.println("Esperando al cliente.....");   
		Socket cliente = servidor.accept();
		
		//Se obtiene un stream para leer objetos
		ObjectInputStream objetoEntrada = new ObjectInputStream(cliente.getInputStream());
		Persona dato = (Persona) objetoEntrada.readObject();
		System.out.println("Recibo: "+dato.getNombre()+", "+dato.getEdad());
		
		//flujo de salida para objetos 	
		ObjectOutputStream objSalida = new ObjectOutputStream(cliente.getOutputStream()); 	
		
		dato.setEdad(22);
		objSalida.writeObject(dato); //enviando objeto
		System.out.println("Envio: " + dato.getNombre() +", "+ dato.getEdad());
		
		//CERRAR STREAMS Y SOCKETS
		//objSalida.close();
		objetoEntrada.close();
		cliente.close();
		servidor.close();
		}
}
