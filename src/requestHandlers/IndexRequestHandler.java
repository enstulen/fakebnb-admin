package requestHandlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datastore.Datastore;
import entities.User;

public class IndexRequestHandler implements RequestHandler {
	
	private Datastore datastore;
	
	public IndexRequestHandler() {
		this.datastore = Datastore.getInstance();
	}


	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sView = "";

		String path = request.getServletPath();
		if (path.equals("/index.html")) {
			sView = "index.jsp";
			
			String email = request.getParameter("email");
			String password = request.getParameter("password");

			//Register
			if ((request.getParameter("name") != null) && (request.getParameter("surname") != null)) {
				 
				String name = request.getParameter("name");
				String surname = request.getParameter("surname");

				User newUser = new User();
				newUser.setEmail(email);
				newUser.setPassword(password);
				newUser.setName(name);
				newUser.setSurname(surname);
				
				datastore.createNewUser(newUser);
				datastore.setCurrentUser(newUser);
				request.getSession().setAttribute("user", newUser);
				if (newUser.getAdmin() == 1) {
					request.getSession().setAttribute("admin", true);
				}
				
			} 
			//Login
			else if ((email != null) && (password != null)){
				if (datastore.findUser(email, password) != null) {
					User user = datastore.findUser(email, password);	
					datastore.setCurrentUser(user);
					request.getSession().setAttribute("user", user);
					System.out.println(user.getAdmin());
					if (user.getAdmin() == 1) {
						request.getSession().setAttribute("admin", true);
					}
				}
	
			}
			//Logout
			else if (request.getParameter("type") != null ) {
				if (request.getParameter("type").equals("logout")) {
					request.getSession().removeAttribute("user");
					request.getSession().removeAttribute("admin");
				}
			}
		}
		return sView;
	}

}
