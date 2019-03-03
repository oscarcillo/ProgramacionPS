# Técnicas de programación segura

## Introducción

Entre las técnicas más importantes para asegurar los sistemas y aplicaciones informáticas están la criptografía, los certificados digitales y el control de acceso.

Además, existen una serie de buenas prácticas que debemos conocer a la hora de escribir código de manera que podamos mejorar la seguridad del mismo.

En Java existen herramientas tanto para implantar los mecanismos de criptografía, sockets seguros, servicios de autenticación y autorización.

## Buenas prácticas de programación segura

* Conocer fallos que hayan podido cometer otros para evitarlos, estar informado.
* Tomar precauciones en el manejo de la información
* Revisión profunda de los procesos.
* Listas de control de seguridad.
* Reutilización de código comprobado.
* Puesta en valor del mantenimiento de software.
* Entender bien el problema para crear un diseño correcto.
* Elegir la tecnología más adecuada que se conozca o que se pueda investigar.
* Evitar copiar y pegar código de terceros a menos que se entienda bien su cometido. Copiar != reutilizar.
* Asegurar en la medida de lo posible que las librerías o frameworks que se utilicen no estén comprometidas por vulnerabilidades conocidas.

### Cuestiones a tener en cuenta para crear programas seguros

* Tener en cuenta a los usuarios. Son el eslabon más débil.
* No aceptar deadlines imposibles, que pasen por alto la calidad y/o seguridad.
* *You get what you pay for*.
* *Low cost = Low Quality*.

## Malas prácticas de programación

* Usar rutas relativas de ficheros. Son preferibles las absolutas.
* Hardcodear nombres de ficheros.
* Utilizar almacenamiento con permisos de escritura (permitiría el borrado, etc.).
* Almacenar datos confidenciales en bases de datos no protegidas.
* Mostrar el eco de passwords.
* Facilitar password por email.
* Almacenar o enviar passwords (u otra información sensible) sin cifrar.
* Establecer criterios de acceso en función de variables de entorno u otros parámetros pasados en tiempo de ejecución.
* Evitar confiar en terceros (software o servicios) en situaciones críticas.
* *Confiar* en los usuarios.
* ...

## Técnicas de seguridad

*El activo más importante que se posee es la información y, por lo tanto, deben existir técnicas que la aseguren, más allá de la seguridad física que se establezca sobre los equipos en los cuales se almacena. Estas técnicas las brinda la seguridad lógica que consiste en la aplicación de barreras y procedimientos que resguardan el acceso a los datos y solo permiten acceder a ellos a las personas autorizadas para hacerlo.*

*Cada tipo de ataque y cada sistema requiere de un medio de protección o más (en la mayoría de los casos es una combinación de varios de ellos).* [Fuente](https://es.wikipedia.org/wiki/Seguridad_informática#Técnicas_para_asegurar_el_sistema)

### Criptografía

*Básicamente, la criptografía es la técnica que protege documentos y datos. Funciona a través de la utilización de cifras o códigos para escribir algo secreto en documentos y datos confidenciales que circulan en redes locales o en internet. Su utilización es tan antigua como la escritura. Los romanos usaban códigos para ocultar sus proyectos de guerra de aquellos que no debían conocerlos, con el fin de que sólo las personas que conocían el significado de estos códigos descifren el mensaje oculto.*

*A partir de la evolución de las computadoras, la criptografía fue ampliamente divulgada, empleada y modificada, y se constituyó luego con algoritmos matemáticos. Además de mantener la seguridad del usuario, la criptografía preserva la integridad de la web, la autenticación del usuario así como también la del remitente, el destinatario y de la actualidad del mensaje o del acceso.* [Fuente](https://tecnologia-informatica.com/que-es-la-criptografia/)

En la imagen, se describe el proceso general para cifrar y descifrar mensajes. Los elementos a tener en cuenta son la __clave__ y el __algoritmo criptográfico__ que permiten obtener el texto cifrado a partir del texto legible y viceversa.

![alt text][crypto]

[crypto]: https://cdncontribute.geeksforgeeks.org/wp-content/uploads/Encryption_vs_Encoding_vs_Hashing_1.png "Esquema básico de cifrado/descifrado. Fuente: https://cdncontribute.geeksforgeeks.org/wp-content/uploads/Encryption_vs_Encoding_vs_Hashing_1.png"

#### Existen 3 grupos principales de algoritmos criptográficos.

Estos algoritmos, como ya se ha visto, modifican los datos con el objetivo de proporcionar características de seguridad tales como la integridad, confidencialidad o autenticación. [Tipos de criptografía](https://www.genbeta.com/desarrollo/tipos-de-criptografia-simetrica-asimetrica-e-hibrida)

##### Criptografía simétrica

Se basa en la utilización de __una sola clave__ para cifrar y descifrar los mensajes. De aquí resulta obvio que dicha clave debe permanecer lo más secreta posible.

El principal inconveniente es que emisor y receptor han de conocer previamente la clave para poder intercambiar información.

##### Criptografía asimétrica

Se basa en la utilización de __pares de claves__ para encriptar la información. Una de las claves permite cifrar la información y es pública, mientras que la otra permite descifrar y es privada o secreta. El funcionamiento es que un actor crea el par de claves y difunde la pública, para que otros cifren la información que desean enviarle, y al recibirla, descifrar mediante la clave privada.

La principal ventaja es que nadie necesita conocer la clave privada para poder cifrar la información. La desventaja es que es más lento.

* [Generación de claves en Windows](https://www.siteground.es/kb/generar-clave-ssh-windows/)

##### Funciones Hash

También denominadas [funciones de resumen](https://es.wikipedia.org/wiki/Función_hash). Reciben una cadena de texto habitualmente y la convierten en una cadena de texto, habitualmente finita. Son funciones de un solo sentido, porque solo permiten cifrar la información, no descifrarla. Es decir, si tenemos una información x y le aplicamos la función hash f(x), este proceso es sencillo. Ahora bien, es prácticamente imposible obtener x a partir de f(x).

Este tipo de funciones se emplean por ejemplo en mecanismos de firma digital. Los algoritmos más utilizados de este tipo son [MD5](https://es.wikipedia.org/wiki/MD5) y los del tipo [SHA](https://es.wikipedia.org/wiki/Secure_Hash_Algorithm)

[Software para calcular md5 de ficheros en Windows](https://www.microsoft.com/en-us/download/details.aspx?id=11533)


### Firma digital

El concepto es análogo al de la firma manuscrita tradicional. Su objetivo, por lo tanto, es asegurar la identidad del firmante. El método de firma más habitual o extendido es el [RSA](https://es.wikipedia.org/wiki/RSA), basado en las funciones hash ya comentadas.


El proceso es iniciado por el __emisor__ del mensaje, quien genera un hash del mensaje *mh1*. Posteriormente se cifra dicho hash con una clave privada. El resultado de la operación de cifrado es lo que se denomina firma digital y se envía junto con el mensaje al que se quiere dar autenticidad de origen. 

El __receptor__ por su parte separa el mensaje de la firma que ha recibido, aplica la misma función de resumen que el emisor al mensaje, *mh2*. Descifra la firma mediante la clave pública del emisor, con lo que obtiene *mh1*. 

*mh1* y *mh2* deben ser iguales para garantizar la validez de la firma digital.


![alt text][digitalSignature]

[digitalSignature]: https://upload.wikimedia.org/wikipedia/commons/9/94/Digital_signature_process.png "digital Signature Process Fuente https://upload.wikimedia.org/wikipedia/commons/9/94/Digital_signature_process.png"


### Certificados digitales

El Certificado Digital es el único medio que permite garantizar técnica y legalmente la identidad de una persona en Internet. Se trata de un requisito indispensable para que las instituciones puedan ofrecer servicios seguros a través de Internet. 

* Permite la firma electrónica de documentos. El receptor de un documento firmado puede tener la seguridad de que éste es el original y no ha sido manipulado y el autor de la firma electrónica no podrá negar la autoría de esta firma.

* Permite cifrar las comunicaciones. Solamente el destinatario de la información podrá acceder al contenido de la misma.

* Consta de un par de claves criptográficas, una pública y una privada.

* El titular del certificado debe guardar cautelosamente la clave privada, ya que si ésta es sustraída, se podría suplantar su identidad en la red. En caso de pérdida o sustracción de la clave privada el titular debe __revocar__ el certificado lo antes posible.

* La clave pública forma parte de lo que se denomina Certificado Digital en sí, que es un documento digital que contiene la clave pública junto con los datos del titular, todo ello firmado electrónicamente por una __Autoridad de Certificación__, que es una tercera entidad que asegura que la clave pública se corresponde con los datos del titular.

* La Autoridad de Certificación se encarga de emitir los certificados para los titulares tras comprobar su identidad.

* El formato de los Certificados Digitales está definido por el estándar internacional [X.509](https://es.wikipedia.org/wiki/X.509).


### Control de acceso

* Identificación. El usuario provee datos de sí mismo.
* Autenticación. *La autenticación o autentificación1​es el acto o proceso de confirmar que algo (o alguien) es quien dice ser* [Fuente](https://es.wikipedia.org/wiki/Autenticación)
* Autorización. *Se usa para decidir si la persona, programa o dispositivo "X" tiene permiso para acceder al dato, funcionalidad o servicio Y.* [Fuente](https://es.wikipedia.org/wiki/Autorización)

[Protocolo AAA](https://es.wikipedia.org/wiki/Protocolo_AAA)

## Seguridad en Java

### [Introducción](https://www.uv.es/sto/cursos/seguridad.java/html/sjava-1.html)

* ¿Qué quiere decir que un lenguaje de programación es seguro? Las maneras en que un lenguaje de programación puede causar vulnerabilidades en las aplicaciones, las comunicaciones o en la integridad de datos son diversas. Estos problemas están muy relacionados con el acceso a memoria. Para solucionarlos, Java se diseñó eliminando características de otros lenguajes tales como:

	* Eliminación de la aritmética con punteros. Java la elimina por completo la aritmética con punteros, que es una de las mayores fuentes de accesos ilegales a memoria en otros lenguajes. Java maneja el concepto de la referencia, que permite definir estructuras dinámicas complejas como listas, colas, árboles, etc. igual que en otros lenguajes.

	* Comprobación de rangos en el acceso a vectores. Se produce una excepción cuando se intenta efecturar accesos fuera de rango.  

	* Definición del comportamiento de las variables sin inicializar. En Java toda la memoria del heap se inicializa automáticamente, y la memoria de la pila, que es la que emplean las variables locales, debe ser inicializada por el programador (si en un programa se intenta usar una variable local antes de asignarle un valor el compilador genera un error.

	* Eliminación de la liberación de memoria controlada directamente por el programador, mediante el recolector de basura.

* Otros aspectos que contribuyen a reforzar la seguridad en Java son:

	* La verificación de tipos en tiempo de compilación, para garantizar que las variables son de los tipos correctos.

	* Establecimiento de  niveles de acceso a los atributos y métodos de las clases, que permite controlar su visiblidad.

	* El modificador __final__, para poder impedir que se definan subclases cuando se aplica a una clase o que se puedan redefinir atributos.

Como se conoce previamente, en Java, la ejecución del código pasa por una compilación a bytecodes que posteriormente son interpretados por la Máquina virtual Java (JVM). Además, previamente a que la JVM empiece a interpretar los bytecodes, debe realizar una serie de tareas para preparar el entorno en el que se ejecutará el programa. Aquí interviene la seguridad interna de Java, donde hay tres componentes:


* [Cargador de clases](http://eljaviador.com/cargador-de-clases.html). 

	* Este elemento separa las clases que carga para evitar ataques. Existen 3 tipo de cargadores:
		* Bootstrap ClassLoader : Carga las clases de /lib del JRE
		* Extensions ClassLoader : Carga las clases de /lib/ext de JRE
		* System ClassLoader : Carga el classpath. También llamado Application ClassLoader

* Verificador de archivos de clases. 
	
	* Se ocupa de validar los bytecodes. El sistema distingue entre código considerado fiable (generalmente las clases del sistema y las validadas por el usuario) y código no fiable. Las clases de origen *fiable* no se validan, pero el resto sí.

* Gestor de seguridad (SecurityManager).

	* Comprueba el acceso en tiempo de ejecución en aspectos tales como si el proceso actual puede acceder a un package o fichero concreto, si puede crear un subproceso, aceptar conexiones desde un host o puerto concreto, etc. 

	* El SecurityManager se puede instalar configurando la propiedad del sistema java.security.manager en la línea de comandos al iniciar la JVM: ```java -Djava.security.manager <main class name>``` o programáticamente desde el código de Java: ```System.setSecurityManager(new SecurityManager())```. Vemos un ejemplo del acceso a la información sin y con gestor.

```java
public class PropiedadesSistema {
	public static void main(String[] args) {	
		String t[] = { "os.name", "os.version", 
					"user.dir", "user.home", "user.name"
					"java.class.path", "java.home", 
					"java.vendor", "java.version"};
        
		for (int i = 0; i < t.length; i++) {
			System.out.print("Propiedad:" + t[i]);
			try {
				String s = System.getProperty(t[i]);
				System.out.println("\t==> " + s);
			} catch (Exception e) {
				System.err.println("\n\tExcepción " + e.toString());
			}
		}
	}
}
```

[Ejemplo de configuración del gestor de seguridad](https://fluidattacks.com/web/es/defends/java/configurar-gestor-seguridad/)

### Ficheros de políticas en Java

El Java SecurityManager estándar otorga permisos sobre la base de una *Política*, que se define en un __fichero de políticas__. Si no se especifica ningún archivo de políticas, se utilizará el archivo de políticas predeterminado en $JAVA_HOME/lib/security/java.policy. 

El fichero __java.security__ (ubicado en $JAVA_HOME/conf/security) recoge las localizaciones de los distintos ficheros de políticas. Así se pueden definir varios ficheros de políticas (por ejemplo uno distinto para cada aplicación) y dichos ficheros pueden estar en ubicaciones diferentes. 

#### Grant

El fichero de políticas recoge los permisos habilitados para la aplicación a la que se aplica. Mediante la sentencia __grant__ se especifican los permisos.

La ejecución de un programa con una política de seguridad concreta es: ```java -Djava.security.policy=nombreFichero.policy nombreAplicacion```

Se utiliza para conceder permisos del sistema y contiene una secuencia de entradas (denominadas grant cada una de ellas porque empiezan por esta sentencia), cada una de ellas tiene una o más entradas, el formato básico es el siguiente:

```java
grant codeBase "URL"{
      permission Nombre_clase "Nombre_destino", "Acción";
      permission Nombre_clase "Nombre_destino", "Acción";
}
```

A la derecha de *codeBase* se indica la ubicación del código base sobre el que se van a definir los permisos. Su valor es una URL y siempre se debe utiliza la barra diagonal (/ incluso en Windows) como separador de directorio. Por ejemplo: ```grant codeBase “file:/C:/path/to/directory/”```

Si no se especifica *codeBase* los permisos se aplican a todas las fuentes.

*Nombre_clase* contiene el nombre de la clase de permisos, por ejemplo:
java.io.FilePermission (representa acceso a fichero o directorio)
java.net.SocketPermission (acceso a la red vía socket)
java.util.PropertyPermission (permiso sobre propiedades del sistema), etc.

El parámetro *Nombre_destino* especifica el destino del permiso y depende de la clase de permiso.
Por ejemplo si la clase de permiso es java.io.FilePermission en *Nombre_destino* se puede poner un fichero o un directorio; si la clase es java.net.SocketPermission se pondría un servidor y un número de puerto; si es java.util.PropertyPermission se pondría una propiedad del sistema.

En el parámetro *Acción* se indica una lista de acciones separadas por comas, por ejemplo read, write, delete o execute para una clase de permiso java.io.FilePermission; accept, listen, connect, resolve para una clase de permiso java.netSocketPermission; read, write para una clase de permiso java.util.PropertyPermission.

[Referencia permisos EN](http://docs.oracle.com/javase/8/docs/technotes/guides/security/permissions.html)


Se puede consultar los permisos, sus destinos y acciones.

[Ejemplos de ficheros de Políticas](http://www.programandoapasitos.com/2016/03/procesos-y-servicios-programacion_24.html)


#### PolicyTool

Es una herramienta para facilitar las tareas de gestión de políticas; Crear y modificar los archivos externos de configuración de política que definen la política de seguridad Java de la instalación. [Tutorial oficial Oracle EN](https://docs.oracle.com/javase/tutorial/security/tour1/wstep1.html)

## Criptografía en Java. JCA

[JCA, Java Cryptography Architecture](https://docs.oracle.com/javase/9/security/java-cryptography-architecture-jca-reference-guide.htm#JSSEC-GUID-2BCFDD85-D533-4E6C-8CE9-29990DEB0190) es un *framework* para acceder y desarrollar funciones criptográficas en Java. Se basa en dos principios:

* Idependencia e interoperabilidad de las implementaciones:

	* La independencia de la implementación se consige empleando una __arquitectura basada en proveedores__. Un *proveedor* de servicios criptográficos puede definirse como un __paquete o conjunto de ellos que proporciona una implementación concreta de aspectos criptográficos de la API de seguridad de Java__ tales como algoritmos de firmado, funciones de dispersión o conversión de claves. Los proveedores deben poder cambiarse de modo transparente para las aplicaciones.

	* La interoperabilidad de las implementaciones significa que cada una de ellas puede trabajar con el resto, utilizar claves generadas por otra implementación o verificar sus claves.

* Independencia y extensibilidad de los algoritmos:

	* La independencia de los algoritmos se consigue definiendo tipos de servicios criptográficos y definiendo clases que proporcionan la funcionalidad de estos servicios. Estas clases se denominan *clases motor* y ejemplos de ellas son las clases MessageDigest, Signature y KeyFactory.

	* La extensibilidad de los algoritmos significa que nuevos algoritmos que entren dentro de alguno de los tipos soportados (compatibles con las clases motor) puedan ser añadidos fácilmente.


[Recurso](http://www.programandoapasitos.com/2016/03/procesos-y-servicios-programacion_25.html)


JCA comprende por lo tanto:

* El marco que define y apoya los servicios criptográficos para que los proveedores faciliten implementaciones. Este marco incluye paquetes como:

	* java.security.cert
	* java.security.spec
	* java.security.interfaces
	* javax.crypto
	* javax.crypto.spec
	* javax.crypto.interfaces

* Los proveedores reales, tales como Sun, SunJCE, SunRsaSign... las implementaciones criptográficas reales. El proveedor es el encargado de proporcionar la implementación de uno o varios algoritmos al programador. Los proveedores de seguridad se definen en el fichero java.security situado en la carpeta *java.home\lib\security*. Forman una lista de entradas con un número que indican el orden de búsqueda cuando en los programas no se especifica un proveedor.

	* security.provider.1=sun.security.provider.Sun
	* security.provider.2=sun.security.rsa.SunRsaSign
	* security.provider.3=com.sun.net.ssl.internal.ssl.Provider
	* security.provider.4=com.sun.crypyo.provider.SunJCE
	* security.provider.5=sun.security.jgss.SunProvider



JCA define el concepto de proveedor mediante la clase [provider](https://docs.oracle.com/javase/9/security/java-cryptography-architecture-jca-reference-guide.htm#JSSEC-GUID-D8E30FE5-66B4-4F6A-88B7-280789E68307) [javadoc](https://docs.oracle.com/javase/8/docs/api/java/security/Provider.html) del paquete java.security. Se trata de una clase abstracta que debe ser redefinida por clases proveedor específicas.

Existen dos modos de añadir o eliminar los proveedores instalados en un sistema:

* Estáticamente, editando las entradas del fichero java.security

* Dinámicamente, invocando desde el programa los métodos addProvider() o insertProvider() de la clase java.security.Security para añadirlos o al método removeProvider()

* Si se desea saber los proveedores disponibles puede emplear los métodos getProvider("nombre") (para saber si un proveedor concreto está instalado) o getProviders() (que retorna un vector de cadenas con los nombres de los proveedores).

### Resúmenes de Mensajes. [Message-Digest](https://docs.oracle.com/javase/7/docs/api/java/security/MessageDigest.html)

Se trata de una marca digital asociada a un bloque de datos. Algoritmos que se han visto y procesan este tipo de resúmenes son sha-1 y md5. También se suelen denominar checksum. Aunque las implementaciones pueden variar hay dos propiedades comunes a este tipo de algoritmos:

* No deben revelar nada sobre la entrada que lo generó.
* Es imposible (o debería) encontrar dos mensajes con el mismo valor.


### Generación y comprobación de firmas digitales. 

Como ya se ha visto, el objetivo de las firmas digitales es aseverar la autenticidad del origen y el contenido de una información. La clase *[KeyPairGenerator](https://docs.oracle.com/javase/9/security/java-cryptography-architecture-jca-reference-guide.htm#JSSEC-GUID-71693272-7F57-4155-99F9-A2139271FD6D)* modela la creación de pares de claves.



## Comunicaciones seguras en Java

[Recurso](http://www.programandoapasitos.com/2016/03/procesos-y-servicios-programacion_26.html)

### SSLSocket y SSLServerSocket

Modelan los comportamientos ya vistos en la UD3 mediante el uso del protocolo SSL. Vemos ejemplo de servidor y cliente.

## Control de acceso en Java

 En Java, hay definida una interfaz, denominada [JAAS](https://docs.oracle.com/javase/8/docs/technotes/guides/security/jaas/JAASRefGuide.html)  (Java Authentication and Authorization Service, Servicio de Autorización y Autenticación de Java) que permite gestionar los servicios de control de autenticación y acceso en las aplicaciones.

Se puede utilizar para dos propósitos:
* Para la __autenticación__ de usuarios, es decir, determinar de forma fiable y segura quién está ejecutando nuestro código Java

* Para la __autorización__ de los usuarios; asegurar que quien ejecuta una determinada funcionalidad tiene los permisos necesarios para llevar a cabo dicha acción.

En estos procesos están involucradas las clases e interfaces:

* LoginContext, contexto de inicio de sesión: clase para iniciar y gestionar el proceso de autenticación mediante la creación de un Subject. La autenticación se hace llamando al método login().

* LoginModule, módulo de conexión: interfaz para definir los mecanismos de autenticación. Se deben implementar los siguientes métodos: iniatilize(), login(), commit(), abort() y logout(). Se encarga de validar los datos en un proceso de autenticación.

* Subject, clase para representar a un ente autenticable (entidad, usuario, sistema).

* Principal, clase que representa los atributos que posee cada Subject recuperado una vez que se efectúa el ingreso a la aplicación. Un Subject puede contener varios principales.

* CallBackHandler, encargado de la interacción con el usuario para obtener los datos necesarios para la autenticación. Se debe implementar el método handle().

* Los paquetes en los que están disponibles las clases e interfaces principales de JAAS son:
	* javax.security.auth.* que contiene las clases de base e interfaces para los mecanismos de autenticación y autorización.
	* javax.security.auth.callback.* que contiene las clases e interfaces para definir las credenciales de autenticación de la aplicación.
	* javax.security.auth.login.* que contiene las clases para entrar y salir de un dominio de aplicación.
	* javax.security.auth.spi.* que contiene las interfaces para un proveedor de JAAS para implementar módulos JAAS.


### Proceso de autenticación JAAS

De la forma más básica, la autenticación JAAS consta de los pasos siguientes:

1. Creación de una instancia de LoginContext, uno o más LoginModulo son cargados basándose en el archivo de configuración de JAAS.
2. La instanciación de cada LoginModule es opcionalmente provista con un CallbackHandler que gestionará el proceso de comunicación con el usuario para obtener los datos con los que este tratará de autenticarse.
3. Invocación del método login() del LoginContext el cual invocará el método login() del LoginModule.
4. Los datos del usuario se obtienen por medio del CallbackHandler.
5. El LoginModule comprueba los datos introducidos por el usuario y los valida. Si la validación tiene éxito el usuario queda autenticado.


### Proceso de autorización JAAS

Se basa en el uso de políticas de seguridad. Una vez autenticado un usuario mediante JAAS, se establece un *Subject* que representa al usuario. Dicho *Subject* se compone de un conjunto de principales, donde cada principal representa un atributo para el usuario en cuestión, por ejemplo el nombre y DNI de una persona constituyen dos principales. Para poder llevar a cabo la autorización, es necesario:

* El usuario debe autenticarse como se ha contemplado previamente.
* En el fichero de políticas se deben configurar entradas para los principales
* Se debe asociar al *Subject* el contexto de control de acceso actual usando los métodos doAs() o doAsPrivileged() de la clase Subject.


## Recursos

* [JCA Referencia oficial EN](https://docs.oracle.com/javase/9/security/java-cryptography-architecture-jca-reference-guide.htm#JSSEC-GUID-2BCFDD85-D533-4E6C-8CE9-29990DEB0190)
* [JSSE Referencia oficial EN](https://docs.oracle.com/javase/8/docs/technotes/guides/security/jsse/JSSERefGuide.html)
* [JAAS Referencia oficial EN](https://docs.oracle.com/javase/8/docs/technotes/guides/security/jaas/JAASRefGuide.html)

* [Manejo de certificados con keytool](https://www.adictosaltrabajo.com/2005/09/09/security-ssl-keytool/)

### Buenas prácticas

[INCIBE](https://www.incibe.es)

[Desarrollo seguro OWASP](https://www.owasp.org/images/9/93/Desarrollo_Seguro_Principios_y_Buenas_Pr%C3%A1cticas..pdf)

[Buenas prácticas INCIBE](https://www.incibe.es/sites/default/files/contenidos/dosieres/metad_buenas_practicas_en_el_area_de_informatica.pdf)

[Consejos Desarrollo Seguro ](https://www.welivesecurity.com/la-es/2015/03/12/10-consejos-desarrollo-seguro-de-aplicaciones/)
