package Ejercicios_multiproceso;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Leer cadenas de un fichero de texto
 * @author ifc
 *
 */
public class LeerCadenas2 {
	
	static String cadena;
	
	public static void main(String[] args) throws IOException {
		
		  File f = new File("C:\\Users\\ifc\\git\\ProgramacionPS\\Procesos_Java\\Examen Evaluacion 1"
		  		+ "\\Ejercicios_multiproceso\\fichero.txt");
	      FileReader fr;
	      int i;
		
	  		fr = new FileReader(f);
        
		    /*while((i=fr.read())!=-1)//while para leer el fichero
			{
		    	char car = (char)i;
		    	if(Character.)
			}*/
			
			fr.close();
		
	}

}
