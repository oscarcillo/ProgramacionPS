# Programación de comunicaciones en red

## Introducción
## Clases Java para comunicaciones en red

TCP/IP es una familia de protocolos para permitir la comunicación entre cualquier par de ordenadores de cualquier red o fabricante, respetando los protocolos de cada red individual. Afecta a 4 capas:

### Niveles OSI
* Físico
* Enlace
	* Es la interfaz con la red real. Comunica la capa de red con la física (el hardware).
* Red
	* Se dedica a seleccionar la mejor ruta para el envio de paquetes por la red. Protocolo IP.
* Transporte
	* Suministra a las aplicaciones un servicio de comunicaciones e2e mediante dos protocolos: TCP y UDP
* Sesión
* Presentación
* Aplicación
	* Son las aplicaciones que están disponibles para los usuarios: FTP, SMTP, TELNET...


Los equipos conectados a internet utilizan el procotolo TCP o UDP. Hay alguna diferencia entre ambos.

* TCP: Orientado a conexión. Se busca garantizar que los paquetes lleguen y que lo hagan de forma ordenada (conforme han sido enviados).
* UDP: No Orientado a conexión. Se envian datagramas sin garantizar que lleguen ni que lo hagan de forma ordenada.

### Los puertos
TCP y UDP utilizan puertos para asignar datos entrantes a un proceso en particular que se ejecuta en una máquina. Los datos transmitidos a través de Internet identifican la máquina y el puerto al que van destinados. Se destinan 32 bits (IPv4) para la máquina y 16 para el puerto. TCP una aplicación de servidor vincula un socket a un número de puerto específico, lo que supone registrar el servidor en el sistema para recibir los datos destinados a ese puerto. Por otro lado, en UDP el número de puerto se adjunta al datagrama para llegar a la aplicación correcta.


## Las clases
Cuando se escriben programas en Java, se trabaja a nivel de aplicación y se abstraen los protocolos de red mediante las clases presentes en el package *java.net* que incluye varias clases:

* URL; Cuyos objetos representan un puntero a un recurso en la Web.
* URLConnection; Para operaciones más complejas en las URL.
* ServerSocket y Socket, para dar soporte a sockets TCP. ServerSocket se utiliza desde el lado del servidor para crear un socket en el puerto en el que escucha las peticiones de conexión de los clientes. Socket por su parte se utiliza tanto en cliente como en servidor para comunicarse entre sí leyendo y escribiendo datos mediante streams.
* DatagramSocket MulticastSocket y DatagramPacket para el uso del protocolo UDP.
* InetAddress para representar direcciones de Internet. Tiene dos subclases *Inet4Address* e *Inet6Address*, aunque en la mayoría de los casos con la clase principal suele ser suficiente. Algunos de los métodos más relevantes de *InetAddress* son:


### La clase InetAddress

Algunos de los métodos más relevantes de *InetAddress* son:

* InetAddress getLocalHost() Devuelve un objeto de InetAddress que representa la dirección IP de la máquina donde se está ejecutando el programa.
* InetAddress getByName(String host) Devuelve un objeto de InetAddress que representa la dirección IP de la máquina que se especifica como parámetro (host). Este parámetro puede se el nombre de la máquina, un nombre de dominio o una IP. *Es el más habitual para crear objetos de la clase*. 
* InetAddress[] getAllByName(String host) Devuelve un array de InetAddress. Sirve para obtener todas las IP que tenga asignadas una máquina concreta.
* String getHostAddress() Devuelve la dirección IP de un objeto InetAddress en forma de cadena.
* String getHostName() Devuelve el nombre del host de un objeto InetAddress.
* String getCanonicalHostName() Obtiene el nombre canónico completo (suele ser la dirección real del host) de un objeto InetAddress.

### Los Sockets

* Socket designa un concepto abstracto por el cual dos programas (posiblemente situados en computadoras distintas) pueden intercambiar cualquier flujo de datos, generalmente de manera fiable y ordenada.

El término socket es también usado como el nombre de una interfaz de programación de aplicaciones (API) para la familia de protocolos de Internet TCP/IP, provista usualmente por el sistema operativo.

Los sockets de Internet constituyen el mecanismo para la entrega de paquetes de datos provenientes de la tarjeta de red a los procesos o hilos apropiados. Un socket queda definido por un par de direcciones IP local y remota, un protocolo de transporte y un par de números de puerto local y remoto. * Fuente: [Wikipedia, socket](https://es.wikipedia.org/wiki/Socket_de_Internet)

En nuestro contexto, los socket nos proporcionan los extremos de la comunicación entre aplicaciones y/o procesos. Es por lo tanto, un conector. Dicho conector debe tener asociados dos campos; dirección IP del equipo de destino y puerto local asignado a la aplicación.


### La clase ServerSocket (SOCKET TCP)

Viene incluida en java.net e implementa el lado del servidor en la comunicación. Establece un conector en el puerto que *escucha* las peticiones de los clientes.

### La clase Socket (SOCKET TCP)

También incluida en java.net, implementa el extremo de la conexión. 

### Proceso de gestión simple de Socket TCP

1. El programa servidor crea un socket servidor definiendo un puerto.
2. En caso de que el cliente solicite conectarse, debe aceptarlo mediante *accept()*. 
3. El cliente establecerá conexión a través del puerto especificado mediante *Socket(host, port)*.
4. Cliente y servidor se comunican mediante flujos *InputStream* y *OutputStream*

Pasos que se deben seguir:

1. Apertura de sockets
2. Creación de flujos (o Streams) de entrada
3. Creación de flujos de salida
4. Cierre de sockets

[Ejemplo Arquitectura cliente - servidor simple que comparten mensajes vía TCP]()


## Clases para Sockets UDP
A través de este protocolo, los sockets son más simples y eficientes aunque como ya se ha visto, no está garantizada la entrega de los paquetes (ni el orden). Dado que no hay "conexión" entre emisor y receptor, esta información debe indicarse para cada paquete que se envíe. Como ya se ha comentado, cada paquete UDP se denomina datagrama y contiene:

* Dirección IP de destino
* Puerto de destino
* Longitud del mensaje
* Cuerpo del mensaje (bytes)

### DatagramPacket y DatagramSocket
Estas clases pertenecientes a *java.net* modelan el envío y la creación de datagramas.

[*DatagramPacket*](https://docs.oracle.com/javase/7/docs/api/java/net/DatagramPacket.html) proporciona constructores para crear instancias de datagramas que se van a enviar y de los que van a ser recibidos. Vemos un ejemplo:

```JAVA
int puerto = 6543;
InetAddress destino = InetAddress.getLocalHost(); // Obtenemos la IP del host local

// Para decir cualquier otro host
// InetAddress destino = InetAddress.getByName("192.168.1.125");

byte[] mensaje = new byte[1024];

String saludo = "Hola UDP";
mensaje = saludo.getBytes(); // Hay que pasar la cadena a bytes para el envío

DatagramPacket paqueteUDP = new DatagramPacket(mensaje, mensaje.length, destino, puerto);

```

Mediante [*DatagramSocket*](https://docs.oracle.com/javase/7/docs/api/java/net/DatagramSocket.html) se puede generar el socket para enviar datagramas UDP. 

```JAVA

DatagramSocket socket = new DatagramSocket(34567);
socket.send(paqueteUDP);

```

Hasta ahora hemos visto como generar el paquete UDP y enviarlo. Para recibirlo, hace falta implementar el otro extremo de la comunicación. Para recibir, también se usa un *DatagramSocket*.

```JAVA
DatagramSocket socket = new DatagramSocket(12345);   

//ESPERANDO DATAGRAMA
System.out.println("Esperando Datagrama .......... ");  
DatagramPacket recibo = new DatagramPacket(bufer, bufer.length);

socket.receive(recibo);//recibo datagrama

int bytesRec = recibo.getLength();//obtengo numero de bytes
String paquete= new String(recibo.getData());//obtengo String

//VISUALIZO INFORMACIÓN
System.out.println("Número de Bytes recibidos: "+ bytesRec);    
System.out.println("Contenido del Paquete    : "+ paquete.trim());
System.out.println("Puerto origen del mensaje: "+ recibo.getPort());
System.out.println("IP de origen             : "+
                             recibo.getAddress().getHostAddress());   
System.out.println("Puerto destino del mensaje:" + 
                             socket.getLocalPort());	
socket.close(); //cierro el socket

````















