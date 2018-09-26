package chatBox;

import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.net.*;

public class sender extends Thread {
  private JButton b;
  private JTextField j2, j4, j6;

  public sender(JButton b, JTextField j2, JTextField j4, JTextField j6)
  {
    this.b = b;
    this.j2 = j2;
    this.j4 = j4;
    this.j6 = j6;
  }

  public void run()
  {
    b.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
		    	try {
				Socket clientSocket = new Socket(j4.getText(),Integer.parseInt(j6.getText()));
				OutputStream outToServer = clientSocket.getOutputStream();
				BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				outToServer.write((j2.getText()+"\n").getBytes());
				clientSocket.close();
				}catch (UnknownHostException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		    }
		});
  }
}
