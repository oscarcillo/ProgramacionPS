package P02_Hilos_Java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class A03_LeerFicherosSecuencial {
	
	static String ruta;
	static int caracter;
	static long t_inicio, t_fin;
	static int n_caracteres;

	public static void main(String[] args) throws IOException {

		t_inicio = System.currentTimeMillis(); // tiempo en milisegundos
		
		//
		
		for(int i = 1; i <=5; i++)
		{
			n_caracteres = 0;
			
			ruta = "src\\P02_Hilos_Java\\ficheros\\fichero" + i + ".txt";
			File f = new File(ruta);
			FileReader fileReader = new FileReader(f);
			
			while((caracter=fileReader.read())!=-1)//while para leer el fichero
			{
					n_caracteres++;
			}
			
			System.out.println("Numero de caracteres: " + n_caracteres);
			
			fileReader.close();
		}

		//
		
		t_fin = System.currentTimeMillis();

		long tiempo_total = t_fin - t_inicio;
		
		System.out.println("Tiempo transcurrido: " + tiempo_total);
		
		
	}

}
