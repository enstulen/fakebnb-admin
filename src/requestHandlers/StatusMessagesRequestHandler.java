package requestHandlers;

import java.io.IOException;
import java.text.SimpleDateFormat;

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
import java.util.Date;
import java.util.List;

import entities.Booking;
import entities.Home;
import entities.Message;
import entities.User;

public class StatusMessagesRequestHandler implements RequestHandler {

	private Datastore datastore;

	public StatusMessagesRequestHandler() {
		datastore = Datastore.getInstance();
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sView = "";
		
		User currentUser = (User) request.getSession().getAttribute("user");

		String path = request.getServletPath();
		if (path.equals("/mark-as-read.html")) {
			sView = "messages.jsp";
		}
        String messageId = request.getParameter("readStatus");
        if (messageId!=null){
	        System.out.println(messageId);
	        Message message = datastore.getMessage(Integer.parseInt(messageId));
	        message.setMessage_read(true);
	        System.out.println("message:"+message.isMessage_read());
	        datastore.updateMessage(message);
	        System.out.print(datastore.getMessage(Integer.parseInt(messageId)).isMessage_read());
	        System.out.print("Updated");
        }
        List<entities.Message> messages = (List<entities.Message>) datastore.getMessagesForUser(currentUser);
		Collections.reverse(messages);
		request.setAttribute("Messages", messages);
		return sView;
	}

}

