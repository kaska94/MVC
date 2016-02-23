package MCVControler;

import java.sql.SQLException;

import MVCModel.DAOFactory;
import MVCModel.MySQLDAOFactory;
import MVCModel.Model;
import MVCModel.UserDAO;
import MVCModel.User;
import MVCView.LoginFormEvent;
import MVCView.LoginListener;
import MVCView.View;

public class Controller implements LoginListener {
	private Model model;
	private View view;
	

	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}

	@Override
	public void loginPerformed(LoginFormEvent e) {
		System.out.println(e.getName() + "  : " + e.getPassword());
		DAOFactory factory = DAOFactory.DAOtype(DAOFactory.MYSQL);
		UserDAO userDAO = factory.getUserDAO();
		try {
			userDAO.addUser(new User(e.getName(), e.getPassword()));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
