package requestHandlers;

import java.io.IOException;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import datastore.Datastore;

import java.util.Collections;
import java.util.List;

import entities.Message;
import entities.User;

public class MessagesRequestHandler implements RequestHandler {

	private Datastore dataStore;

	public MessagesRequestHandler() {
		dataStore = Datastore.getInstance();
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sView = "";
		
		User currentUser = (User) request.getSession().getAttribute("user");

		String path = request.getServletPath();
		if (path.equals("/messages.html")) {
			sView = "messages.jsp";
		}
		
		if ("POST".equalsIgnoreCase(request.getMethod())) {
			if (request.getParameter("type") != null) {
				String message = request.getParameter("message");
				String messageidString = request.getParameter("messageid");
				String[] parts = message.split(" ");

				int messageid = Integer.parseInt(messageidString);
				int bookingid = Integer.parseInt(parts[1]);

				if (request.getParameter("type").equals("declineBooking")) {
					dataStore.deleteBooking(bookingid);
					dataStore.deleteMessage(messageid);
				} else if (request.getParameter("type").equals("acceptBooking")) {
					dataStore.deleteMessage(messageid);
					dataStore.setBookingConfirmed(bookingid);
				}

			}
		}
		List<Message> messages = (List<Message>) dataStore.getMessagesForUser(currentUser);
		Collections.reverse(messages);
		request.setAttribute("Messages", messages);
		return sView;
	}

}
