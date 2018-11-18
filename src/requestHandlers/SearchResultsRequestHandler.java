package requestHandlers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import entities.Home;
import datastore.Datastore;

public class SearchResultsRequestHandler implements RequestHandler {

	private Datastore datastore;

	public SearchResultsRequestHandler() {
		datastore = Datastore.getInstance();
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sView = "";

		String path = request.getServletPath();
		if (path.equals("/searchResults") || path.equals("/searchResults.html")) {
			List<Home> homes;
			String name = request.getParameter("name");
			String start_date_string = request.getParameter("date-start");
			String end_date_string = request.getParameter("date-end");
			int price = Integer.parseInt(request.getParameter("price"));
			int type = Integer.parseInt(request.getParameter("type"));
			int adults = Integer.parseInt(request.getParameter("adults"));
			int kids = Integer.parseInt(request.getParameter("kids"));

			try {
				DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
				Date start_date = format.parse(start_date_string);
				Date end_date = format.parse(end_date_string);
				homes = datastore.findHome(name, start_date, end_date, price, type, adults, kids);
				request.setAttribute("homes", homes);

			}  catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			sView = "searchResults.jsp";
		}

		return sView;
	}

}
