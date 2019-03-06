# Generación de Servicios en Red

## Introducción

*Un servicio de red es la creación de una red de trabajo en un ordenador. Generalmente los servicios de red son instalados en uno o más firewalles del servidor seleccionado. Eso facilita el uso y el fallo de muchos usuarios.* [Wikipedia, Servicios de red](https://es.wikipedia.org/wiki/Servicio_de_red)

Además, puede decirse que son programas auxiliares utilizados para gestionar recursos. Cabe pensar en la utilización que se hace de herramientas que se utilizan de forma remota: una impresora en red, el intercambio de ficheros, etc. Todos ellos constituyen ejemplos de servicios de red. El esquema más habitual de arquitectura en este tipo de servicios es cliente-servidor.

## Protocolos estándar de comunicación en red a nivel de aplicación (ftp, http, pop3, smtp, telnet).

A partir del modelo TCP/IP se constituyen toda una serie de servicios o aplicaciones en los niveles más altos del esquema OSI. Por poner unos ejemplos:

* TELNET (Conexión remota)
* FTP (File Transfer Protocol)
* SNMP (Simple Network Management Protocol)
* SMTP (Simple Mail Transfer Protocol)
* HTTP o HTTPS (Hiper Text Transfer Protocol (Secure))

Otras herramientas como DNS o TFTP pueden estar basadas en el protocolo UDP y también son servicios de red. Se suelen considerar habitualmente de la misma familia que los anteriores.

## Protocolo FTP

*El Protocolo de transferencia de archivos (en inglés File Transfer Protocol o FTP) es un protocolo de red para la transferencia de archivos entre sistemas conectados a una red TCP (Transmission Control Protocol), basado en la arquitectura cliente-servidor. Desde un equipo cliente se puede conectar a un servidor para descargar archivos desde él o para enviarle archivos, independientemente del sistema operativo utilizado en cada equipo.* [Wikipedia, Protocolo FTP](https://es.wikipedia.org/wiki/Protocolo_de_transferencia_de_archivos)

### Acceso anónimo y autorizado

* Anónimo:  La comunicación se realiza sin ningún tipo de identificación y, por lo tanto el usuario tendrá muy pocos privilegios en el servidor. En este caso, el usuario estará confinado en un directorio público donde puede descargar los archivos allí ubicados pero sin posibilidad de escribir o modificar ningún fichero.

* Autorizado:  El usuario establece la comunicación con una cuenta de usuario. Tras identificarse, se dirige al usuario a su directorio predeterminado desde el que puede descargar ficheros y escribir si está autorizado. Este tipo de acceso es el habitual a la hora de gestionar los contenidos de servidores web.

### Comunicación con el servidor FTP

Este protocolo utiliza dos conexiones diferentes, una para el control y otra para la transferencia de los datos. La primera establece y mantiene la comunicación cliente-servidor y la segunda ejecuta las transferencias de información. Mientras que la primera está abierta mientras dura la sesión, la segunda solo se produce cuando hay transferencia de información. Ambas usan puertos diferentes 21 y 20 respectivamente del lado del servidor y aleatorios en el cliente, suele ser lo más habitual. El cliente tiene dos modos de actuar, activo y pasivo.


* Modo Activo

Es el modo FTP estándar o PORT, donde el cliente envía comandos tipo PORT al servidor al establecer la conexión.

En el modo activo el servidor siempre crea el canal de datos en su puerto 20, mientras que el cliente se asocia a un puerto aleatorio mayor a 1024.

Para esto, el cliente envía un comando PORT al servidor por el canal control, indicando el número de puerto, para así lograr la conexión de datos para la transferencia de los archivos.

Este tipo de FTP tiene un grave problema de seguridad; el cliente puede aceptar cualquier conexión de entrada lo que la vuelve susceptible.

Los equipos con cortafuegos, rechazan estas conexiones aleatorias.

![alt-text](http://www.worldofintegration.com/sites/default/files/pictures_for_content/WOI_protocols/FTPactive.JPG "Esquema Modo Activo. Fuente: http://www.worldofintegration.com/sites/default/files/pictures_for_content/WOI_protocols/FTPactive.JPG")


* Modo Pasivo

En el modo pasivo, es siempre el programa del cliente quien inicia la conexión con el servidor.

El cliente en el modo pasivo inicia ambas conexiones (control y datos), por lo que la conexión no es filtrada por el cortafuegos.

Una vez creada la primera conexión, el cliente pasa a modo pasivo enviando el comando PASV y pidiendo un puerto abierto al servidor, para así establecer la conexión final.

En este caso, no se utiliza el canal de datos del puerto 20 del servidor, a diferencia de como ocurre siempre en el modo activo.

Antes de cada nueva transferencia en cualquiera de los modos, el cliente debe enviar otra vez un comando control, ya sea PORT o PASV.


![alt-text](http://www.worldofintegration.com/sites/default/files/pictures_for_content/WOI_protocols/FTP_Passive.jpg "Esquema Modo Pasivo. Fuente: http://www.worldofintegration.com/sites/default/files/pictures_for_content/WOI_protocols/FTP_Passive.jpg")

#### Códigos de respuesta en FTP

FTP utiliza un esquema de códigos de respuesta donde cada dígito tiene un significado concreto. Son números en ASCII de tres dígitos (XYZ) y significan lo siguiente


X: Indica si la respuesta es buena, mala o incompleta.

1 = Preliminar positiva 
2 = Completamente positiva 
3 = Positiva intermedia 
4 = Negativa transiente 
5 = Negativa permanente

Y: especifica el tipo de respuesta:

1 = Status de archivo o help 
2 = Status de conexión 
3 = Información de usuario 
4 = No especificada 
5 = Acción no tomada

Z: Mayor detalle sobre la respuesta, por ejemplo:

120   Servicio listo en nnn minutos (1XX) 
200   comando OK (2XX) 
230   User login correcto 
331   Login de usuario correcto, necesita password (3XX) 
425   No puede establecerse la conexión de datos (4XX) 
500   Error de sintaxis, comando no reconocido (5XX)

[Listado Wikipedia EN](https://en.wikipedia.org/wiki/List_of_FTP_server_return_codes)


### Cliente FTP en Java

Se modela básicamente mediante dos clases *[FTPClient](https://commons.apache.org/proper/commons-net/apidocs/org/apache/commons/net/ftp/FTPClient.html)* y *[FTPReply](https://commons.apache.org/proper/commons-net/apidocs/org/apache/commons/net/ftp/FTPReply.html)* ambas de la librería [Apache Commons Net](http://commons.apache.org/proper/commons-net/)

Otra clase importante en la gestión de ficheros es *[FTPFile](https://commons.apache.org/proper/commons-net/apidocs/org/apache/commons/net/ftp/FTPFile.html)*

Vemos ejemplos de código. 

[Ejemplo Descarga Carpeta](https://es.stackoverflow.com/questions/115650/descargar-una-carpeta-de-ftp-desde-java-usando-ftpclient-apache-commons-net)


## Protocolo SMTP

[SMTP (Simple Mail Transfer Protocol)](https://es.mailjet.com/blog/news/servidor-smtp/) es el protocolo habitual usado en Internet para el envío de correos electrónicos. 

El funcionamiento del protocolo se produce mediante comandos de texto y el puerto habitualmente utilizado es el 25. El servidor responde a cada comando ejecutado por el cliente con un [código](https://www.greenend.org.uk/rjk/tech/smtpreplies.html) y un mensaje de respuesta. 

### Configuración del servidor
[XAMPP](https://www.apachefriends.org/es/download.html) incorpora Mercury, y hay abundancia de [tutoriales](http://00l1.blogspot.com/2010/06/como-enviar-correos-desde-localhost-con.html) sobre la configuración del servidor en nuestro equipo local.

* Nota sobre el uso de servidores externos (Gmail, Outlook, etc): Si desde nuestro servidor se pretende utilizar una cuenta correspondiente a cualquiera de estos proveedores, se debe facultar en el perfil de usuario correspondiente el [acceso a aplicaciones menos seguras](https://support.google.com/a/answer/6260879?hl=es). Esto conviene hacerlo únicamente con propósitos de prueba y sería recomendable desactivarlo una vez concluidas las pruebas.

Para probarlo una vez configurado, es posible probar el envío de emails mediante el [cliente Telnet, ejemplo](https://docs.microsoft.com/es-es/exchange/mail-flow/test-smtp-with-telnet?view=exchserver-2019) que incorpora Windows 10. En caso de no tener el cliente Telnet activado habrá que ir a la configuración de aplicaciones y activarlo.

[otro ejemplo](http://amestoy.info/enviar-correo-via-smtp-utilizando-telnet/)


#### Comandos básicos SMTP

| COMANDO | Función |
| ---------- | ---------- |
| HELO o EHLO | Iniciar una sesión con el servidor. |
|MAIL FROM |	Identificación del emisor. |
|RCPT TO |	Identificación del destinatario.|
|DATA	| Comienzo del mensaje.|
|QUIT	| Finalización de la sesión.|
|HELP	| Muestra la lista de comandos admitidos por el servidor.|

Es posible consultar un listado más detallado de los [comandos SMTP](https://www.dsi.uclm.es/personal/miguelfgraciani/mikicurri/Docencia/LenguajesInternet0910/web_LI/Teoria/Protocolos%20de%20nivel%20de%20aplicacion/Material/Comandos%20del%20protocolo%20SMTP.htm)

### Comunicación con el servidor SMTP mediante JAVA

*Apache Commons Net* proporciona la clase ___[SMTPClient](https://commons.apache.org/proper/commons-net/apidocs/org/apache/commons/net/smtp/SMTPClient.html)___ que reune la funcionalidad necesaria para enviar ficheros a través de un servidor SMTP. De forma análoga a otras clases derivadas de _SocketClient_, la clase __[SMTP](https://commons.apache.org/proper/commons-net/apidocs/org/apache/commons/net/smtp/SMTP.html)__ lo es, es necesario establecer conexión con el servidor antes de lanzar cualquier otra operación y es preciso desconectarse al terminarlas. 

Una vez establecida la conexión al servidor, la clase ___[SMTPReply](https://commons.apache.org/proper/commons-net/apidocs/org/apache/commons/net/smtp/SMTPReply.html)___ recoge diversas constantes sobre los códigos de respuesta SMTP, aunque es conveniente poder consultar el listado completo ya visto previamente.

A continuación, se muestra un ejemplo de cliente para enviar un mensaje simple de correo:

```java
import java.io.IOException;
import java.net.ConnectException;

import org.apache.commons.net.smtp.AuthenticatingSMTPClient;
import org.apache.commons.net.smtp.SMTPClient;
import org.apache.commons.net.smtp.SMTPReply;

public class EnviarMensaje {

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

			client.login(); // inicio de sesión HELO
			String destinatario = "gomezmorata@iestubalcain.net";
			String mensaje = "Hola. \nEste mensaje se envía desde un cliente Java\n";
			String remitente = "alumno@localhost.es";

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
```
Si se usa el servidor Mercury incluido en el XAMPP es conveniente consultar los mensajes que va devolviendo el servidor SMTP. Si se produce un error de HELO incorrecto (SMTP 554), puede solucionarse de la siguiente manera:

*In mercury logs, you will see this message ""554 Invalid HELO format" on valid HELOs/EHLO".
It is due to the RFC compliance from mercury which isn't RFC compliant.
Here is the fix :
locate "transfltr.mer" in mercury folder, edit it with notepad or whatever.
Locate this line at the end of the file :
H, "[EHeh][EHeh]LO +[0-9]+.[0-9]+.[0-9]+.[0-9]", R, "554 Invalid HELO format"
comment it out (add # at the begining of the line) restart the mail server then.
If you want to turn mercury into RFC compliant, add this line above the one you commented out :
H, "[EHeh][EHeh]LO +[0-9]+.[0-9]+.[0-9]+.[0-9]+.", X, ""*


La clase __[SimpleSMTPHeader](https://commons.apache.org/proper/commons-net/apidocs/org/apache/commons/net/smtp/SimpleSMTPHeader.html)__ modela la construcción de la cabecera para el envío de emails. 

```java
import java.io.IOException;
import java.io.Writer;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.net.smtp.AuthenticatingSMTPClient;
import org.apache.commons.net.smtp.SMTPClient;
import org.apache.commons.net.smtp.SMTPReply;
import org.apache.commons.net.smtp.SMTPSClient;
import org.apache.commons.net.smtp.SimpleSMTPHeader;

public class ClienteSMTPConHeaders {

	public static void main(String[] args)  {
		SMTPClient client= new SMTPClient();
		 try {
		      int respuesta;
		      client.connect("localhost");
		      System.out.print(client.getReplyString());
		      respuesta = client.getReplyCode();

		      if(!SMTPReply.isPositiveCompletion(respuesta)) {
		        client.disconnect();
		        System.err.println("SMTP server refused connection.");
		        System.exit(1);
		      }
		      
		      client.login();
		    
		      String remitente ="remitente@localhost.es";
		      String destino1="fulanito@iestubalcain.net";
		      String destino2="menganito@iestubalcain.net";		      
		      String asunto="Prueba de SMTPClient con Headers";
		      String mensaje = "Hola. \nEnviando prueba desde cliente Java con Headers\n";
		      
		      //se crea la cabecera
		      SimpleSMTPHeader cabecera = new SimpleSMTPHeader
		    		  (remitente , destino1, asunto);		      
		      cabecera.addCC(destino2);
		      
		      //establecer el correo de origen
		      client.setSender(remitente);
		      
		      //añadir correos destino 
		      client.addRecipient(destino1);//hay que añadir los dos
		      client.addRecipient(destino2);
		     
		      //se envia DATA al servidor
		      Writer writer = client.sendMessageData();   
		      if(writer == null) { //fallo	       
		    	  System.out.println("Fallo al enviar DATA.");			     
			      System.exit(1);
		      }
		      
		      System.out.println(cabecera.toString());
		      writer.write(cabecera.toString()); //primero escribo cabecera    
	          writer.write(mensaje);//luego mensaje
	          writer.close();
	          
	       	  if(!client.completePendingCommand())  { //fallo
	       		  System.out.println("Fallo al finalizar la transacción.");			     
			      System.exit(1);
		      }
		      
	       	  client.logout(); 
	          client.disconnect();
	          
		    } catch (IOException e) {
				System.err.println("No se puede conectar al servidor.");
				e.printStackTrace();
				System.exit(2);
			}
		    
		    System.exit(0);
		}
}
```
#### Mecanismos de autenticación

La autenticación en el protocolo SMTP tiene como objetivo el aumento de los niveles de seguridad. De forma más general, busca evitar el uso de una dirección de correo de forma no autorizada. Se modela mediante la clase __[AuthenticatingSMTPClient](https://commons.apache.org/proper/commons-net/apidocs/org/apache/commons/net/smtp/AuthenticatingSMTPClient.html)__, que extiende a __[SMTPSClient](https://commons.apache.org/proper/commons-net/apidocs/org/apache/commons/net/smtp/SMTPSClient.html)__. Cuando se usa este protocolo, los puertos pueden cambiar: 465, 587 se dan con frecuencia en lugar del 25 de STMP.

A grandes rasgos, el empleo de estas clases supone la implementación de SMTP sobre SSL (Secure Socket Layer). TLS (Transport Layer Security) trabaja al nivel de la capa de transporte y supone una mejora sobre el SSL.

El comando __[STARTTLS](https://es.wikipedia.org/wiki/STARTTLS)__ busca incorporar un mayor nivel de privacidad al envío de emails. Establece el cifrado de las comunicaciones entre cliente y servidor. 

Mediante STMPSClient se pueden definir dos modos de seguridad; __explícito__ e __implícito__. En este último, la negociación SSL/TLS tiene comienzo cuando ya se ha establecido la conexión. Por el contrario, en el explícito, la negociación se inicia al llamar al método __execTLS()__ y que el servidor acepte dicho comando.


La autenticación SMTP puede darse de varias formas, gestionadas por la clase ya vista, __AuthenticatingSMTPClient__, que permite al cliente iniciar sesión mediante alguno de los métodos de autenticación que soporte el servidor. Tiene varios constructores para acomodarse a distintos protocolos o codificaciones. Los métodos más relevantes son __auth__ y __ehlo__ que envían los mensajes AUTH (con el método y los valores de usuario/password) y EHLO al servidor (con el nombre del servidor), respectivamente.

```java
import java.io.IOException;
import java.io.Writer;
import java.security.InvalidKeyException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.spec.InvalidKeySpecException;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import org.apache.commons.net.smtp.*;

public class ClienteSMTPAutenticado {
	public static void main(String[] args) throws NoSuchAlgorithmException, UnrecoverableKeyException,
			KeyStoreException, InvalidKeyException, InvalidKeySpecException {

		// se crea cliente SMTP seguro
		AuthenticatingSMTPClient client = new AuthenticatingSMTPClient();

		// datos del usuario y del servidor
		String server = "smtp.gmail.com";
		String username = "correo@gmail.com";
		String password = "claveusuario";
		int puerto = 587;
		String remitente = "correo@gmail.com";

		try {
			int respuesta;

			// Se crea la clave para establecer un canal seguro
			KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
			kmf.init(null, null);
			KeyManager km = kmf.getKeyManagers()[0];

			// Conexión al servidor SMTP
			client.connect(server, puerto);
			System.out.println("1 - " + client.getReplyString());
			
			// Establecimiento de la clave para la comunicación segura
			client.setKeyManager(km);

			respuesta = client.getReplyCode();
			if (!SMTPReply.isPositiveCompletion(respuesta)) {
				client.disconnect();
				System.err.println("Conexión rechazada.");
				System.exit(1);
			}

			// se envía el commando EHLO
			client.ehlo(server);
			System.out.println("2 - " + client.getReplyString());

			// Necesita negociación TLS - MODO NO IMPLICITO
			
			// Se ejecuta el comando STARTTLS y se comprueba si es true
			if (client.execTLS()) {
				System.out.println("3 - " + client.getReplyString());

				// se realiza la autenticación con el servidor
				if (client.auth(AuthenticatingSMTPClient.AUTH_METHOD.LOGIN, username, password)) {
					System.out.println("4 - " + client.getReplyString());
					String destino1 = "fulanito@gmail.com";
					String asunto = "Prueba de SMTPClient con Gmail";
					String mensaje = "Esto es una prueba de mensaje con usuario autenticado desde Java.";
					// se crea la cabecera
					SimpleSMTPHeader cabecera = new SimpleSMTPHeader(remitente, destino1, asunto);

					// el nombre de usuario y el email de origen coinciden
					client.setSender(remitente);
					client.addRecipient(destino1);
					System.out.println("5 - " + client.getReplyString());

					// se envia DATA
					Writer writer = client.sendMessageData();
					if (writer == null) { // fallo
						System.out.println("Fallo al enviar DATA.");
						System.exit(1);
					}

					writer.write(cabecera.toString()); // cabecera
					writer.write(mensaje);// luego mensaje
					writer.close();
					System.out.println("6 - " + client.getReplyString());

					boolean exito = client.completePendingCommand();
					System.out.println("7 - " + client.getReplyString());

					if (!exito) { // fallo
						System.out.println("Fallo al finalizar transacción.");
						System.exit(1);
					} else
						System.out.println("Mensaje enviado con exito......");

				} else
					System.out.println("USUARIO NO AUTENTICADO.");
			} else
				System.out.println("FALLO AL EJECUTAR  STARTTLS.");

		} catch (IOException e) {
			System.err.println("Could not connect to server.");
			e.printStackTrace();
			System.exit(1);
		}
		try {
			client.disconnect();
		} catch (IOException f) {
			f.printStackTrace();
		}

		System.out.println("Fin del envío.");
		System.exit(0);
	}
}
```


### Otros protocolos involucrados en el envío/acceso a emails

* Protocolo de Oficina de Correo [POP](https://es.wikipedia.org/wiki/Protocolo_de_oficina_de_correo). La versión actual es la 3 y habitualmente se suele referir a dicho protocolo exclusivamente en referencia a dicha versión como POP3. Las clases Java que modelan el acceso a un servidor POP3 están incluidas en Apache Commons Net y son:

	* [POP3Client](https://commons.apache.org/proper/commons-net/apidocs/org/apache/commons/net/pop3/POP3Client.html). De forma a análoga a SMTPClient, implementa el lado cliente de POP3
	* [POP3SClient](https://commons.apache.org/proper/commons-net/apidocs/org/apache/commons/net/pop3/POP3SClient.html). Versión con soporte SSL de la clase anterior
	* [POP3MessageInfo](https://commons.apache.org/proper/commons-net/apidocs/org/apache/commons/net/pop3/POP3MessageInfo.html). Modela la obtención de información de los mensajes presentes en el servidor POP3


##### Comandos POP3


| Comando	| Descripción |
|-----------|-------------|
| USER | identification	Este comando permite la autenticación. Debe estar seguido del nombre de usuario, es decir, una cadena de caracteres que identifique al usuario en el servidor. El comando USER debe preceder al comando password
| PASS | El comando PASS permite especificar la contraseña del usuario cuyo nombre ha sido especificado por un comando USER previo. |
| STAT	| Información acerca de los mensajes del servidor |
| RETR num |	Número del mensaje a recuperar |
| DELE num |	Número del mensaje a eliminar |
| LIST [msg] |	Número del mensaje a mostrar |
|NOOP |	Permite mantener la conexión abierta en caso de inactividad |
|TOP <messageID> <n>	| Comando que muestra n líneas del mensaje, cuyo número se da en el argumento. En el caso de una respuesta positiva del servidor, éste enviará de vuelta los encabezados del mensaje, después una línea en blanco y finalmente las primeras n líneas del mensaje |
|UIDL [msg] |	Solicitud al servidor para que envíe una línea que contenga información sobre el mensaje que eventualmente se dará en el argumento. Esta línea contiene una cadena de caracteres denominada unique identifier listing (lista de identificadores únicos) que permite identificar de manera única el mensaje en el servidor, independientemente de la sesión. El argumento opcional es un número relacionado con un mensaje existente en el servidor POP, es decir, un mensaje que no se ha borrado|
| QUIT | El comando QUIT solicita la salida del servidor POP3. Lleva a la eliminación de todos los mensajes marcados como eliminados y envía el esta acción. |

* Internet Message Access Protocol [IMAP](https://es.wikipedia.org/wiki/Protocolo_de_acceso_a_mensajes_de_Internet). Más moderno que POP3. Actualmente en la versión 4. Almacena los mensajes en el servidor (POP3 no).

	* [IMAPClient](http://commons.apache.org/proper/commons-net/apidocs/org/apache/commons/net/imap/IMAPClient.html)
	* [IMAPSClient](http://commons.apache.org/proper/commons-net/apidocs/org/apache/commons/net/imap/IMAPSClient.html)

* Multipurpose Internet Mail Extensions [MIME](https://es.wikipedia.org/wiki/Multipurpose_Internet_Mail_Extensions)

## Servidores Java