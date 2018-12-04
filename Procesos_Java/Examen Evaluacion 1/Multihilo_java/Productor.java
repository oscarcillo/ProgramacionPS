package Multihilo_java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Productor extends Thread {
    private Cola cola;
    private String ruta;

    public Productor(Cola c, String ruta) {
        cola = c;
        this.ruta = ruta;
    }

    public void run(){
    	
        File f = new File(ruta);
        FileReader fr;
        int i;
        
        try {
        	fr = new FileReader(f);
            
		    while((i=fr.read())!=-1)//while para leer el fichero
			{
		    	char car = (char)i;
				cola.put(car);
				System.out.println("El productor produce " + car);
			}
			
			fr.close();
        	
        }catch(IOException e) {} 

    }
}