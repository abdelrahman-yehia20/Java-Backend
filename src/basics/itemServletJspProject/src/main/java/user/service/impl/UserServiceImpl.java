package user.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import user.model.User;
import user.service.UserService;

public class UserServiceImpl implements UserService{
	
	private DataSource dataSource;
	Connection connection = null;
	Statement statement = null;
	
	
	public UserServiceImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public boolean createUser(User user) {
		try {
			connection = dataSource.getConnection();
			if(getUserByEmail(user.getEmail()) != null) {
				return false;
			}
			String query = "INSERT INTO USERS (NAME, EMAIL, PASSWORD) VALUES (?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				return false;
	}

	@Override
	public User login(String email, String password) {
		try {
			connection = dataSource.getConnection();
			String query = "SELECT * FROM USERS WHERE EMAIL = ? AND PASSWORD = ?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet resultSet = ps.executeQuery();
			if(resultSet.next()) {
				return new User(resultSet.getLong("ID"),
								resultSet.getString("NAME"),
								resultSet.getString("EMAIL"),
								resultSet.getString("PASSWORD")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User getUserByEmail(String email) {
		try {
			connection = dataSource.getConnection();
			String query = "SELECT * FROM USERS WHERE EMAIL = ?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, email);
			ResultSet resultSet = ps.executeQuery();
			if(resultSet.next()) {
				return new User(resultSet.getLong("ID"),
								resultSet.getString("NAME"),
								resultSet.getString("EMAIL"),
								resultSet.getString("PASSWORD")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
