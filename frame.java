package chatBox;

import java.awt.*;
import javax.swing.*;
import java.net.*;

public class frame {
	static JLabel j1 = new JLabel("Message");
	static JTextField j2 = new JTextField("                            :");
	static JLabel j3 = new JLabel("IP");
	static JTextField j4 = new JTextField("                            :");
	static JLabel j5 = new JLabel("Port");
	static JTextField j6 = new JTextField("          :");
	static JTextArea jf = new JTextArea();
	static JButton b  = new JButton("Send");
	static receiver r = new receiver(jf);
	static sender s = new sender(b, j2, j4, j6, jf);

	public static void main(String[] args) {
		JFrame f = new JFrame();
		try {
			f.setTitle(findIP());
		} catch (Exception e) {
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

		r.start();
		s.start();
	}
	public static String findIP() throws Exception {
		InetAddress IP = InetAddress.getLocalHost();
		return(IP.getHostAddress());
	}
}