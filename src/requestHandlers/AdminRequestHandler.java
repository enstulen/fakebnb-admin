package requestHandlers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import JDBC.UserRepo;
import entities.Booking;
import entities.Home;
import entities.Message;
import entities.User;
import datastore.Datastore;

public class AdminRequestHandler implements RequestHandler {

	private Datastore datastore;

	public AdminRequestHandler() {
		datastore = Datastore.getInstance();
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sView = "";

		String path = request.getServletPath();

		if ("POST".equalsIgnoreCase(request.getMethod())) {
			if (request.getParameter("type") != null) {
				if (request.getParameter("type").equals("delete-home")) {
					int homeid = Integer.parseInt(request.getParameter("homeid"));
					datastore.deleteHome(homeid);
				} else if (request.getParameter("type").equals("delete-booking")) {
					int bookingid = Integer.parseInt(request.getParameter("bookingid"));
					datastore.deleteBooking(bookingid);
				} else if (request.getParameter("type").equals("delete-user")) {
					int userid = Integer.parseInt(request.getParameter("userid"));
					datastore.deleteUser(userid);
				} else if (request.getParameter("type").equals("delete-message")) {
					int messageid = Integer.parseInt(request.getParameter("messageid"));
					datastore.deleteMessage(messageid);
				}
			}
		}
		List<Home> homes;
		List<Booking> bookings;
		List<Message> messages;
		List<User> users;

		try {
			homes = (List<Home>) datastore.getHomes();
			bookings = (List<Booking>) datastore.getBookings();
			messages = (List<Message>) datastore.getMessages();
			users = UserRepo.getAllUsers();

			request.setAttribute("homes", homes);
			request.setAttribute("bookings", bookings);
			request.setAttribute("messages", messages);
			request.setAttribute("users", users);

		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		sView = "admin.jsp";

		return sView;
	}

}
