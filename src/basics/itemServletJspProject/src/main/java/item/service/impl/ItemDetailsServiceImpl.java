package item.service.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

import javax.sql.DataSource;

import item.model.Item;
import item.model.ItemDetails;
import item.service.ItemDetailsService;

public class ItemDetailsServiceImpl implements ItemDetailsService{
	private DataSource dataSource;
	Connection connection = null;
	Statement statement = null;
	
	public ItemDetailsServiceImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public Boolean removeItemDetails(Long id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = dataSource.getConnection();
			;
			String query = "DELETE FROM ITEM_DETAILS WHERE id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, id);

			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(connection, preparedStatement, null);
		}
		return false;
	}

	@Override
	public Boolean createItemDetails(ItemDetails details) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource.getConnection();
			String query = "INSERT INTO ITEM_DETAILS  (ID, DESCRIPTION, ISSUE_DATE, EXPIRY_DATE) VALUES (?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, details.getId());
			preparedStatement.setString(2, details.getDescription());
			preparedStatement.setDate(3, details.getIssueDate());
			preparedStatement.setDate(4, details.getExpiryDate());
			preparedStatement.executeUpdate();
			return true;

		} catch (Exception e) {
			System.out.println("ex => " + e.getMessage());
		} finally {
			close(connection, preparedStatement, null);
		}
		return false;
	}
	
	
	private void close(Connection connection,
			   PreparedStatement preparedStatement,
			   ResultSet resultSet) {
try {
	if (Objects.nonNull(resultSet)) resultSet.close();
	if (Objects.nonNull(preparedStatement)) preparedStatement.close();
	if (Objects.nonNull(connection)) connection.close();
} catch (SQLException e) {
	System.out.println("ex => " + e.getMessage());
}
}

}
