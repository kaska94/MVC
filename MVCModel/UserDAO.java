package MVCModel;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {

	public abstract int addUser(User user) throws SQLException;

	public abstract User getUser(int id) throws SQLException;

	public abstract List<User> getUsers() throws SQLException;

	public abstract int updatePerson(User user) throws SQLException;

	public abstract int deletePerson(int id) throws SQLException;

	public abstract int deleteAll() throws SQLException;

}