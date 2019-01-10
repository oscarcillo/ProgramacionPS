package P04_Comunicaciones_en_red;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class E03_MulticastSocket_Receptor{
	
	 public static void main(String args[]) throws Exception { 
		    //Se crea el socket multicast 
		    
			//Grupo    
			InetAddress grupo = InetAddress.getByName("225.26.38.10");
			
			//Puerto multicast
			int puerto = 9999;
			
		    MulticastSocket ms = new MulticastSocket(puerto);  

		    //Nos unimos al grupo
		    ms.joinGroup (grupo);
		    System.out.println("Se ha unido al grupo");
		   
		    String msg="";
		    
		    //Leyendo hasta *
		    while(!msg.trim().equals("*")) {  
		      byte[] buf = new byte[1000];
		      
		      //Recibe el paquete del servidor multicast      
		      DatagramPacket paquete = new DatagramPacket(buf, buf.length);
		      ms.receive(paquete);

		      msg = new String(paquete.getData());
		      System.out.println ("Recibo: " + msg.trim());	
		    }
		    
		    System.out.println("Sale del grupo");
		    
		    ms.leaveGroup (grupo); //abandonamos grupo
		    ms.close (); //cierra socket
		    
		    System.out.println ("Socket cerrado...");
		   } 
}
