package P04_Ejercicio_chat_invertido;

import java.io.*;
import java.net.*;

public class HiloServidorChat implements Runnable {
	
	DataInputStream fentrada;
	Socket socket = null;
	ComunHilos comun;

	public HiloServidorChat(Socket s, ComunHilos comun) {
		this.socket = s;
		this.comun = comun;
		try {
			// CREO FLUJO DE entrada para leer los mensajes
			fentrada = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			System.out.println("ERROR DE E/S");
			e.printStackTrace();
		}
	}// ..

	public void run() {
		System.out.println("NUMERO DE CONEXIONES ACTUALES: " + comun.getACTUALES());

		// NADA MAS CONECTARSE LE ENVIO TODOS LOS MENSAJES
		String texto = comun.getMensajes();
		EnviarMensajesaTodos(texto);

		while (true) {
			String cadena = "";
			try {
				cadena = fentrada.readUTF();
				if (comprobarAdios(cadena)) {// EL CLIENTE SE DESCONECTA
					comun.setACTUALES(comun.getACTUALES() - 1);
					System.out.println("NUMERO DE CONEXIONES ACTUALES: " + comun.getACTUALES());
					break;
				}
				//dar la vuelta a la cadena
				if(cadena.charAt(0)!='>')
					cadena = voltearCadena(cadena);
				//
				comun.setMensajes(comun.getMensajes() + cadena + "\n");
				EnviarMensajesaTodos(comun.getMensajes());
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
		} // fin while

		// se cierra el socket del cliente
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}// run

	// ENVIA LOS MENSAJES DEL CHAT A LOS CLIENTES
	private void EnviarMensajesaTodos(String texto) {
		int i;
		// recorremos tabla de sockets para enviarles los mensajes
		for (i = 0; i < comun.getCONEXIONES(); i++) {
			Socket s1 = comun.getElementoTabla(i);
			if (!s1.isClosed()) {
				try {
					DataOutputStream fsalida = new DataOutputStream(s1.getOutputStream());
					fsalida.writeUTF(texto);					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} // for
		
	}// EnviarMensajesaTodos
	
	private String voltearCadena(String cadena) {
		String [] array;
		array = cadena.split(">");
		String cadenacambiar = "";
		String cadenavolteada = "";
		
		for(int i = 1; i < array.length; i++)
			cadenacambiar = cadenacambiar + array[i];
		
		char invertida[] = cadenacambiar.toCharArray();	
		for (int i=invertida.length-1;i>=0;i--) {
			cadenavolteada = cadenavolteada + invertida[i];
		}
		return array[0] + " > " + cadenavolteada;
	}
	
	private boolean comprobarAdios(String cadena) {
		String [] array;
		array = cadena.split(">");
		if(array[array.length-1].trim().equals("adios"))
			return true;
		else
			return false;
	}

}// ..HiloServidorChat