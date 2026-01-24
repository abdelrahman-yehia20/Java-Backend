package item.service.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.sql.DataSource;

import item.model.Item;
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
		
		
		try {
			connection = dataSource.getConnection();  
			statement = connection.createStatement(); 
			
			String query = "SELECT * FROM item order by id";
			ResultSet resultSet = statement.executeQuery(query);
			
			List<Item> items = new ArrayList<Item>();
			while (resultSet.next()) {
				Item item = new Item(
						resultSet.getLong("id"),
						resultSet.getString("name"),
						resultSet.getDouble("price"),
						resultSet.getInt("TOTAL_NUMBER")
				);
				items.add(item);
			}
			
			return items;
		} catch (Exception exception) {
			System.out.println("ex => " + exception.getMessage());
		} finally {
			try {
				if(Objects.nonNull(connection)) {
					connection.close();
				}
				
				if(Objects.nonNull(statement)) {
					statement.close();
				}
			} catch (SQLException exception) {
				System.out.println("ex => " + exception.getMessage());
			}
		}
		
		return null;
	}

	@Override
	public Item getItem(Long id) {
		try {
			connection = dataSource.getConnection();  // connection open
			statement = connection.createStatement(); // statement open
			String query = "SELECT * FROM item WHERE id =" + id;
			ResultSet resultSet = statement.executeQuery(query);
			
			resultSet.next();
				return new Item(
						resultSet.getLong("id"),
						resultSet.getString("name"),
						resultSet.getDouble("price"),
						resultSet.getInt("TOTAL_NUMBER")
				);
			
		} catch (Exception exception) {
			System.out.println("ex => " + exception.getMessage());
		} finally {
			try {
				if(Objects.nonNull(connection)) {
					connection.close();
				}
				
				if(Objects.nonNull(statement)) {
					statement.close();
				}
			} catch (SQLException exception) {
				System.out.println("ex => " + exception.getMessage());
			}
		}
		return null;
		
	}

	@Override
	public Boolean createItem(Item item) {
		Connection connection = null;
		Statement statement = null;
		
		try {
			connection = dataSource.getConnection();  // connection open
			statement = connection.createStatement(); // statement open
			String query = "INSERT INTO HR.ITEM (NAME, PRICE, TOTAL_NUMBER) VALUES('"+item.getName()+"', "+item.getPrice() +", "+item.getTotalNumber()+")";
			ResultSet resultSet = statement.executeQuery(query);
			
			resultSet.next();
				return true;
			
		} catch (Exception exception) {
			System.out.println("ex => " + exception.getMessage());
		} finally {
			try {
				if(Objects.nonNull(connection)) {
					connection.close();
				}
				
				if(Objects.nonNull(statement)) {
					statement.close();
				}
			} catch (SQLException exception) {
				System.out.println("ex => " + exception.getMessage());
			}	
		}
		
		return false;
	}

	@Override
	public Boolean updateItem(Item item) {
		try {
			connection = dataSource.getConnection();  // connection open
			statement = connection.createStatement(); // statement open
			String query = "UPDATE ITEM SET ID="+item.getId()+", NAME='"+item.getName()+"', PRICE="+item.getPrice()+", TOTAL_NUMBER="+item.getTotalNumber()+" WHERE id="+item.getId();
			ResultSet resultSet = statement.executeQuery(query);
			
			resultSet.next();
				return true;
			
		} catch (Exception exception) {
			System.out.println("ex => " + exception.getMessage());
		} finally {
			try {
				if(Objects.nonNull(connection)) {
					connection.close();
				}
				
				if(Objects.nonNull(statement)) {
					statement.close();
				}
			} catch (SQLException exception) {
				System.out.println("ex => " + exception.getMessage());
			}	
		}
		
		return false;
	}

	@Override
	public Boolean removeItem(Long id) {
		try {
			connection = dataSource.getConnection();  // connection open
			statement = connection.createStatement(); // statement open
			String query = "DELETE FROM ITEM WHERE id = " + id;
			ResultSet resultSet = statement.executeQuery(query);
			
			resultSet.next();
				return true;
			
		} catch (Exception exception) {
			System.out.println("ex => " + exception.getMessage());
		} finally {
			try {
				if(Objects.nonNull(connection)) {
					connection.close();
				}
				
				if(Objects.nonNull(statement)) {
					statement.close();
				}
			} catch (SQLException exception) {
				System.out.println("ex => " + exception.getMessage());
			}	
		}
		
		return false;
	}

}
