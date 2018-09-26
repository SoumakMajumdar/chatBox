package chatBox;

import java.io.*;
import java.net.*;

import javax.swing.JTextField;

public class receiver extends Thread {
	static JTextField jf = new JTextField();
	public receiver(JTextField jf) {
	this.jf=jf;
	}

	public void run(){
		try {
			ServerSocket welcomeSocket = new ServerSocket(4567);
			while(true){
				
				Socket connectionSocket = welcomeSocket.accept();
				BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
				//OutputStream outToClient = connectionSocket.getOutputStream();
				String sentence = inFromClient.readLine();
				jf.setText(sentence);				
				connectionSocket.close();
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
