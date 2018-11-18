package javaPackage;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.User;
import requestHandlers.AdminRequestHandler;
import requestHandlers.BookingDetailsRequestHandler;
import requestHandlers.IndexRequestHandler;
import requestHandlers.MessagesRequestHandler;
import requestHandlers.ReadMessagesRequestHandler;
import requestHandlers.RequestHandler;
import requestHandlers.SearchResultsRequestHandler;
import requestHandlers.SendMessagesRequestHandler;
import requestHandlers.StatusMessagesRequestHandler;
import requestHandlers.BookingsRequestHandler;
import requestHandlers.DetailsRequestHandler;
import requestHandlers.EditNewRequestHandler;

/**
 * Servlet implementation class ControllerServlet
 */
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletConfig config;

	// Inject the connectionFactory using annotations
	@Resource(mappedName = "tiwconnectionfactory")
	private ConnectionFactory tiwconnectionfactory;
	// Inject the queue using annotations
	@Resource(mappedName = "tiwqueue")
	private Queue queue;

	// Hash table of RequestHandler instances, keyed by request URL
	private Map handlerHash = new HashMap();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.config = config;
		handlerHash.put("/admin.html", new AdminRequestHandler());
		handlerHash.put("/edit-new-booking.html", new EditNewRequestHandler());
		handlerHash.put("/edit-new-user.html", new EditNewRequestHandler());
		handlerHash.put("/edit-new-message.html", new EditNewRequestHandler());
		handlerHash.put("/edit-new-home.html", new EditNewRequestHandler());

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String path = request.getServletPath();

		RequestHandler requestHandler = (RequestHandler) handlerHash.get(path);
		if (requestHandler == null) {
			request.getRequestDispatcher("notFound.jsp").forward(request, response);
		} else {
			String sView = requestHandler.handleRequest(request, response);
			request.getRequestDispatcher(sView).forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = request.getServletPath();
		RequestHandler requestHandler = (RequestHandler) handlerHash.get(path);
		String sView = requestHandler.handleRequest(request, response);

		if (request.getParameter("IniciaSesion") != null) {
			System.out.println("You made it");
		}
		request.getRequestDispatcher(sView).forward(request, response);

	}

}
