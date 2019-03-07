package ExamenEvaluacion2;

import java.io.*;
import java.net.*;

public class E01_TCPServer {

  public static void main(String[] arg) throws IOException {

	int portNumber = 5050; 

	ServerSocket server = new ServerSocket(portNumber);
	Socket client = null;

	System.out.println("Waiting for clients...");
	client = server.accept();


	InputStream input = null;
	input = client.getInputStream();
	DataInputStream inputData = new DataInputStream(input);
	System.out.println("RECEIVED FROM CLIENT: \n\t" + inputData.readUTF());

	
	OutputStream output = null;
	output = client.getOutputStream();
	DataOutputStream outputData = new DataOutputStream(output);
	outputData.writeUTF("Greetings from server side");

	input.close();
	inputData.close();

	output.close();
	outputData.close();

	client.close();
	server.close();
  }
  
}