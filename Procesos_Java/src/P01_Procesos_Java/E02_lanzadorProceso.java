package P01_Procesos_Java;

public class E02_lanzadorProceso {

	public void ejecutar(String ruta){

        ProcessBuilder pb;
        try 
        {
        	pb = new ProcessBuilder(ruta);
            pb.start();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }

	}
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
	        String ruta = 
	        "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";
	        
	        E02_lanzadorProceso lp=new E02_lanzadorProceso();
	        lp.ejecutar(ruta);
	        System.out.println("Finalizado");
	}

}
