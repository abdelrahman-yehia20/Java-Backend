package item.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import item.model.ItemDetails;
import item.service.ItemDetailsService;
import item.service.impl.ItemDetailsServiceImpl;
import oracle.jdbc.driver.parser.Parseable;

@WebServlet("/ItemDetailsController")
public class ItemDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/connection")
	private DataSource dataSource;
	
	private ItemDetailsService getItemDetailedService() {
		return new ItemDetailsServiceImpl(dataSource);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
//		if(Objects.isNull()) {
//			
//		}
		
		switch(action) {
		case"delete":
			deleteItemDetails(request, response);
			break;
			
		case"add-form":
			request.getRequestDispatcher("/item/add-item-details.jsp").forward(request, response);
			break;
			
		case"add":
			addItemDetails(request, response);
			break;
		}
		
		
		
		
	}

	
	private void addItemDetails(HttpServletRequest request, HttpServletResponse response) {
		try {
			ItemDetailsService service = getItemDetailedService();
			Long id = Long.parseLong(request.getParameter("id"));
			String description = request.getParameter("description");
			Date issueDate = Date.valueOf(request.getParameter("issueDate"));
	        Date expiryDate = Date.valueOf(request.getParameter("expiryDate"));
	        ItemDetails itemDetails = new ItemDetails(id, description, issueDate, expiryDate);
			boolean created = service.createItemDetails(itemDetails);
			if(created) {
				 response.sendRedirect(request.getContextPath() + "/ItemController?action=show-items&success=added");
			}
		}catch(Exception e) {
	        e.getMessage();

		}
	}


	private void deleteItemDetails(HttpServletRequest request, HttpServletResponse response) {
		try {
			ItemDetailsService itemDetailesService = getItemDetailedService();
			Long id = Long.parseLong(request.getParameter("id"));
			boolean isItemDetailsRemoved = itemDetailesService.removeItemDetails(id);
			if(isItemDetailsRemoved) {
				response.sendRedirect(request.getContextPath() + "/ItemController?action=show-items&success=removed");
			}
		}catch(Exception e) {
			System.out.println("ex => " + e.getMessage());
			
		}
		// TODO Auto-generated method stub
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
