package requestHandlers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Booking;
import entities.Home;
import entities.Message;
import entities.User;
import datastore.Datastore;

public class EditNewRequestHandler implements RequestHandler {

	private Datastore datastore;
	private SimpleDateFormat s;

	public EditNewRequestHandler() {
		this.datastore = Datastore.getInstance();
		this.s = new SimpleDateFormat("yyyy-MM-dd");
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sView = "";
		String id = null;
		// home page
		if (request.getServletPath().equalsIgnoreCase("/edit-new-home.html")) {

			String requestString = request.getQueryString();
			if (requestString != null) {
				String parameters[] = requestString.split("=");
				id = parameters[parameters.length - 1]; // Since there is only 1 query param atm
			}

			if ("POST".equalsIgnoreCase(request.getMethod())) {
				if (id != null) {
					createUpdateHome(request, Integer.parseInt(id));
				} else {
					createUpdateHome(request, null);
				}
			} else {
				if (id != null) {
					Home home = datastore.getHome(Integer.parseInt(id));
					request.setAttribute("home", home);
				}
				request.setAttribute("admin", true);
				request.setAttribute("formatter", s);
				sView = "/edit-new-pages/edit-new-home.jsp";
			}
			// booking page
		} else if (request.getServletPath().equalsIgnoreCase("/edit-new-booking.html")) {
			String requestString = request.getQueryString();
			if (requestString != null) {
				String parameters[] = requestString.split("=");
				id = parameters[parameters.length - 1]; // Since there is only 1 query param atm
			}

			if ("POST".equalsIgnoreCase(request.getMethod())) {
				if (id != null) {
					createUpdateBooking(request, Integer.parseInt(id));
				} else {
					createUpdateBooking(request, null);
				}
			} else {
				if (id != null) {
					Booking booking = datastore.getBooking(Integer.parseInt(id));
					request.setAttribute("booking", booking);
				}
				request.setAttribute("admin", true);
				request.setAttribute("formatter", s);
				sView = "/edit-new-pages/edit-new-booking.jsp";
			}
			// user page
		} else if (request.getServletPath().equalsIgnoreCase("/edit-new-user.html")) {
			String requestString = request.getQueryString();
			if (requestString != null) {
				String parameters[] = requestString.split("=");
				id = parameters[parameters.length - 1]; // Since there is only 1 query param atm
			}

			if ("POST".equalsIgnoreCase(request.getMethod())) {
				if (id != null) {
					createUpdateUser(request, Integer.parseInt(id));
				} else {
					createUpdateUser(request, null);
				}
			} else {
				if (id != null) {
					User user = datastore.getUser(Integer.parseInt(id));
					request.setAttribute("user", user);
				}
				request.setAttribute("admin", true);
				request.setAttribute("formatter", s);
				sView = "/edit-new-pages/edit-new-user.jsp";
			}
			// message page
		} else if (request.getServletPath().equalsIgnoreCase("/edit-new-message.html")) {
			String requestString = request.getQueryString();
			if (requestString != null) {
				String parameters[] = requestString.split("=");
				id = parameters[parameters.length - 1]; // Since there is only 1 query param atm
			}

			if ("POST".equalsIgnoreCase(request.getMethod())) {
				if (id != null) {
					createUpdateMessage(request, Integer.parseInt(id));
				} else {
					createUpdateMessage(request, null);
				}
			} else {
				if (id != null) {
					Message message = datastore.getMessage(Integer.parseInt(id));
					request.setAttribute("message", message);
				}
				request.setAttribute("admin", true);
				
				request.setAttribute("formatter", s);
				sView = "/edit-new-pages/edit-new-message.jsp";
			}
		}
		return sView;
	}

	private void createUpdateMessage(HttpServletRequest request, Integer messageId) {
		Message message;
		if(messageId==null) {
			message=new Message();
		}
		else {
			message=datastore.getMessage(messageId);
		}
		
		String text=request.getParameter("message-text");
		String senderId=request.getParameter("sender-id");
		String receiverId=request.getParameter("receiver-id");
		String timestamp=request.getParameter("timestamp");
		
		try {
			message.setTime_stamp(s.parse(timestamp));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(text!=null) {
			message.setText(text);
		}
		
		
		if(senderId!=null) {
			message.setSender(datastore.getUser(Integer.parseInt(senderId)));
		}
		
		if(receiverId!=null) {
			message.setReciever(datastore.getUser(Integer.parseInt(receiverId)));
		}
		

		if (messageId == null) {
			datastore.createNewMessage(message);
		} else {
			datastore.updateMessage(message);
		}

	}

	private void createUpdateUser(HttpServletRequest request, Integer userId) {
		User user;
		if (userId == null) {
			user = new User();
		} else {
			user = datastore.getUser(userId);
		}
		
		String email=request.getParameter("email");
		String name=request.getParameter("uname");
		String surname=request.getParameter("surname");
		String password=request.getParameter("password");
		
		if (email!=null) {
			user.setEmail(email);
		}
		
		if(name!=null) {
			user.setName(name);
		}
		
		if(surname!=null) {
			user.setSurname(surname);
		}
		
		if(password!=null) {
			user.setPassword(password);
		}
		
		if (userId == null) {
			datastore.createNewUser(user);
		} else {
			datastore.updateUser(user);
		}

	}

	private void createUpdateBooking(HttpServletRequest request, Integer bookingId) {
		Booking booking;
		if (bookingId == null) {
			booking = new Booking();
		} else {
			booking = datastore.getBooking(bookingId);
		}
		
		Date start=null;
		Date end=null;
		Date booked=null;
		String homeId = request.getParameter("homeId");
		String guestId = request.getParameter("guestId");
		String dateStart = request.getParameter("date_start");
		String dateEnd=request.getParameter("date_end");
		String dateBooked=request.getParameter("date_booked");
		String cardNumber=request.getParameter("card_number");
		
		if (dateStart!=null &&dateEnd != null) {
			try {				
				start=s.parse(dateStart);
				end=s.parse(dateEnd);
				booked=s.parse(dateBooked);
				Date anothertest=s.parse("2018-05-12");
				String tesst=s.format(start);
				
				if(!start.after(end)) {
					if (dateStart != null ) {
						booking.setDate_start(start);
					}
					if(dateEnd !=null )
					{
						booking.setDate_end(end);
					}
					
					if (dateBooked != null) {
						booking.setDate_booking(booked);
					}
				}
			}
			catch(ParseException e) {
			
			}
		}
		
		if(cardNumber!=null) {
			booking.setCard_number(cardNumber);
		}
		
		
		
		
		if (homeId != null) {
			Home home=datastore.getHome(Integer.parseInt(homeId));
			booking.setHome(home);
			
			booking.setHost(home.getUser());
		} 
		
		if (guestId != null) {
			booking.setGuest(datastore.getUser(Integer.parseInt(guestId)));
		} 

		
		

		
		if (bookingId == null) {
			datastore.createNewBooking(booking);
		} else {
			datastore.updateBooking(booking);
		}

	}

	private void createUpdateHome(HttpServletRequest request, Integer homeID) {
		Home home = null;
		if (homeID == null) {
			home = new Home();
		} else {
			home = datastore.getHome(homeID);
		}

		String name = request.getParameter("name");
		String full_description = request.getParameter("full_description");
		String short_description = request.getParameter("short_description");
		String typeString = request.getParameter("type");
		int type;

		if (typeString != null) {
			switch (typeString) {
			case "entire":
				type = 0;
				break;
			case "private":
				type = 1;
				break;
			case "shared":
				type = 2;
				break;
			default:
				type = 0;
				break;
			}
		} else {
			type = 0;
		}

		int number_of_guests = Integer.parseInt(request.getParameter("number_of_guests"));
		int price = Integer.parseInt(request.getParameter("price"));
		String date_start = request.getParameter("date-start");
		String date_end = request.getParameter("date-end");

		String user_id = request.getParameter("user_userid");

		if (user_id != null) {
			home.setUser(datastore.getUser(Integer.parseInt(user_id)));
		} else {
			home.setUser(datastore.getCurrentUser());
		}

		try {
			Date start = new SimpleDateFormat("MM/dd/yyyy").parse(date_start);
			Date end = new SimpleDateFormat("MM/dd/yyyy").parse(date_end);
			home.setDate_available_start(start);
			home.setDate_available_end(end);
		} catch (Exception e) {
			e.printStackTrace();
		}

		home.setNumber_of_guests(number_of_guests);
		home.setName(name);
		home.setFull_description(full_description);
		home.setShort_description(short_description);
		home.setType(type);
		home.setPrice(price);
		if (homeID == null) {
			datastore.createNewHome(home);
		} else {
			datastore.updateHome(home);
		}
	}
}