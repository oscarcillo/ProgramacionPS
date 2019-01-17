package P05_Generacion_Servicios_Red;

import java.io.*;
import org.apache.commons.net.ftp.*;

public class E05_SubirFicherosFTPLocal {
	
	  public static void main(String[] args) {
		  
		FTPClient cliente = new FTPClient();

		String servidor = "localhost";
		String user = "oscar";
		String pasw = "1234";

		try {
		   System.out.println("Conectandose a " + servidor);
		   cliente.connect(servidor);
		   boolean login = cliente.login(user, pasw);
			
		   cliente.setFileType(FTP.BINARY_FILE_TYPE);
		   String direc = "/carpeta1";
		   cliente.enterLocalPassiveMode();

		   if (login) {				
			 System.out.println("Login correcto");
	                 
			 if (!cliente.changeWorkingDirectory(direc)) {
			    String directorio = "/carpeta1";
					
			    if (cliente.makeDirectory(directorio)) {
				System.out.println("Directorio :  " + 
	                                  directorio + " creado ...");
	                  cliente.changeWorkingDirectory(directorio);
			    } else {
				System.out.println("No se ha podido crear el Directorio");
				System.exit(0);
			    }
			  }
			  System.out.println("Directorio actual: " +
				   cliente.printWorkingDirectory());
					
			  String archivo ="src\\P05_Generacion_Servicios_Red\\ficheros\\ficherosubir.txt";				
			  BufferedInputStream in = new BufferedInputStream
						(new FileInputStream(archivo));
				
			  if (cliente.storeFile("ficherosubir.txt", in))
				   System.out.println("Subido correctamente... ");
				else
				   System.out.println("No se ha podido subir el fichero... ");					
		
			  in.close(); // Cerrar flujo
			  cliente.logout();
			  cliente.disconnect();
		   }
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
  }// main			
}// ..