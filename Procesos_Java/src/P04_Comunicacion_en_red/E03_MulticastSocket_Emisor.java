package P04_Comunicacion_en_red;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class E03_MulticastSocket_Emisor {

	 public static void main(String args[]) throws Exception { 
		    // FLUJO PARA ENTRADA ESTANDAR
		    BufferedReader in = new 
		                BufferedReader(new InputStreamReader(System.in));
		    
		    int puerto = 9999;
		    
		    //Se crea el socket multicast. 
		    MulticastSocket ms = new MulticastSocket(puerto); 
		    
		    InetAddress grupo = InetAddress.getByName("225.26.38.10");//Grupo

		    String cadena="";

		    while(!cadena.trim().equals("*")) {            
		      System.out.print("Datos a enviar al grupo: "); 
		      cadena = in.readLine();		  
			// ENVIANDO AL GRUPO
			DatagramPacket paquete = new DatagramPacket(cadena.getBytes(), cadena.length(), grupo, puerto);
			System.out.println("enviado");
		      ms.send (paquete); 
		    }
		    ms.close ();//cierro socket
		    System.out.println ("Socket cerrado...");
		   } 
}
