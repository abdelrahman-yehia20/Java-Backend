package item.controller;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import item.model.Item;
import item.service.ItemService;
import item.service.impl.ItemServiceImpl;

@WebServlet("/ItemController")
public class ItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/connection")
	private DataSource dataSource;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		if (Objects.isNull(action)) {
			action = "show-items";
		}

		switch (action) {
			case "add-item":
				addItem(request, response);
				break;

			case "remove-item":
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
			default:
				showItems(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	/* ===================== Helper Methods ===================== */

	private ItemService getItemService() {
		return new ItemServiceImpl(dataSource);
	}

	private Item buildItemFromRequest(HttpServletRequest request) {
		String name = request.getParameter("name");
		Double price = Double.parseDouble(request.getParameter("price"));
		Integer totalNumber = Integer.parseInt(request.getParameter("totalNumber"));

		String idParam = request.getParameter("id");
		if (idParam != null && !idParam.isEmpty()) {
			Long id = Long.parseLong(idParam);
			return new Item(id, name, price, totalNumber);
		}

		return new Item(name, price, totalNumber);
	}

	/* ===================== Actions ===================== */

	private void showItems(HttpServletRequest request, HttpServletResponse response) {
		try {
			ItemService itemService = getItemService();
			List<Item> items = itemService.getItems();

			request.setAttribute("allItems", items);
			request.getRequestDispatcher("/item/show-items.jsp").forward(request, response);

		} catch (Exception e) {
			System.out.println("ex => " + e.getMessage());
		}
	}

	private void showItem(HttpServletRequest request, HttpServletResponse response) {
		try {
			ItemService itemService = getItemService();
			long id = Long.parseLong(request.getParameter("id"));

			Item item = itemService.getItem(id);
			request.setAttribute("item", item);
			request.getRequestDispatcher("/item/update-item.jsp").forward(request, response);

		} catch (Exception e) {
			System.out.println("ex => " + e.getMessage());
		}
	}

	private void addItem(HttpServletRequest request, HttpServletResponse response) {
		try {
			
			
			ItemService itemService = getItemService();
			Item item = buildItemFromRequest(request);
			if(Objects.nonNull(itemService.getItemByName(item.getName()))) {
				 response.sendRedirect(
			                request.getContextPath() + "/ItemController?action=show-items&success=nameExist"
			            );
				 return;
			}

			boolean isItemCreated = itemService.createItem(item);
			if (isItemCreated) {
	            response.sendRedirect(
	                request.getContextPath() + "/ItemController?action=show-items&success=added"
	            );
			}

		} catch (Exception e) {
			System.out.println("ex => " + e.getMessage());
		}
	}

	private void updateItem(HttpServletRequest request, HttpServletResponse response) {
		try {
			ItemService itemService = getItemService();
			Item item = buildItemFromRequest(request);

			boolean isItemUpdated = itemService.updateItem(item);
			if (isItemUpdated) {
				response.sendRedirect(request.getContextPath() + "/ItemController?action=show-items&success=updated");
//				showItems(request, response);
			}else {
				response.sendRedirect(
		                request.getContextPath() + "/ItemController?action=show-items&success=nameExist"
		            );
			}


		} catch (Exception e) {
			System.out.println("ex => " + e.getMessage());
		}
	}

	private void removeItem(HttpServletRequest request, HttpServletResponse response) {
		try {
			ItemService itemService = getItemService();
			long id = Long.parseLong(request.getParameter("id"));

			boolean isItemDeleted = itemService.removeItem(id);
			if (isItemDeleted) {
				response.sendRedirect(request.getContextPath() + "/ItemController?action=show-items&success=removed");
//				showItems(request, response);
			}

		} catch (Exception e) {
			System.out.println("ex => " + e.getMessage());
		}
	}
}
