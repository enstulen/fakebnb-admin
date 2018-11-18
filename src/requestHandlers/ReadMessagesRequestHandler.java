package requestHandlers;

import java.io.IOException;
import java.sql.Timestamp;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import datastore.Datastore;

import java.util.Collections;
import java.util.List;

import entities.User;

public class ReadMessagesRequestHandler implements RequestHandler {

	private Datastore datastore;

	private ConnectionFactory connectionFactory;
	private Queue queue;

	public ReadMessagesRequestHandler(ConnectionFactory connection, Queue queue) {
		datastore = Datastore.getInstance();
		this.connectionFactory = connection;
		this.queue = queue;

	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sView = "";
		
		User currentUser = (User) request.getSession().getAttribute("user");

		String path = request.getServletPath();
		if (path.equals("/readmessage.html")) {
			sView = "messages.jsp";
		}
		try {
			Connection connection = connectionFactory.createConnection();
			Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);

			connection.start();
			String selector = "receiver = " + "'" + currentUser.getEmail() + "'";
			MessageConsumer consumer = session.createConsumer(queue, selector);
			Message message = null;
			while (true) {

				message = consumer.receive(2000);
				if (message instanceof TextMessage) {
					TextMessage m = (TextMessage) message;
					entities.Message newMessage = new entities.Message();
					newMessage.setText(m.getText());
					newMessage.setReciever(currentUser);
					newMessage.setSender(datastore.findUser(m.getStringProperty("sender")));
					Timestamp timestamp = new Timestamp(System.currentTimeMillis());
					newMessage.setTime_stamp(timestamp);	
					datastore.createNewMessage(newMessage);
				} else {
					break;
				}
			}

			connection.close();
			session.close();
			connection.close();
		} catch (Exception e) {
			System.out.println("JHC *************************************** Error in doPost: " + e);
		}
		List<entities.Message> messages = (List<entities.Message>) datastore.getMessagesForUser(currentUser);
		Collections.reverse(messages);
		request.setAttribute("Messages", messages);
		return sView;
	}

}
