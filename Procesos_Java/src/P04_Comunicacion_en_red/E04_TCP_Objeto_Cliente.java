package P04_Comunicacion_en_red;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class E04_TCP_Objeto_Cliente {

	 public static void main(String[] arg) throws IOException,ClassNotFoundException {
		    
		    String Host = "localhost";
		    int Puerto = 6543;//puerto del servidor	
				
		    System.out.println("PROGRAMA CLIENTE INICIADO....");
		    Socket cliente = new Socket(Host, Puerto);	
			
		    //Flujo de entrada
		    ObjectInputStream objEntrada = new ObjectInputStream(cliente.getInputStream());
		    
		    //Se recibe un objeto
		    Persona personaRec = (Persona) objEntrada.readObject();//recibo objeto
		    System.out.println("Recibo: " +personaRec.getNombre()+"*" +personaRec.getEdad());
			
		    //Modifico el objeto
		    personaRec.setNombre("Óscar Tutor");
		    personaRec.setEdad(55);
			
		    //Flujo de salida
		    ObjectOutputStream objSalida = new ObjectOutputStream(cliente.getOutputStream());
		    
		    // Se envía el objeto
		    objSalida.writeObject(personaRec);
		    System.out.println("Envio: "+ personaRec.getNombre()+", " +personaRec.getEdad());                       
				
		    // CERRAR STREAMS Y SOCKETS
		    objEntrada.close();
		    objSalida.close();
		    cliente.close();		
		  }
	
}
