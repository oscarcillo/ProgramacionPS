package P04_Comunicacion_en_red;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class E03_MulticastSocket_Receptor extends Thread{
	
	protected MulticastSocket socket = null;
    protected byte[] buf = new byte[256];
    
    String direccion;
    int puerto;
    
    public E03_MulticastSocket_Receptor(String direccion, int puerto) {
    	this.direccion = direccion;
    	this.puerto = puerto;
    }
 
    public void run(){
		try {
		 socket = new MulticastSocket(puerto);
	        InetAddress grupoMulticast = InetAddress.getByName(direccion);
	        socket.joinGroup(grupoMulticast);
	        
	        while (true) {
	            DatagramPacket informacion = new DatagramPacket(buf, buf.length);
	            socket.receive(informacion);
	            String recibido = new String(informacion.getData(), 0, informacion.getLength());
	            System.out.println(recibido);
	            
	            if ("fin".equals(recibido)) {
	                break;
	            }
	        }
	        socket.leaveGroup(grupoMulticast);
	        socket.close();	
		}catch(IOException e) {}
       
    }
}
