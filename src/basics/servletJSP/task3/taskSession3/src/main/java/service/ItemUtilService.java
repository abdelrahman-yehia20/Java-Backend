package service;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import model.Item;

public class ItemUtilService {
	
	private DataSource dataSource;
	private PrintWriter printWriter;

    public ItemUtilService(DataSource dataSource, PrintWriter printWriter) {
        this.dataSource = dataSource;
        this.printWriter = printWriter;
    }
    
	
	public List<Item> getItemById(){        
        Connection connection;
        List<Item> items = null;
		try {
			connection = dataSource.getConnection();
			Statement statement = connection.createStatement();

			String query = "SELECT * FROM Item WHERE ID IN (1,2)";
			ResultSet resultSet = statement.executeQuery(query);
			 items = extratItem(resultSet, printWriter);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return items;
		
	}
	
	
	public List<Item> getItemByNameContainI(){
		 Connection connection;
	        List<Item> items = null;
			try {
				connection = dataSource.getConnection();
				Statement statement = connection.createStatement();
				String query = "SELECT * FROM Item WHERE NAME LIKE '%i%'";
				ResultSet resultSet = statement.executeQuery(query);
				 items = extratItem(resultSet, printWriter);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return items;
	}
	
	public List<Item> getPriceBetweenTwentyAndFifty(){
		 Connection connection;
	        List<Item> items = null;
			try {
				connection = dataSource.getConnection();
				Statement statement = connection.createStatement();
				String query = "SELECT * FROM Item WHERE PRICE > 20 AND PRICE < 50";
				ResultSet resultSet = statement.executeQuery(query);
				 items = extratItem(resultSet, printWriter);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return items;
	}
	
	public void saveItems(){
		 Connection connection;
			try {
				connection = dataSource.getConnection();
				Statement statement = connection.createStatement();
				String query = 	"INSERT INTO Item (ID, NAME, PRICE, TOTAL_NUMBER) VALUES (7, 'Apple', 30, 100)";
				ResultSet resultSet = statement.executeQuery(query);				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	
	
	private List<Item> extratItem(ResultSet resultSet,PrintWriter printWriter ){
		List<Item> items = new ArrayList();
		try {
			while(resultSet.next()) {
				Item item = new Item();
		
				item.setId(resultSet.getInt("ID"));
				item.setName(resultSet.getString("NAME"));
				item.setPrice(resultSet.getInt("PRICE"));
				item.setTotalNumber(resultSet.getDouble("TOTAL_NUMBER"));
				
				items.add(item);
			}
		}catch (SQLException e) {
				// TODO Auto-generated catch block
				printWriter.append("<h1> "+ e.getMessage() +" </h1>");
			}
			return items;
			
		}
	
	
	


}
