package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import model.Item;
import service.ItemUtilService;


@WebServlet("/ItemServlet")
public class ItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(name="jdbc/connection")
	private DataSource dataSource;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter printWriter = response.getWriter();
		
		// task1
			ItemUtilService service = new ItemUtilService(dataSource, printWriter);
			List<Item> items = service.getItemById();
		printWriter.append("<h1> Items count: " + items.size() + " </h1>");
		
		
		// task2
		items = service.getItemByNameContainI();
		printItemsTable(printWriter, items);		
		
		
		//task3
		items = service.getPriceBetweenTwentyAndFifty();
		printItemsTable(printWriter, items);		

		//task4
		 service.saveItems();
        printWriter.append("<h2> added sucessfully </h2>");

		
		//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	private void printItemsTable(PrintWriter printWriter, List<Item> items) {

	    printWriter.append("<table border='1'>");

	    // table header
	    printWriter.append("<tr>");
	    printWriter.append("<th>ID</th>");
	    printWriter.append("<th>Name</th>");
	    printWriter.append("<th>Price</th>");
	    printWriter.append("<th>Total Number</th>");
	    printWriter.append("</tr>");

	    // table rows
	    for (Item item : items) {
	        printWriter.append("<tr>");
	        printWriter.append("<td>" + item.getId() + "</td>");
	        printWriter.append("<td>" + item.getName() + "</td>");
	        printWriter.append("<td>" + item.getPrice() + "</td>");
	        printWriter.append("<td>" + item.getTotalNumber() + "</td>");
	        printWriter.append("</tr>");
	    }

	    printWriter.append("</table>");
	}

	
	
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
		
		
}
