package P06_ComunicacionesSeguras;

import java.io.*;
import javax.net.ssl.*;

public class E01_ClienteSSL {
     
      public static void main(String[] args) throws Exception {
           
           
            //System.setProperty("javax.net.ssl.trustStore", "src\\P06_ComunicacionesSeguras\\claveSSL\\AlmacenSSLConfianzaServidor");
            //System.setProperty("javax.net.ssl.trustStorePassword", "123456");
           
            String Host = "localhost";
            int puerto = 6000;
           
            System.out.println("PROGRAMA CLIENTE INICIADO....");
            SSLSocketFactory sfact = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket Cliente = (SSLSocket) sfact.createSocket(Host, puerto);
           
            // CREO FLUJO DE SALIDA AL SERVIDOR
            DataOutputStream flujoSalida = new DataOutputStream(Cliente.getOutputStream());
           
            // ENVIO UN SALUDO AL SERVIDOR   
            flujoSalida.writeUTF("Saludos al SERVIDOR DESDE EL CLIENTE");
           
            // CREO FLUJO DE ENTRADA AL SERVIDOR
            DataInputStream flujoEntrada = new DataInputStream(Cliente.getInputStream());
           
            // EL SERVIDOR ME ENVIA UN MENSAJE
            System.out.println("Recibiendo del SERVIDOR: \n\t" + flujoEntrada.readUTF());
           
            /*------------------------------------------------------------------------------
            //Información sobre la sesión SSL
            SSLSession session = ((SSLSocket) Cliente).getSession(); 
            System.out.println("Host: "+session.getPeerHost());
            System.out.println("Cifrado: " + session.getCipherSuite());
            System.out.println("Protocolo: " + session.getProtocol());
            System.out.println("IDentificador:" + new BigInteger(session.getId()));
            System.out.println("Creación de la sesión: " + session.getCreationTime());

            X509Certificate certificate = (X509Certificate)session.getPeerCertificates()[0];
            System.out.println("Propietario: " + certificate.getSubjectDN());
            System.out.println("Algoritmo: " + certificate.getSigAlgName());
            System.out.println("Tipo: " + certificate.getType());
            System.out.println("Emisor: " + certificate.getIssuerDN());
            System.out.println("Número Serie: " + certificate.getSerialNumber());
            ------------------------------------------------------------------------------*/
           
            // CERRAR STREAMS Y SOCKETS
            flujoEntrada.close();
            flujoSalida.close();
            Cliente.close();
           
      }// Fin de main
     
}// Fin de ClienteSSL