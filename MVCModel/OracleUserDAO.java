package MVCModel;

import java.sql.SQLException;
import java.util.List;

public class OracleUserDAO implements UserDAO{

	@Override
	public int addUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User getUser(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUsers() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updatePerson(User user) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deletePerson(int id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAll() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
