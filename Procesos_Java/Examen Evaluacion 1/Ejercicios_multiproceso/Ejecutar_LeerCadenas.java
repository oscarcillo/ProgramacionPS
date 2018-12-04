package Ejercicios_multiproceso;

import java.io.InputStream;

public class Ejecutar_LeerCadenas {

	public void ejecutar(String cadena)
	{
		String clase = "com.Ejercicios_multiproceso.LeerCadenas";
		Process proceso;
		
		try
		{
			proceso = new ProcessBuilder("java", clase, cadena).start();			
			
		}
		catch(Exception e)
		{
			 e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {

		Ejecutar_LeerCadenas lanzador = new Ejecutar_LeerCadenas();
		lanzador.ejecutar("hola");
	}

}
