import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Calculation extends JFrame {
	static String name;
	static int typeKV = 17;
	static int typeDim = 15;
	static int typeKim = 13;
	static int koefUpTo2000 = 13;
	static int koefFrom2000To2014 = 16;
	static int koefAfter2014 = 20;
	static int areaTo50 = 12;
	static int areaFrom50To100 = 15;
	static int areaMoreThan100 = 20;

	public Calculation() throws ParseException {
		super();
		setLayout(new FlowLayout());
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		JLabel StrahVnesok = new JLabel(" Страховий внесок         ");
		final JTextField textFieldStrahVnesok = new JTextField(10);

		final JLabel Type = new JLabel(" Тип нерухомості                   ");
		final JComboBox type = new JComboBox();
		type.addItem("квартира");
		type.addItem("дім");
		type.addItem("кімната");

		JLabel year = new JLabel(" Рік створення                ");
		final JTextField textFieldYear = new JTextField(10);

		JLabel area = new JLabel(" Площа                            ");
		final JTextField textFieldArea = new JTextField(10);

		JLabel termStart = new JLabel(" Срок дії з                        ");
		final JTextField textFieldTermStart = new JTextField(10);

		textFieldTermStart.setText("дд.мм.рррр");
		JLabel termEnd = new JLabel(" до                                    ");
		final JTextField textFieldTermEnd = new JTextField(10);

		textFieldTermEnd.setText("дд.мм.рррр");
		JLabel Date = new JLabel(" Дата укладання            ");
		final JTextField TFDate = new JTextField(10);

		JLabel reward = new JLabel(" Премія                             ");
		final JTextField TFReward = new JTextField(10);

		add(StrahVnesok);
		add(textFieldStrahVnesok);
		add(Type);
		add(type);
		add(year);
		add(textFieldYear);
		add(area);
		add(textFieldArea);
		add(termStart);
		add(textFieldTermStart);
		add(termEnd);
		add(textFieldTermEnd);
		add(Date);
		add(TFDate);
		add(reward);
		add(TFReward);

		final JButton raschot = new JButton("Розрахувати");
		add(raschot);
		setVisible(true);

		raschot.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == raschot) {
					Data.StrahVnesok = textFieldStrahVnesok.getText();
					Data.Area = textFieldArea.getText();
					Data.DateContr = TFDate.getText();
					Data.Reward = TFReward.getText();
					Data.TermStart = textFieldTermStart.getText();
					Data.TermEnd = textFieldTermEnd.getText();
					Data.Type = (String) type.getSelectedItem();
					Data.Year = textFieldYear.getText();

					name = JOptionPane.showInputDialog("ФІБ");
					Insured insuredwindow = new Insured();
				}
			}

		});
	}

}
