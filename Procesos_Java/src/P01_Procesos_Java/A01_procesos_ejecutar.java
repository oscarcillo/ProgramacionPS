package P01_Procesos_Java;

import java.io.InputStream;

public class A01_procesos_ejecutar {

	
	public void ejecutar(String[] argumentos)
	{
		String clase = "com.P01_Procesos_Java.A01_procesos";
		Process proceso;
		
		try
		{
			proceso = new ProcessBuilder(
                    	  "java",
                    	  clase,
                    	  argumentos[0]
					      ).start();
			
			try
			{
				InputStream is = proceso.getInputStream();
				int c;
				
				while((c = is.read()) != -1)
				{
					System.out.print(c);
					is.close();
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			  
		    // Comprobar si el proceso ha finalizado de forma correcta
		    //  0 Bien
		    // -1 Mal 
		    
		    int valorSalida;
		    
		    try 
		    {
		    	valorSalida = proceso.waitFor();
		    	System.out.println("Valor de salida: " + valorSalida);
		    	
		    }catch (Exception e) 
		    {
		        e.printStackTrace();
		    }
		    
		    //
			
		}
		catch(Exception e)
		{
			 e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		
		 A01_procesos_ejecutar lanzador = new A01_procesos_ejecutar();
		 lanzador.ejecutar(args);		 
		
	}

}
