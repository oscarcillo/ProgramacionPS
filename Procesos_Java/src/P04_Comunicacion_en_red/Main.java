package P04_Comunicacion_en_red;

import java.io.IOException;
import java.io.InputStream;
//libreria de java para comunicación en red
import java.net.*;

public class Main {

	public static void main(String[] args) throws IOException {

		InetAddress ip = null;
		//le damos valor al objeto ip
		ip = InetAddress.getByName(args[0]);
		System.out.println("Nombre e IP: "+ip);
		
		//sacar la direccion ip y nombre de la maquina local
		//ip = InetAddress.getLocalHost();
		//System.out.println(ip);
		
		//sacar la direccion ip de la maquina local
		System.out.println("Ip del nombre de dominio: "+ip.getHostAddress());
		
		//sacar el nombre del equipo
		System.out.println("Nombre del host: "+ip.getHostName());
		
		//sacar el dominio completo
		System.out.println("Dominio completo: "+ip.getCanonicalHostName());
		
		//
		//crear objeto URL
		URL url = new URL("https://www.google.es:443");
		InputStream is = url.openStream();
		URLConnection conexion = url.openConnection();
		
	}

}
