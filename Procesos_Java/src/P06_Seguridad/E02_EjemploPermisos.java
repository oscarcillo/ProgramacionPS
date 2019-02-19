package P06_Seguridad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class E02_EjemploPermisos {
	
      public static void main(String[] args) {
    	  	//USAR RUTAS ABSOLUTAS PARA MAYOR SEGURIDAD
            //El directorio C:/Ficheros debe estar creado previamente.
            System.setProperty ("java.security.policy", "C:\\Users\\ifc\\git\\ProgramacionPSoSCAR\\Procesos_Java"
            		+ "\\src\\P06_Seguridad\\ficheros\\politica222.policy");
            System.setSecurityManager(new SecurityManager());
            
            System.out.println(""+System.getProperty("java.version")) ;
            
            try {
                  //escritura en fichero
                  BufferedWriter fichero = new BufferedWriter (new FileWriter("src\\P06_Seguridad\\ficheros\\fichero.txt"));
                  fichero.write("Escritura de una linea en fichero.");
                  fichero.newLine(); // escribe un salto de línea
                  fichero.close();
                  System.out.println("Final proceso de escritura...");
                 
                  //lectura del fichero
                  BufferedReader fichero2 = new BufferedReader (new FileReader("src\\P06_Seguridad\\ficheros\\fichero.txt"));
                  String linea = fichero2.readLine();
                  System.out.println("Contenido del fichero: ");
                  System.out.println("\t" + linea);
                  fichero2.close();
                  System.out.println("Final proceso de lectura...");
                  
            } catch (FileNotFoundException fn) {
                  System.out.println("No se encuentra el fichero");
            } catch (IOException io) {
                  System.out.println("Error de E/S ");
            } catch (Exception e) {
                  System.out.println("ERROR => " + e.toString());
            }//Fin de try
           
      }// Fin de main   
}// Fin de Ejemplo2
