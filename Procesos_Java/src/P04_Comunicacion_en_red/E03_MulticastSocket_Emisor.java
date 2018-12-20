package P04_Comunicacion_en_red;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class E03_MulticastSocket_Emisor {

	private DatagramSocket socket;
    private InetAddress grupo;
    private byte[] buf;
	
	public void multicast(String multicastMessage, String direccion, 
			int puerto) throws IOException 
	{
 		socket = new DatagramSocket(puerto);
        grupo = InetAddress.getByName(direccion);
        buf = multicastMessage.getBytes();
 
        DatagramPacket informacion = new DatagramPacket(buf, buf.length, grupo, puerto);
        socket.send(informacion);
        socket.close();
	}
}
