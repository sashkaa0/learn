import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Insured extends JFrame {

	public Insured() {
		setLayout(new FlowLayout());
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		final JLabel numb = new JLabel("№ договору                    ");
		final JTextField textFieldNumb = new JTextField(10);

		final JLabel FIB = new JLabel("ФІБ                                   ");
		final JTextField textFieldFIB = new JTextField(10);
		textFieldFIB.setText(Calculation.name);

		final JLabel DateBirthd = new JLabel("Дата народження         ");
		final JTextField textFieldDateBirth = new JTextField(10);

		final JLabel IDPassport = new JLabel("Серія паспорту               ");
		final JTextField textFieldIDPassport = new JTextField(10);

		final JLabel numbPassport = new JLabel("Номер паспорту             ");
		final JTextField textFieldNumbPassport = new JTextField(10);

		final JLabel Address = new JLabel("Адрес обєкта                  ");
		final JTextField textFieldAddress = new JTextField(10);

		final JButton Save = new JButton("Зберегти");
		JButton Cancel = new JButton("Основний список");
		add(FIB);
		add(textFieldFIB);
		add(numb);
		add(textFieldNumb);
		add(DateBirthd);
		add(textFieldDateBirth);
		add(IDPassport);
		add(textFieldIDPassport);
		add(numbPassport);
		add(textFieldNumbPassport);
		add(Address);
		add(textFieldAddress);
		add(Save);
		add(Cancel);
		
		setVisible(true);
		Save.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==Save){
				Data.FIB=textFieldFIB.getText();
				Data.Numb=textFieldNumb.getText();
				Data.SerPass=textFieldIDPassport.getText();
				Data.Address=textFieldAddress.getText();
				Data.DateBirthd=textFieldDateBirth.getText();
				Data.NumbPass=textFieldNumbPassport.getText();
				try {
						Data.Send();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				}
				
			}
			
		});
	}

}
