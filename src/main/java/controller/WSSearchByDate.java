package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Event;
import model.EventDao;




@WebServlet("/WSSearchByDate")
public class WSSearchByDate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public WSSearchByDate() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		
	
		String startTime = request.getParameter("EVENT_STARTIME");	
		
		EventDao dao = new EventDao();	
		List<Event> eventBeans =dao.selectStartTime(startTime);
		
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
