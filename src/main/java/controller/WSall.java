package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Event;
import model.EventDao;
import util.HibernateUtil;




@WebServlet("/WSall")
public class WSall extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public WSall() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
	
//		HttpSession httpSession = request.getSession();
		
		EventDao dao = new EventDao();
		
		
		List<Event> eventBeans = dao.findAll();
		
		for(Event evBeans:eventBeans) {
			System.out.println(evBeans);
		}
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
