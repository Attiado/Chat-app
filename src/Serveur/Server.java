package Serveur;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) 
	{
	try {
		// TODO Auto-generated method stub
		ServerSocket serverSocket = 
				new ServerSocket(9000);
		System.out.println(" Demarrage serveur .. Serveur en écoute...");
		while(true) {
			Socket clt1 = serverSocket.accept();
			Socket clt2 = serverSocket.accept();
			new Thread(new Connection(clt1,clt2)).start();
			new Thread(new Connection(clt2,clt1)).start();
		}
		
	}
	catch (Exception e) {
		// TODO: handle exception
	}
	}
}


