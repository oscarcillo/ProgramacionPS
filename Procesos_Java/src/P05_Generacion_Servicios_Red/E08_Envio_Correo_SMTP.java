package P05_Generacion_Servicios_Red;

import java.io.IOException;
import java.net.ConnectException;

//import org.apache.commons.net.smtp.AuthenticatingSMTPClient;
import org.apache.commons.net.smtp.SMTPClient;
import org.apache.commons.net.smtp.SMTPReply;

public class E08_Envio_Correo_SMTP {

	public static void main(String[] args) {
		
		SMTPClient client = new SMTPClient();
		
		try {
			int respuesta;
			client.connect("localhost");
			System.out.print(client.getReplyString());
			respuesta = client.getReplyCode();

			if (!SMTPReply.isPositiveCompletion(respuesta)) {
				client.disconnect();
				System.err.println("Conexión rechazada por el servidor.");
				System.exit(1);
			}

			client.login("localhost"); // inicio de sesión HELO
			String destinatario = "oscar.tutor.rubio@iestubalcain.net";
			String mensaje = "Hola. \nEste mensaje se envía desde un cliente Java\n";
			String remitente = "oscar.tutor.rubio@iestubalcain.net";

			if (client.sendSimpleMessage(remitente, destinatario, mensaje))
				System.out.println("El mensaje se ha enviado a " + destinatario);
			else
				System.out.println("El mensaje no se ha podido enviar");

			// final de sesión QUIT
			client.logout();

			client.disconnect();

		}catch(ConnectException ce){
			System.err.println("Servidor NO iniciado");			
			System.err.println(ce.getMessage());
			System.exit(2);
		}
		catch (IOException e) {
			System.err.println("No se ha podido conectar al servidor");
			e.printStackTrace();
			System.exit(2);
		}

	}
}