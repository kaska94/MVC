package MVCModel;

public class OracleDAOFactory extends DAOFactory {

	@Override
	public UserDAO getUserDAO() {
		return new OracleUserDAO();
	}

}
