package item.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.sql.DataSource;

import item.model.Item;
import item.model.ItemDetails;
import item.service.ItemService;

public class ItemServiceImpl implements ItemService {
	
	private DataSource dataSource;
	Connection connection = null;
	Statement statement = null;
	
	public ItemServiceImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<Item> getItems() {
		List<Item> items = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();

			String query =  "SELECT i.ID, i.NAME, i.PRICE, i.TOTAL_NUMBER, " +
				    	    "d.DESCRIPTION, d.ISSUE_DATE, d.EXPIRY_DATE " +
				    	    "FROM ITEM i " +
				    	    "LEFT JOIN ITEM_DETAILS d ON i.ID = d.ID " +
				    	    "WHERE i.DELETED = 0 " +
				    	    "ORDER BY i.ID DESC";

			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Item item = new Item(
						resultSet.getLong("ID"),
						resultSet.getString("NAME"),
						resultSet.getDouble("PRICE"),
						resultSet.getInt("TOTAL_NUMBER")
				);
				if(resultSet.getString("DESCRIPTION") != null) {
					 ItemDetails details = new ItemDetails(
						        item.getId(),
						        resultSet.getString("DESCRIPTION"),
						        resultSet.getDate("ISSUE_DATE"),
						        resultSet.getDate("EXPIRY_DATE")
						        );
					 item.setItemDetails(details);
				}
				items.add(item);
			}
			return items;

		} catch (Exception e) {
			System.out.println("ex => " + e.getMessage());
		} finally {
			close(connection, preparedStatement, resultSet);
		}
		return items	;
	}

	@Override
	public Item getItem(Long id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();

			String query = "SELECT * FROM ITEM WHERE ID = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, id);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				return new Item(
						resultSet.getLong("ID"),
						resultSet.getString("NAME"),
						resultSet.getDouble("PRICE"),
						resultSet.getInt("TOTAL_NUMBER")
				);
			}

		} catch (Exception e) {
			System.out.println("ex => " + e.getMessage());
		} finally {
			close(connection, preparedStatement, resultSet);
		}
		return null;
		
	}

	@Override
	public Boolean createItem(Item item) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource.getConnection();
			String query ="INSERT INTO HR.ITEM (NAME, PRICE, TOTAL_NUMBER) VALUES (?, ?, ?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, item.getName());
			preparedStatement.setDouble(2, item.getPrice());
			preparedStatement.setInt(3, item.getTotalNumber());

			preparedStatement.executeUpdate();
			return true;

		} catch (Exception e) {
			System.out.println("ex => " + e.getMessage());
		} finally {
			close(connection, preparedStatement, null);
		}
		return false;
	}

	@Override
	public Boolean updateItem(Item item) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource.getConnection();

			String query =
					"UPDATE ITEM SET NAME = ?, PRICE = ?, TOTAL_NUMBER = ? WHERE ID = ?";

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, item.getName());
			preparedStatement.setDouble(2, item.getPrice());
			preparedStatement.setInt(3, item.getTotalNumber());
			preparedStatement.setLong(4, item.getId());

			preparedStatement.executeUpdate();
			return true;

		} catch (Exception e) {
			System.out.println("ex => " + e.getMessage());
		} finally {
			close(connection, preparedStatement, null);
		}
		return false;
	}

	@Override
	public Boolean removeItem(Long id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource.getConnection();

			String query = "UPDATE ITEM SET DELETED = 1 WHERE id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, id);

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

	@Override
	public Item getItemByName(String name) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = dataSource.getConnection();
			String query = "SELECT * FROM ITEM WHERE NAME = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
	            return new Item(
	            		resultSet.getLong("id"),
	            		resultSet.getString("name"),
	            		resultSet.getDouble("price"),
	            		resultSet.getInt("TOTAL_NUMBER")
	            );
			}
		}catch(SQLException e) {
	        System.out.println("ex => " + e.getMessage());
		}
		return null;
	}

}
