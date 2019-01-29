package P05_Ejercicio_Cliente_SMTP;

public class Controlador {

	public static void main(String[] args) throws Exception {
		
		String textServidor;
		String textUsuario;
		String textContrasena;
		String textRemitente;
		String textDestinatario;
		String textCc;
		String textAsunto;
		String mensaje;
		
		Vista gui = new Vista();
		gui.getFrmClienteSmtp().setVisible(true);
		
		while(true){
			System.out.println("Cliente SMTP");
			if(gui.getEnviar() && !gui.getTextAsunto().getText().equals("") && !gui.getTextMensaje().getText().equals("")) {
				textServidor = gui.getTextServidor().getText();
				textUsuario = gui.getTextUsuario().getText();
				textContrasena = gui.getTextContrasena().getText();
				textRemitente = gui.getTextRemitente().getText();
				textDestinatario = gui.getTextDestinatario().getText();
				textAsunto = gui.getTextAsunto().getText();
				textCc = gui.getTextCc().getText();
				mensaje = gui.getTextMensaje().getText();
				//
				Modelo modelo = new Modelo(textServidor, textUsuario, textContrasena, textRemitente, textDestinatario,
						textCc, textAsunto, mensaje);
				modelo.enviarCorreo();
			}
			gui.setEnviar(false);
		}
	}
}
