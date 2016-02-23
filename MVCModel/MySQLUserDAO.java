package MVCModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class MySQLUserDAO implements UserDAO {
	/* (non-Javadoc)
	 * @see MVCModel.PersonDAO#addUser(MVCModel.User)
	 */
	@Override
	public int addUser(User user) throws SQLException {
		Connection connection = Database.getInstance().getConnection();

		PreparedStatement statement = (PreparedStatement) connection
				.prepareStatement("insert into mydb.user(name , password) values (?,?)");

		statement.setString(1, user.getName());
		statement.setString(2, user.getPassword());

		int upadeted = statement.executeUpdate();

		statement.close();

		return upadeted;
	}

	/* (non-Javadoc)
	 * @see MVCModel.PersonDAO#getUser(int)
	 */
	@Override
	public User getUser(int id) throws SQLException {
		Connection conn = Database.getInstance().getConnection();

		String sql = "select idUser, name, password from mydb.user where idUser=? order by idUser";
		PreparedStatement selectStatement = (PreparedStatement) conn
				.prepareStatement(sql);

		selectStatement.setInt(1, id);

		ResultSet results = selectStatement.executeQuery();

		User user = null;

		if (results.next()) {
			String name = results.getString("name");
			String password = results.getString("password");

			user = new User(id, name, password);
		}

		results.close();
		selectStatement.close();

		return user;
	}

	/* (non-Javadoc)
	 * @see MVCModel.PersonDAO#getUsers()
	 */
	@Override
	public List<User> getUsers() throws SQLException {

		List<User> users = new ArrayList<User>();

		Connection conn = Database.getInstance().getConnection();

		String sql = "select idUser, name, password from mydb.user order by idUser";
		Statement selectStatement = (Statement) conn.createStatement();

		ResultSet results = selectStatement.executeQuery(sql);

		while (results.next()) {
			int id = results.getInt("idUser");
			String name = results.getString("name");
			String password = results.getString("password");

			User user = new User(id, name, password);
			users.add(user);
		}

		results.close();
		selectStatement.close();

		return users;
	}

	/* (non-Javadoc)
	 * @see MVCModel.PersonDAO#updatePerson(MVCModel.User)
	 */
	@Override
	public int updatePerson(User user) throws SQLException {
		Connection conn = Database.getInstance().getConnection();

		PreparedStatement p = (PreparedStatement) conn
				.prepareStatement("update mydb.user set name=?, password=? where idUser=?");

		p.setString(1, user.getName());
		p.setString(2, user.getPassword());
		p.setInt(3, user.getId());

		int updated = p.executeUpdate();

		p.close();

		return updated;
	}

	/* (non-Javadoc)
	 * @see MVCModel.PersonDAO#deletePerson(int)
	 */
	@Override
	public int deletePerson(int id) throws SQLException {
		Connection conn = Database.getInstance().getConnection();

		PreparedStatement p = (PreparedStatement) conn
				.prepareStatement("delete from mydb.user where idUser=?");

		p.setInt(1, id);

		int deleted = p.executeUpdate();

		p.close();

		return deleted;
	}

	/* (non-Javadoc)
	 * @see MVCModel.PersonDAO#deleteAll()
	 */
	@Override
	public int deleteAll() throws SQLException {
		Connection conn = Database.getInstance().getConnection();

		PreparedStatement p = (PreparedStatement) conn
				.prepareStatement("delete from mydb.user");

		int deleted = p.executeUpdate();

		p.close();

		return deleted;
	}
}
