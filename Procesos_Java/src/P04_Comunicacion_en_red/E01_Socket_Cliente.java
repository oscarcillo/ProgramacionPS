package P04_Comunicacion_en_red;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.Scanner;

/**
 * Clase que se conecta con el servidor por medio de sockets
 * @author ifc
 *
 */
public class E01_Socket_Cliente {
	
	static Scanner teclado;

	public static void main(String[] args){
		teclado = new Scanner(System.in);
		OutputStream os;
		
		try {
			//creación del socket
			Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
			
			//conectarse con otro socket
			socket.connect(new InetSocketAddress(InetAddress.getLocalHost(), 9999));
			//
			
			//insertar un stream al socket
			os = socket.getOutputStream();
			for(int i = 0; i < 100; i++) {
				System.out.println(i);
				os.write(i);
			}
		}catch(Exception e) {
			System.out.println(e);
		}	
	}

}
