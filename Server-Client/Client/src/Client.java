import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Client extends JFrame {
	public static void main(String[] args) throws IOException,
			HeadlessException, ClassNotFoundException {
		String a = JOptionPane.showInputDialog("write your login");
		Client client = new Client(a);
	}
	public Client(final String name) throws IOException, HeadlessException,
			ClassNotFoundException {
		super(name);
		setLayout(new FlowLayout());
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		final JTextField t1 = new JTextField(10);
		final JButton b1 = new JButton("Send");
		add(t1);
		add(b1);
		setVisible(true);
			InetAddress ipAddress = InetAddress.getByName("77.123.57.3");
			Socket socket = new Socket(ipAddress, 2121);
			final DataOutputStream dOut = new DataOutputStream(
					socket.getOutputStream());
			b1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if (arg0.getSource() == b1)
						try {
							dOut.writeUTF(name + ": " + t1.getText());
							t1.setText("");
						} catch (IOException e) {
							e.printStackTrace();
						}
				}
			});
			while (true) {
			try{
			DataInputStream dIn = new DataInputStream(socket.getInputStream());
			String Data = dIn.readUTF();	
			JOptionPane.showMessageDialog(null, "client " + Data);
			System.out.println(Data);
			}catch(Exception e){
				System.out.println(e);
			}
		}
	}

}