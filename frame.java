package chatBox;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.net.*;

public class frame {
	static JLabel j1 = new JLabel("Message");
	static JTextArea j2 = new JTextArea("msg");
	static JLabel j3 = new JLabel("IP");
	static JTextArea j4 = new JTextArea("IP");
	static JLabel j5 = new JLabel("Port");
	static JTextArea j6 = new JTextArea("PORT");
	static JTextField jf = new JTextField();
	static JButton b  = new JButton("Send");
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		try {
			f.setTitle(findIP());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JPanel p = new JPanel();
		f.add(p,BorderLayout.SOUTH);
		f.add(jf,BorderLayout.CENTER);
		p.add(j1);
		p.add(j2);
		p.add(j3);
		p.add(j4);
		p.add(j5);
		p.add(j6);
		
		p.add(b);
		f.setSize(500, 600); 
		f.setVisible(true);
		receiver r = new receiver(jf);
		r.start();
		b.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){ 
		    	try {
				Socket clientSocket = new Socket(j4.getText(),Integer.parseInt(j6.getText()));
				OutputStream outToServer = clientSocket.getOutputStream();
				BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				outToServer.write((j2.getText()+"\n").getBytes());
				clientSocket.close();
				}catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    }  
		}); 
	}
	public static String findIP() throws Exception {
		InetAddress IP = InetAddress.getLocalHost();
		return(IP.getHostAddress());
	}
}
