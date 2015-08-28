import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;


public class Client extends JFrame {
public static void main(String []args){
	Client client = new Client("Main form");
}
public Client(String name){
	super(name);
	setLayout(new FlowLayout());
	setSize(300, 300);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	final JButton ButtCreate = new JButton("Create");
	final JButton ButtOpen = new JButton("Open");
	add(ButtCreate);
	add(ButtOpen);
	setVisible(true);
	ButtCreate.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
if(e.getSource()==ButtCreate){
	try {
		Calculation create=new Calculation();
	} catch (ParseException e1) {
		e1.printStackTrace();
	}
}
		}

	});
}
}
