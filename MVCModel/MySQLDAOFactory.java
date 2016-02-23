package MVCModel;

public class MySQLDAOFactory extends DAOFactory {
	/* (non-Javadoc)
	 * @see MVCModel.DAOFactory#getUserDAO()
	 */
	@Override
	public UserDAO getUserDAO() {
		return new MySQLUserDAO();
	}
}
