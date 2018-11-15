package P02_Hilos_Java;

import java.io.File;
import java.io.FileReader;

public class A03_LeerFicherosHilos implements Runnable{
	
	static int n_caracteres;
	static String ruta;
	static long t_inicio, t_fin;
	static int caracter;
	
	public void run()
	{
		n_caracteres = 0;
		
		ruta = "src\\P02_Hilos_Java\\ficheros\\fichero" + i + ".txt";
		File f = new File(ruta);
		FileReader fileReader = new FileReader(f);
		
		while(fileReader.read()!=-1)//while para leer el fichero
		{
				n_caracteres++;
		}
		
		System.out.println("Numero de caracteres: " + n_caracteres);
		
		fileReader.close();
	}

	public static void main(String[] args) 
	{



	}

}
