package Exercise;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import MVCModel.Model;

public class Subject extends JFrame implements ActionListener {

	private Model model;
	private JButton okButton;
	private JTextField userField;
	private JPasswordField password;
	private JLabel userLabel;
	private JLabel passwordLabel;
	public SomeListner listener;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				runApp();

			}
		});
	}

	public static void runApp() {
		Subject subj = new Subject(); // View + model in the constructor
		Observer obs = new Observer(); // controler
		subj.setListner(obs);
	}

	public Subject() {
		super("Test MCV");
		this.model = model;

		okButton = new JButton("Hello!");
		userField = new JTextField(10);
		password = new JPasswordField(10);
		userLabel = new JLabel("Username: ");
		passwordLabel = new JLabel("Password");

		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();

		gc.anchor = GridBagConstraints.LAST_LINE_START;
		gc.gridx = 1;
		gc.gridy = 1;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;

		add(userLabel);

		gc.anchor = GridBagConstraints.LAST_LINE_END;
		gc.gridx = 2;
		gc.gridy = 1;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;

		add(userField);

		gc.anchor = GridBagConstraints.LINE_START;
		gc.gridx = 1;
		gc.gridy = 2;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;

		add(passwordLabel);

		gc.anchor = GridBagConstraints.LINE_START;
		gc.gridx = 2;
		gc.gridy = 2;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;

		add(password);

		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.gridx = 2;
		gc.gridy = 3;
		gc.weightx = 1;
		gc.weighty = 10000;
		gc.fill = GridBagConstraints.NONE;

		add(okButton);

		okButton.addActionListener(this);
		setSize(600, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void setListner(SomeListner listner) {	
		this.listener = listner; 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (listener != null) {
			System.out.println("here");
			listener.someEventPerformed();
		}

	}
}
