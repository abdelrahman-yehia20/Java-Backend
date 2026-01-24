package item.controller;

import java.io.IOException;
import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import item.service.ItemService;
import item.service.impl.ItemServiceImpl;

/**
 * Servlet implementation class ItemController
 */
@WebServlet("/ItemController")
public class ItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name="jdbc/connection")
	private DataSource dataSource;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String action = request.getParameter("action");
	if(Objects.isNull(action)) {
		action = "show-items";
	}
	
	switch(action) {
	 		case "add-item":
	 					addItem(request, response);
		        break;
		        
			case "remove-item":
						removeItem(request, response);
				break;
			case "delete-item":
				removeItem(request, response);
				break;
			case "update-item":
						updateItem(request, response);
			    break;
			case "show-item":
						showItem(request, response);	
			        break;
			        
			case "show-items":
						showItems(request, response);
		        break;
		        
		    default:
		    	showItems(request, response);
	}
}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void showItems(HttpServletRequest request, HttpServletResponse response) {
		try {
			ItemService itemService = new ItemServiceImpl(dataSource);
			
			// TODO id, 
			// get all items -- service and service impl to get list of items
			// go to show items page List<item> and show items
			response.getWriter().append("<h1>showItems</h1>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private void showItem(HttpServletRequest request, HttpServletResponse response) {
		try {
			// TODO id, 
			// get item by id -- service and service impl to get item 
			// go to show item page and show item
			response.getWriter().append("<h1>showItem</h1>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}


	private void updateItem(HttpServletRequest request, HttpServletResponse response) {
		try {
			// TODO id, name price totalNumber
			// update item DB success updated -- service and service impl to updated item 
			// go to main page and show all items
			response.getWriter().append("<h1>updateItem</h1>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}


	private void removeItem(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.getWriter().append("<h1>removeItem</h1>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}


	private void addItem(HttpServletRequest request, HttpServletResponse response) {
		try {
			// TODO name price totalNumber
			// save DB success saved -- service and service impl to save item 
			// go to main page and show all items 
			response.getWriter().append("<h1>addItem</h1>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}


	

}
