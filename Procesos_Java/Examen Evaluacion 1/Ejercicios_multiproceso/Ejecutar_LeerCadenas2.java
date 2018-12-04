package Ejercicios_multiproceso;

import java.io.InputStream;

/**
 * Main para el segundo apartado del primer ejercicio
 * @author ifc
 *
 */
public class Ejecutar_LeerCadenas2 {

	public void ejecutar()
	{
		String clase = "com.Ejercicios_multiproceso.LeerCadenas2";
		Process proceso;
		
		try
		{
			proceso = new ProcessBuilder("java", clase).start();			
			
		}
		catch(Exception e)
		{
			 e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {

		Ejecutar_LeerCadenas2 lanzador = new Ejecutar_LeerCadenas2();
		lanzador.ejecutar();
	}

}
