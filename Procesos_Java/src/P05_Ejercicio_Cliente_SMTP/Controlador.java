package P05_Ejercicio_Cliente_SMTP;

public class Controlador {

	public static void main(String[] args) throws Exception {
		
		Vista gui = new Vista();
		gui.getFrmClienteSmtp().setVisible(true);
		
		while(true){
			System.out.println("Cliente SMTP");
			if(gui.getEnviar() && !gui.getTextAsunto().getText().equals("") && !gui.getTextMensaje().getText().equals("")) {
				String textServidor = gui.getTextServidor().getText();
				String textUsuario = gui.getTextUsuario().getText();
				String textContrasena = gui.getTextContrasena().getText();
				String textRemitente = gui.getTextRemitente().getText();
				String textDestinatario = gui.getTextDestinatario().getText();
				String textAsunto = gui.getTextAsunto().getText();
				String textCc = gui.getTextCc().getText();
				String mensaje = gui.getTextMensaje().getText();
				//
				Modelo modelo = new Modelo(textServidor, textUsuario, textContrasena, textRemitente, textDestinatario,
						textCc, textAsunto, mensaje);
				modelo.enviarCorreo();
			}
			gui.setEnviar(false);
		}
	}
}
