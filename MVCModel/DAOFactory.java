package MVCModel;

public abstract class DAOFactory {

	public static final int MYSQL = 0;
	public static final int Oracle = 1;

	public abstract UserDAO getUserDAO();

	public static DAOFactory DAOtype(int type) {
		switch (type) {
		case MYSQL:
			return new MySQLDAOFactory();
		case Oracle:
			return new OracleDAOFactory();
		default:
			return null;
		}
	}
}