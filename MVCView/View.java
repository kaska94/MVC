package MVCView;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import MVCModel.Database;
import MVCModel.Model;

public class View extends JFrame implements ActionListener {
	private Model model;
	private JButton okButton;
	private JTextField userField;
	private JPasswordField passwordUser;
	private JPasswordField passwordConform;
	private JLabel userLabel;
	private JLabel passwordLabel;
	private JLabel conformLabel;

	private LoginListener listener;

	public View(Model model) {
		super("Test MCV");
		this.model = model;

		okButton = new JButton("Hello!");
		userField = new JTextField(10);
		passwordUser = new JPasswordField(10);
		passwordConform = new JPasswordField(10);
		userLabel = new JLabel("Username: ");
		passwordLabel = new JLabel("Password:");
		conformLabel = new JLabel("ConfirmPassword");
		
		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();
		
		gc.anchor = GridBagConstraints.LAST_LINE_END;
		gc.weightx = 1;
		gc.weighty = 1;
		
		gc.gridx = 1;
		gc.gridy = 1;
		gc.fill = GridBagConstraints.NONE;
		gc.insets = new Insets(100, 0, 0, 10);
		add(userLabel, gc);
		
		gc.anchor = GridBagConstraints.LAST_LINE_START;
		gc.gridx = 2;
		gc.gridy = 1;
		gc.insets = new Insets(100, 0, 0, 0);
		add(userField, gc);
		
		gc.anchor = GridBagConstraints.LINE_END;
		gc.gridx = 1;
		gc.gridy = 2;
		gc.insets = new Insets(0, 0, 0, 10);
		add(passwordLabel, gc);
		
		gc.anchor = GridBagConstraints.LINE_START;
		gc.gridx = 2;
		gc.gridy = 2;
		gc.insets = new Insets(0, 0, 0, 0);
		add(passwordUser, gc);
		
		gc.anchor = GridBagConstraints.LINE_END;
		gc.gridx = 1;
		gc.gridy = 3;
		gc.insets = new Insets(0, 0, 0, 10);
		add(conformLabel, gc);
		
		gc.anchor = GridBagConstraints.LINE_START;
		gc.gridx = 2;
		gc.gridy = 3;
		gc.insets = new Insets(0, 0, 0, 0);
		add(passwordConform, gc);
		
		
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.gridx = 2;
		gc.gridy = 4;
		gc.weightx = 1;
		gc.weighty = 100;
		gc.fill = GridBagConstraints.NONE;
		
		add(okButton, gc);
		
		okButton.addActionListener(this);

		setSize(600, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				Database.getInstance().conned();
				System.out.println("Connected!");
			}

			public void windowClosing(WindowEvent e) {
				Database.getInstance().disconect();
				System.out.println("Disconnected!");
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String password = new String(passwordUser.getPassword());
		String repeat = new String(passwordConform.getPassword());

		if (password.equals(repeat)) {
			String name = userField.getText();

			fireLoginEvent(new LoginFormEvent(name, password));
		} else {
			JOptionPane.showMessageDialog(this, "Passwords do not match.",
					"Error", JOptionPane.WARNING_MESSAGE);
		}
	}

	public void setLoginListener(LoginListener listener) {
		this.listener = listener;

	}

	public void fireLoginEvent(LoginFormEvent e) {
		if (listener != null) {
			listener.loginPerformed(e);
		}
	}
}
