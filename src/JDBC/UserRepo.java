package JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import entities.User;

public class UserRepo {

	public static List<User> getAllUsers() {
		Connection connection = ConnectionFactory.getConnection();
		String query = "select * from user";
		List<User> users=new ArrayList<User>();
		try {
			Statement statement = connection.createStatement();
			ResultSet res = statement.executeQuery(query);
			while(res.next()) {
				User user=new User();
				user.setUserid(res.getInt("userid"));
				user.setName(res.getString("name"));
				user.setSurname(res.getString("surname"));
				user.setEmail(res.getString("email"));
				user.setPassword(res.getString("password"));
				user.setAdmin(res.getByte("admin"));
				users.add(user);
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return users;
	}
}
