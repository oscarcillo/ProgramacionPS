package P02_Hilos_Java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class A03_LeerFicherosHilos implements Runnable{
	
	static int n_caracteres;
	static String ruta;
	static long t_inicio, t_fin;
	static int caracter;
	
	public void run()
	{
		n_caracteres = 0;
		//
		try
		{
			File f = new File(ruta);
			FileReader fileReader = new FileReader(f);
			
			while(fileReader.read()!=-1)//while para leer el fichero
			{
					n_caracteres++;
			}
			
			System.out.println("Numero de caracteres: " + n_caracteres);
			
			fileReader.close();
		}
		catch(Exception e){}
		
		//
		
	}

	public static void main(String[] args) throws InterruptedException 
	{

		t_inicio = System.currentTimeMillis(); // tiempo en milisegundos
		
		for(int i = 1; i <= 5; i++)
		{
			A03_LeerFicherosHilos h = new A03_LeerFicherosHilos();
			ruta = "src\\P02_Hilos_Java\\ficheros\\fichero" + i + ".txt";
			Thread t = new Thread(h);
			t.start();
		}
		
		t_fin = System.currentTimeMillis();
		
		long tiempo_total = t_fin - t_inicio;
		
		System.out.println("Tiempo transcurrido: " + tiempo_total);
		
	}

}
