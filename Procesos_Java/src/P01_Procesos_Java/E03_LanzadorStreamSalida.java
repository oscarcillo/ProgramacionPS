package P01_Procesos_Java;

import java.io.InputStream;

public class E03_LanzadorStreamSalida {

	public void lanzarSumador(Integer n1, Integer n2){
	    String clase="com.creacion.Sumador";
	    Process p;
	    try {
	        p = new ProcessBuilder(
                    "java",
                    clase,
                    n1.toString(),
                    n2.toString()
            ).start();
	        //pb.start();
	        
	        try {
	        	
	        	InputStream is = p.getInputStream();
	        	int c;
	        	
	        	while ((c = is.read()) != -1)
	        	{
	        		System.out.print((char) c);
		        	is.close();
	        	}	
	        	
	        }catch (Exception e) {
		        e.printStackTrace();
		    }
		    
		    
		    // Comprobar si el proceso ha finalizado de forma correcta
		    //  0 Bien
		    // -1 Mal 
		    
		    int valorSalida;
		    
		    try {
		    	valorSalida = p.waitFor();
		    	System.out.println("Valor de salida: " + valorSalida);
		    }catch (Exception e) {
		        e.printStackTrace();
		    }
		    
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public static void main(String[] args){
	    E03_LanzadorStreamSalida l=new E03_LanzadorStreamSalida();
	    l.lanzarSumador(1, 51);
	    l.lanzarSumador(51, 100);
	    System.out.println("Sumas realizadas con �xito");
	}

}