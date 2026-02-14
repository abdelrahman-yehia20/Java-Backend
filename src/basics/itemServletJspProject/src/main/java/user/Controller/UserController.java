package user.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import user.model.User;
import user.service.UserService;
import user.service.impl.UserServiceImpl;


@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Resource(name = "jdbc/connection")
	private DataSource dataSource;
	
	private UserService getUserService() {
		return new UserServiceImpl(dataSource);
	}
	
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		switch(action){
				case "login" :
					login(request, response);
					break;
				case "signup" :
					signup(request, response);
					break;
				case "logout" :
					logout(request, response);
					break;
				default:
					login(request, response);
		}
	}

	
	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        Cookie cookie = new Cookie("userEmail", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        response.sendRedirect("user/login.jsp");		
	}


	private void signup(HttpServletRequest request, HttpServletResponse response) {

		try {
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			User user= new User(name, email, password);
			boolean isUserCreated = getUserService().createUser(user);
			if(isUserCreated) {
				response.sendRedirect("user/login.jsp?success=Account created");
			}else {
				 response.sendRedirect("user/signup.jsp?error=Email already exists");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


	private void login(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			User user = getUserService().login(email, password);
			
			if(Objects.isNull(user)) {
				response.sendRedirect("user/login.jsp?error=invalid");
				return;
			}
			
			 HttpSession session = request.getSession();
	         session.setAttribute("loggedUser", user);

	         Cookie cookie = new Cookie("userEmail", user.getEmail());
	         cookie.setMaxAge(60 * 60);
	         response.addCookie(cookie);
	         
	         response.sendRedirect("ItemController?action=show-items");
	         
		}catch (Exception e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
