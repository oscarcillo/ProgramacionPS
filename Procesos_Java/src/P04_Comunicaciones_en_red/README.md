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
System.out.println("IP de origen             : "+ recibo.getAddress().getHostAddress());   
System.out.println("Puerto destino del mensaje:" + socket.getLocalPort());	
socket.close(); //cierro el socket
```

### Socket Multicast

Mediante la clase [*MulticastSocket*](https://docs.oracle.com/javase/7/docs/api/java/net/MulticastSocket.html) es posible enviar paquetes a varios destinatarios de forma simultánea. Para ello es necesario establecer en primer lugar el grupo de destinatarios, es decir, distintas direcciones ip pero con el mismo puerto. Dado que la creación del grupo de destinatarios es independiente del mensaje, puede decirse que los destinatarios son transparentes para el emisor (no conoce cuántos son ni sus direcciones).

Para definir el grupo multicast se utiliza una [dirección IP](https://es.wikipedia.org/wiki/Dirección_IP) de la clase D y un puerto UDP. El rango de las direcciones IP de clase D abarca de la 224.0.0.0 a la 239.255.255.255, si bien la primera no debe utilizarse.

Como ya se ha visto para definir los sockets UDP la misma clase que modela el objeto que envía el socket, modela el que los recibe. Vemos un ejemplo:

```java
public class MulticastEmisor {
    private DatagramSocket socket;
    private InetAddress grupo;
    private byte[] buf;
 
    public void multicast(
      String multicastMessage) throws IOException {
        socket = new DatagramSocket();
        grupo = InetAddress.getByName("230.0.0.0");
        buf = multicastMessage.getBytes();
 
        DatagramPacket informacion = new DatagramPacket(buf, buf.length, grupo, 4446);
        socket.send(informacion);
        socket.close();
    }
}

// Cliente que escucha hasta que llega la cadena fin.
public class MulticastReceptor extends Thread {
    protected MulticastSocket socket = null;
    protected byte[] buf = new byte[256];
 
    public void run() {
        
        socket = new MulticastSocket(4446);
        InetAddress grupoMulticast = InetAddress.getByName("230.0.0.0");
        socket.joinGroup(grupoMulticast);
        
        while (true) {
            
            DatagramPacket informacion = new DatagramPacket(buf, buf.length);
            socket.receive(informacion);
            String recibido = new String(informacion.getData(), 0, informacion.getLength());
            System.out.println(recibido);
            
            if ("fin".equals(recibido)) {
                break;
            }
        }
        socket.leaveGroup(grupoMulticast);
        socket.close();
    }
}
```
Como se ve el proceso es bastante sencillo, implica los siguientes pasos por parte del emisor:

1. Creación del socket y grupo (señalar la IP multicast a utilizar).
2. Construir el mensaje
3. Envío
4. Cierre del socket.

Por su parte el receptor debe:

1. Crear el socket y unirse al grupo multicast
2. Escuchar los mensajes
3. Abandonar el grupo si se desea
4. Cierre del socket.

## Envío de objetos mediante sockets

A la hora de llevar a cabo el envío de otro tipo de información distinta de las cadenas de caracteres o números hay que conocer las clases que modelan el envío de objetos a través de sockets. En función del protocolo a utilizar se emplearán unas clases u otras.

### Envío de objetos mediante sockets basados en TCP

Como ya se ha visto para cadenas, hay que construir *streams* o flujos que contendrán la información a enviar. Cuando se trata de objetos, este comportamiento se modela mediante las clases [*ObjectInputStream*](https://docs.oracle.com/javase/7/docs/api/java/io/ObjectInputStream.html) y [*ObjectOutputStream*](https://docs.oracle.com/javase/7/docs/api/java/io/ObjectOutputStream.html)

```java
public class TCPObjetoServidor1 {
  public static void main(String[] arg) throws IOException,
						ClassNotFoundException {
   int numeroPuerto = 6543;// Puerto local para el envío
   ServerSocket servidor =  new ServerSocket(numeroPuerto);
   System.out.println("Esperando al cliente.....");   
   Socket cliente = servidor.accept();
	
   //flujo de salida para objetos 		
   ObjectOutputStream objSalida = new ObjectOutputStream(cliente.getOutputStream()); 	
   
   // Se prepara un objeto y se envía 
   PersonaModel persona = new PersonaModel("Pedro", 43);
   objSalida.writeObject(persona); //enviando objeto
   System.out.println("Envio: " + persona.getNombre() +", "+ persona.getEdad());  

   
   // Se obtiene un stream para leer objetos
   ObjectInputStream objetoEntrada = new ObjectInputStream(cliente.getInputStream());
   PersonaModel dato = (PersonaModel) objetoEntrada.readObject();
   System.out.println("Recibo: "+dato.getNombre()+", "+dato.getEdad());
		
   // CERRAR STREAMS Y SOCKETS
   objSalida.close();
   objetoEntrada.close();
   cliente.close();
   servidor.close();
  }
}

/*

	* Importante crear en los dos lados los flujos de entrada y salida. Primero se crea el de salida y luego el de entrada.
	* Ver Javadoc object stream header
	* El modelo que se use como objeto a intercambiar debe ser serializable (implementar dicho interface)

*/

public class TCPObjetoCliente1 {
  public static void main(String[] arg) throws IOException,ClassNotFoundException {
    
    String Host = "localhost";
    int Puerto = 6543;//puerto del servidor	
		
    System.out.println("PROGRAMA CLIENTE INICIADO....");
    Socket cliente = new Socket(Host, Puerto);	
	
    //Flujo de entrada
    ObjectInputStream objEntrada = new ObjectInputStream(cliente.getInputStream());
    
    //Se recibe un objeto
    PersonaModel personaRec = (PersonaModel) objEntrada.readObject();//recibo objeto
    System.out.println("Recibo: " personaRec.getNombre()+"*" personaRec.getEdad());
	
    //Modifico el objeto
    personaRec.setNombre("Pepito Perez");
    personaRec.setEdad(55);
	
    //Flujo de salida
    ObjectOutputStream objSalida = new ObjectOutputStream(cliente.getOutputStream());
    
    // Se envía el objeto
    objSalida.writeObject(personaRec);
    System.out.println("Envio: " personaRec.getNombre()+", " personaRec.getEdad());                       
		
    // CERRAR STREAMS Y SOCKETS
    objEntrada.close();
    objSalida.close();
    cliente.close();		
  }
}
```

### Envío de objetos mediante sockets basados en UDP

Para poder hacer el intercambio de objetos Java mediante sockets UDP se pueden utilizar las clases [ByteArrayOutputStream](https://docs.oracle.com/javase/7/docs/api/java/io/ByteArrayOutputStream.html) y [ByteArrayInputStream](https://docs.oracle.com/javase/7/docs/api/java/io/ByteArrayInputStream.html). Como se supondrá, el objeto debe convertirse en un array de bytes.

```java 
Persona persona = new Persona("Juan", 25);

// OBJETO A BYTES
ByteArrayOutputStream baos = new ByteArrayOutputStream();
ObjectOutputStream out = new ObjectOutputStream(baos);

out.writeObject(persona); //Se escribe el objeto persona en el stream

out.close(); // Se cierra el stream

byte[] bytes = baos.toByteArray(); // se toma  el objeto transformado en bytes

/* 
 * En cambio, para los datos recibidos (bytes) por el datagrama en un objeto Persona habría que hacer lo siguiente:
*/

// BYTES A OBJETO
byte[] recibido = new byte[1024];
DatagramPacket paqRecibido = new DatagramPacket(recibido, recibido.length);
socket.receive(paqRecibido);

//Pasamos bytes a objeto
ByteArrayInputStream bais = new ByteArrayInputStream(recibido);
ObjectInputStream in = new ObjectInputStream(bais);
Persona persona = (Persona)in.readObject(); //Se obtiene el objeto recibido como bytes
in.close();
```


## Gestión de clientes múltiples (threads)

Cuando se necesita que un servidor pueda atender a más de un cliente de forma simultánea, se impone la necesidad de la programación *multihilo* de manera que cada cliente pueda ser atendido por un hilo. 

En TCP, la filosofía básica es crear un servidor común que acepte las peticiones de los clientes, pero de forma que cada una de ellas sea gestionada por un _hilo_ diferente. 

```java
import java.io.*;
import java.net.*;

public class Servidor {
  public static void main(String args[]) throws IOException  {
    ServerSocket servidor;    
    servidor = new ServerSocket(6000);
    
    while (true) {  
      Socket cliente = new Socket();
      cliente=servidor.accept();//esperando cliente 
      HiloServidor hilo = new HiloServidor(cliente);
      hilo.start();   
    }
  }
}
```

En este caso por ejemplo, el cliente envía una cadena al servidor que éste devuelve en mayúsculas hasta que reciba un asterisco (que finaliza la conexión con el cliente). En la clase _HiloServidor_ se hace la gestión de cada cliente.


```java 
import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String args[]) throws IOException  {
        ServerSocket servidor;      
        servidor = new ServerSocket(6000);
        System.out.println("Servidor iniciado...");
        
        while (true) {  
            Socket cliente = new Socket();
            cliente=servidor.accept();//esperando cliente   
            HiloServidor hilo = new HiloServidor(cliente);
            hilo.start();       
        }
    }
}
```
Las operaciones de un cliente concreto se gestionan por el hilo, lo que permite que el servidor se mantenga a la escucha y no interrumpa su proceso mientras que los clientes ven resueltas sus peticiones. Vemos un algoritmo en el que el servidor devolverá la cadena recibida pero en mayúsculas hasta que reciba un asterisco.

```java
import java.io.*;
import java.net.*;

public class HiloServidor extends Thread {
  BufferedReader fentrada;
  PrintWriter fsalida;
  Socket socket = null;

  public HiloServidor(Socket s) throws IOException {// CONSTRUCTOR
    socket = s;
    // se crean flujos de entrada y salida
    fsalida = new PrintWriter(socket.getOutputStream(), true);
    fentrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
  }

  public void run() {// tarea a realizar con el cliente
    String cadena = "";

    System.out.println("COMUNICO CON: " + socket.toString());

    while (!cadena.trim().equals("*")) {

      try {
        cadena = fentrada.readLine();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } // obtener cadena
      fsalida.println(cadena.trim().toUpperCase());// enviar mayúscula
    } // fin while

    System.out.println("FIN CON: " + socket.toString());

    fsalida.close();
    try {
      fentrada.close();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    try {
      socket.close();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
```

Para el cliente, podria servir alguno de los ya vistos en las secciones previas. Por ejemplo el siguiente:

```java
public class Cliente {
  public static void main(String[] args) throws IOException {
    String Host = "localhost";
    int Puerto = 6000;// puerto remoto
    Socket Cliente = new Socket(Host, Puerto);
        
    // CREO FLUJO DE SALIDA AL SERVIDOR 
    PrintWriter fsalida = new PrintWriter (Cliente.getOutputStream(), true);
    // CREO FLUJO DE ENTRADA AL SERVIDOR    
    BufferedReader fentrada =  new BufferedReader
         (new InputStreamReader(Cliente.getInputStream()));
         
    // FLUJO PARA ENTRADA ESTANDAR
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String cadena, eco="";
        
    
    do{ 
        System.out.print("Introduce cadena: ");
        cadena = in.readLine();
        fsalida.println(cadena);
        eco=fentrada.readLine();            
        System.out.println("  =>ECO: "+eco);    
    } while(!cadena.trim().equals("*"));
        
    fsalida.close();
    fentrada.close();
    System.out.println("Fin del envío... ");
    in.close();
    Cliente.close();
    }
}
```
