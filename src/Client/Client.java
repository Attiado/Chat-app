package Client;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client extends JFrame{
	private JTextField message;
	private JTextArea chat;
	private Socket socket;
	private DataInputStream s_lecture;
	public static int i=1 ;
	private DataOutputStream s_ecriture;
	Client()
	{
	try {		
		socket = new Socket("127.0.0.1", 9000);
		s_lecture = new DataInputStream(socket.getInputStream());
		s_ecriture = new DataOutputStream(socket.getOutputStream());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		message = new JTextField(30);
		Font font =new Font("Verdana",Font.BOLD,15);
		chat = new JTextArea(30,30);
		this.chat.setFont(font);
		this.chat.setBackground(Color.yellow);

		add(message, BorderLayout.SOUTH);
		add(chat, BorderLayout.CENTER);
	
		this.setTitle("Je suis un client ");
		message.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					s_ecriture.writeUTF(message.getText());
					s_ecriture.flush();
					chat.append("Moi: "+message.getText()+"\n");
					message.setText("");
				}catch(IOException e) {}
				
			}
			
		});
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		
		while(true) {
			String MSG = s_lecture.readUTF();
			chat.append("Un ami : "+MSG+"\n");
			//Thread.sleep(100);
		}
		
	}
	catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}}
	public static void main(String[] args) 
	
	{			
				new Client();
				
		
	}
}