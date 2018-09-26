package chatBox;

import java.io.*;
import java.net.*;

import javax.swing.JTextArea;

public class receiver extends Thread {
	static JTextArea jf = new JTextArea();
	public receiver(JTextArea jf) {
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
				sentence = sentence + "\n";
				jf.setText(jf.getText() + sentence);				
				connectionSocket.close();
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
