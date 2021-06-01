package Serveur;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

class Connection implements Runnable{
	private Socket in, out;
	private DataInputStream s_lecture;
	private DataOutputStream s_ecriture;
	Connection(Socket in, Socket out){
		this.in = in;
		this.out = out;
		try {
			s_ecriture = new DataOutputStream(out.getOutputStream());
			s_lecture = new DataInputStream(in.getInputStream());
		}catch(IOException e) {
			e.printStackTrace() ;
		
		}
	}
	public void run() {
		try {
			while(true) {
				String message = s_lecture.readUTF();
				s_ecriture.writeUTF(message);
				s_ecriture.flush();
			}
		}catch(IOException e) {}
		
	}}