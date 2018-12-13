import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Clase que se conecta con el cliente por medio de sockets
 * @author ifc
 *
 */
public class E01_Socket_Servidor_plano{
	
	static Scanner teclado;

	public static void main(String[] args) throws IOException {
		//VARIABLES
		teclado = new Scanner(System.in);
		String texto = "";
		char c;
		
		//creación del socket con el puerto por le que va a escuchar
		ServerSocket serversocket = new ServerSocket(9999);
		
		//recibir el socket cliente
		System.out.println(serversocket.getLocalPort());
		Socket socketcliente = serversocket.accept();
		
		//Creamos InputStream para recibir datos del socket cliente
		//y leemos el texto que tiene
		InputStream is = socketcliente.getInputStream();
		
		while((c = (char) is.read())!=-1)
			texto = texto + c;
			
		System.out.println("Texto recibido: " + texto);
		
		socketcliente.close();
		serversocket.close();
	}
}