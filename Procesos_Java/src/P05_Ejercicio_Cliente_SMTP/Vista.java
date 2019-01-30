package P05_Ejercicio_Cliente_SMTP;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.TextArea;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Canvas;
import java.awt.Color;

public class Vista implements KeyListener, MouseListener{

	private JFrame frmClienteSmtp;
	private JTextField textServidor;
	private JTextField textUsuario;
	private JPasswordField textContrasena;
	private JTextField textRemitente;
	private JTextField textDestinatario;
	private JTextField textAsunto;
	private JTextField textCc;
	private TextArea textMensaje;
	
	private boolean enviar = false;

	/**
	 * Create the application.
	 */
	public Vista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClienteSmtp = new JFrame();
		frmClienteSmtp.setTitle("Cliente SMTP");
		frmClienteSmtp.setResizable(false);
		frmClienteSmtp.setBounds(100, 100, 499, 632);
		frmClienteSmtp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClienteSmtp.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(25, 24, 169, 43);
		frmClienteSmtp.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel textserv = new JLabel("Direccion del servidor");
		textserv.setBounds(0, 0, 131, 14);
		panel.add(textserv);
		
		textServidor = new JTextField();
		textServidor.setBounds(0, 17, 141, 20);
		panel.add(textServidor);
		textServidor.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(25, 102, 225, 43);
		frmClienteSmtp.getContentPane().add(panel_1);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(0, 0, 86, 14);
		panel_1.add(lblUsuario);
		
		textUsuario = new JTextField();
		textUsuario.setColumns(10);
		textUsuario.setBounds(0, 17, 215, 20);
		panel_1.add(textUsuario);
		textUsuario.addKeyListener(this);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(260, 102, 196, 43);
		frmClienteSmtp.getContentPane().add(panel_2);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setBounds(0, 0, 86, 14);
		panel_2.add(lblContrasea);
		
		textContrasena = new JPasswordField();
		textContrasena.setColumns(10);
		textContrasena.setBounds(0, 17, 186, 20);
		textContrasena.setEchoChar('*');
		panel_2.add(textContrasena);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(25, 185, 346, 43);
		frmClienteSmtp.getContentPane().add(panel_3);
		
		JLabel lblRemitente = new JLabel("Remitente");
		lblRemitente.setBounds(0, 0, 86, 14);
		panel_3.add(lblRemitente);
		
		textRemitente = new JTextField();
		textRemitente.setColumns(10);
		textRemitente.setBounds(0, 17, 264, 20);
		panel_3.add(textRemitente);
		
		Canvas canvas = new Canvas();
		canvas.setBounds(71, -20, 161, 14);
		panel_3.add(canvas);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBounds(25, 231, 346, 43);
		frmClienteSmtp.getContentPane().add(panel_4);
		
		JLabel lblDestinatario = new JLabel("Destinatario");
		lblDestinatario.setBounds(0, 0, 86, 14);
		panel_4.add(lblDestinatario);
		
		textDestinatario = new JTextField();
		textDestinatario.setColumns(10);
		textDestinatario.setBounds(0, 17, 264, 20);
		panel_4.add(textDestinatario);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBounds(25, 320, 346, 43);
		frmClienteSmtp.getContentPane().add(panel_5);
		
		JLabel lblAsunto = new JLabel("Asunto");
		lblAsunto.setBounds(0, 0, 86, 14);
		panel_5.add(lblAsunto);
		
		textAsunto = new JTextField();
		textAsunto.setColumns(10);
		textAsunto.setBounds(0, 17, 264, 20);
		panel_5.add(textAsunto);
		
		JButton botonEnviar = new JButton("Enviar");
		botonEnviar.setBounds(367, 557, 89, 23);
		frmClienteSmtp.getContentPane().add(botonEnviar);
		botonEnviar.addMouseListener(this);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBounds(25, 276, 346, 43);
		frmClienteSmtp.getContentPane().add(panel_6);
		
		JLabel lblC = new JLabel("Cc");
		lblC.setBounds(0, 0, 86, 14);
		panel_6.add(lblC);
		
		textCc = new JTextField();
		textCc.setColumns(10);
		textCc.setBounds(0, 17, 264, 20);
		panel_6.add(textCc);
		
		textMensaje = new TextArea();
		textMensaje.setColumns(1);
		textMensaje.setBounds(25, 369, 431, 172);
		frmClienteSmtp.getContentPane().add(textMensaje);
		
		Canvas canvas_1 = new Canvas();
		canvas_1.setBackground(Color.BLACK);
		canvas_1.setBounds(25, 164, 438, 1);
		frmClienteSmtp.getContentPane().add(canvas_1);
		
		Canvas canvas_2 = new Canvas();
		canvas_2.setBackground(Color.BLACK);
		canvas_2.setBounds(25, 83, 438, 1);
		frmClienteSmtp.getContentPane().add(canvas_2);
	}
	
	//Key Listener
	
	@Override
	public void keyPressed(KeyEvent e) {}
	

	@Override
	public void keyReleased(KeyEvent e) {
		textRemitente.setText(textUsuario.getText());
	}
	

	@Override
	public void keyTyped(KeyEvent e) {}
	
	//Mouse Listener

	@Override
	public void mouseClicked(MouseEvent arg0) {
		this.enviar = true;
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent arg0) {	}

	@Override
	public void mouseReleased(MouseEvent arg0) {}
	
	//GETTERS y SETTERS

	
	public boolean getEnviar() {
		return enviar;
	}
	
	public void setEnviar(boolean enviar) {
		this.enviar = enviar;
	}
	
	public JTextField getTextServidor() {
		return textServidor;
	}

	public JTextField getTextUsuario() {
		return textUsuario;
	}

	public JTextField getTextContrasena() {
		return textContrasena;
	}

	public JTextField getTextRemitente() {
		return textRemitente;
	}
	
	public JTextField getTextDestinatario() {
		return textDestinatario;
	}
	
	public JTextField getTextAsunto() {
		return textAsunto;
	}

	public JTextField getTextCc() {
		return textCc;
	}
	
	public JFrame getFrmClienteSmtp() {
		return this.frmClienteSmtp;
	}
	
	public TextArea getTextMensaje() {
		return this.textMensaje;
	}
}
