import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Main extends JFrame{
public static void main(String[]args){
	Main main=new Main("QR");
}
public Main(String name){
	super(name);
	setLayout(new FlowLayout());
	setSize(300,300);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	final JTextField t1=new JTextField(10);
	final JButton b1=new JButton("Send");
	add(b1);
	add(t1);
	setVisible(true);
	
	b1.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(arg0.getSource()==b1)
				remove(t1.getText());
			}

		public String remove(String s) {
		       String r = "";
		       for (int i = 0; i < s.length(); i ++) {
		          if (Character .isDigit(s.charAt(i))||s.charAt(i)== ' '||s.charAt(i)== '-'||s.charAt(i)== '+'||s.charAt(i)== '.'||s.charAt(i)== ',') {
		        	  r += s.charAt(i);   	  
		       }  
		}
		       t1.setText(r);
		       return r;
		}
	});
}
}
