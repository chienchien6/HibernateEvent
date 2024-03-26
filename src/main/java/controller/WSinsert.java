package controller;

import java.io.IOException;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import model.Event;
import model.EventDao;



 @WebServlet("/WSinsert")
public class WSinsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public WSinsert() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
	
		EventDao dao= new EventDao();
		DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		
		Event eventBean = new Event();
		
//		eventBean.setStartTime("EVENT_STARTIME");
        String startTime =request.getParameter("EVENT_STARTIME");
        LocalDate startDate = LocalDate.parse(startTime,date);
        eventBean.setStartTime(java.sql.Date.valueOf(startDate));
        
//		eventBean.setEndTime("EVENT_ENDTIME");
        String endTime =request.getParameter("EVENT_ENDTIME");
        LocalDate EndDate = LocalDate.parse(endTime,date);
        eventBean.setEndTime(java.sql.Date.valueOf(EndDate));
        
//    	eventBean.setSignupStartime("SIGNUP_STARTIME");	
        String signup =request.getParameter("SIGNUP_STARTIME");
        LocalDate signTime = LocalDate.parse(signup,date);
        eventBean.setSignupStartime(java.sql.Date.valueOf(signTime));
        
//    	eventBean.setSignupEndtime("SIGNUP_ENDTIME");	
        String deadline =request.getParameter("SIGNUP_ENDTIME");
        LocalDate EndTime = LocalDate.parse(deadline,date);
        eventBean.setSignupEndtime(java.sql.Date.valueOf(EndTime));
        
//        eventBean.setEventId(Integer.parseInt(request.getParameter("EVENTID")));
		eventBean.setEventName("EVENT_NAME");
		eventBean.setEventDetail("EVENT_DETAIL");
		eventBean.setEventCategory("EVENT_CATEGORY");
		eventBean.setEventPrice(Integer.parseInt(request.getParameter("EVENT_PRICE")));
		eventBean.setEventLocation("EVENT_ADDRES");
		eventBean.setOrganizer("ORGANIZER");
		eventBean.setPicture("PICTURE");
		
		System.out.println(eventBean);
		
		dao.insert(eventBean);
		
		List<Event> eventBeans = dao.findAll();
		
		request.setAttribute("eventBeans", eventBeans);
		request.getRequestDispatcher("/JSP/WSGetAllEmps.jsp")
		.include(request, response);
		request.getRequestDispatcher("/JSP/back.jsp")
		.include(request, response);

		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
