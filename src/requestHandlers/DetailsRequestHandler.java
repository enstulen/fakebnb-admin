package requestHandlers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datastore.Datastore;
import entities.Booking;
import entities.Home;

public class DetailsRequestHandler implements RequestHandler {

	private Datastore datastore;

	public DetailsRequestHandler() {
		datastore = Datastore.getInstance();
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sView = "";

		String path = request.getServletPath();
		if (path.equals("/details") || path.equals("/details.html")) {

			Home home;
			String idString = request.getParameter("id");
			int id = 0;
			try {
				id = Integer.parseInt(idString);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			home = datastore.getHome(id);

			if (home == null) {
				return "notFound.jsp";
			}

			request.setAttribute("home", home);
			sView = "detailHome.jsp";
		}

		return sView;
	}

}
