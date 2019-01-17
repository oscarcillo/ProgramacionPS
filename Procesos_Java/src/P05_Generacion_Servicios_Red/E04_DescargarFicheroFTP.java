package P05_Generacion_Servicios_Red;

import java.io.*;
import org.apache.commons.net.ftp.*;

public class E04_DescargarFicheroFTP {
	
  public static void main(String[] args) {
	  
	FTPClient cliente = new FTPClient();
	String servFTP = "localhost";
	System.out.println("Nos conectamos a: " + servFTP);
	String usuario = "oscar";
	String clave = "1234";
	
	try {
		cliente.connect(servFTP);
        cliente.enterLocalPassiveMode(); //modo pasivo

		boolean login = cliente.login(usuario, clave);
		
		if (login)
			System.out.println("Login correcto...");
		else {
			System.out.println("Login Incorrecto...");
			cliente.disconnect();
			System.exit(1);
		}
		
		System.out.println("Directorio actual: "
				         + cliente.printWorkingDirectory());

		FTPFile[] files = cliente.listFiles();
		System.out.println("Ficheros en el directorio actual:"
					+ files.length);
            //array para visualizar el tipo de fichero
		String tipos[] = {"Fichero", "Directorio","Enlace simb."};
		
		for (int i = 0; i < files.length; i++) {
			System.out.println("\t" + files[i].getName() + " => "
					+ tipos[files[i].getType()]);
		}
		
		//RECUPERAR EL FICHERO
		String nombreFichero = "";
		BufferedOutputStream out = null;
		//recorre la lista de archivos
		for(int i = 0; i < files.length; i++) {
			//si es un fichero, los descarga con el BufferedOutputStream
			if(files[i].getType()==0) {
				nombreFichero = files[i].getName();
				out = new BufferedOutputStream(new FileOutputStream(
						"src\\P05_Generacion_Servicios_Red\\ficheros\\"+nombreFichero));
				cliente.retrieveFile(nombreFichero, out);
				System.out.println("El fichero "+nombreFichero+" ha sido descargado");
			}
		}
		out.close();
		//CAMBIAR DE DIRECTORIO
		cliente.changeWorkingDirectory("/carpeta1");
		System.out.println("Cambio de directorio a "+cliente.printWorkingDirectory());
		//
		boolean logout = cliente.logout();
		if (logout) 
			System.out.println("Logout del servidor FTP...");
                else 
		        System.out.println("Error al hacer Logout...");
		//
		cliente.disconnect();
		
		System.out.println("Desconectado...");
		
	} catch (IOException ioe) {
		ioe.printStackTrace();
	}		
  }
}//