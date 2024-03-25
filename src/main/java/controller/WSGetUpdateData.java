package controller;

import java.io.IOException;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import model.Event;
import model.EventDao;



@WebServlet("/WSGetUpdateData")
public class WSGetUpdateData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public WSGetUpdateData() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		Integer EventId =Integer.parseInt(request.getParameter("EVENTID")) ;
		EventDao dao= new EventDao();
		
		Event eventBeans =dao.select(EventId);
		System.out.println(eventBeans);
		request.setAttribute("eventBeans", eventBeans);
//updateData.jsp	<jsp:useBean id="emp" 

		request.getRequestDispatcher("/JSP/WSupdateData.jsp").forward(request, response); 
		
		
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
