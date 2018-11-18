package requestHandlers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entities.Booking;
import datastore.Datastore;

public class BookingsRequestHandler implements RequestHandler {
	
	private Datastore datastore;
	
	public BookingsRequestHandler() {
		this.datastore = Datastore.getInstance();
	}
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sView = "";

		String path = request.getServletPath();
		if (path.equals("/bookings.html") || path.equals("/bookings")) {
			List<Booking> bookings = (List<Booking>) datastore.getBookingsForGuest();
			List<Booking> hostBookings = (List<Booking>) datastore.getBookingsForHost();

			request.setAttribute("bookings",bookings);
			request.setAttribute("hostBookings",hostBookings);

			sView = "bookings.jsp";
		}

		return sView;
	}
}
