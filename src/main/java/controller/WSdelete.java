package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

import org.hibernate.Session;
import org.hibernate.SessionFactory;



import model.Event;
import model.EventDao;
import util.HibernateUtil;




@WebServlet("/WSdelete")
public class WSdelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public WSdelete() {
        super();
    }

	
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		
		EventDao dao = new EventDao();
		
		Integer EventId =Integer.parseInt(request.getParameter("EVENTID")) ;
		
		dao.deleteOne(EventId);
		
		List<Event> eventBeans = dao.findAll();
		
		request.setAttribute("eventBeans", eventBeans);
		request.getRequestDispatcher("/JSP/WSGetAllEmps.jsp")
		.include(request, response);
		request.getRequestDispatcher("/JSP/back.jsp")
		.include(request, response);
		
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
