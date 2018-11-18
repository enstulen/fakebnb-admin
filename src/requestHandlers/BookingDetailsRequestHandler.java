package requestHandlers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datastore.Datastore;
import entities.Booking;
import entities.Home;

public class BookingDetailsRequestHandler implements RequestHandler {

	private Datastore datastore;
	private SimpleDateFormat formatter;

	public BookingDetailsRequestHandler() {
		datastore = Datastore.getInstance();
		formatter = new SimpleDateFormat("dd MMM YYYY");
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sView = "";

		String path = request.getServletPath();
		if (path.equals("/booking-details") || path.equals("/booking-details.html")) {
			Booking booking;

			if ("POST".equalsIgnoreCase(request.getMethod())) {
				if (request.getParameter("type") != null) {
					if (request.getParameter("type").equals("delete-booking")) {
						int bookingid = Integer.parseInt(request.getParameter("bookingid"));
						datastore.deleteBooking(bookingid);
						sView="index.jsp";
						return sView;
					}
				}
			}

			String idString = request.getParameter("id");
			int id = 0;
			try {
				id = Integer.parseInt(idString);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
//				homes = (List<Home>) datastore.getHomes();
				booking = datastore.getBooking(id);
				if (booking == null) {
					return "notFound.jsp";
				}
				request.setAttribute("booking", booking);
				request.setAttribute("home", booking.getHome());
				request.setAttribute("formatter", this.formatter);

			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sView = "booking-details.jsp";
		}
		return sView;
	}

}
