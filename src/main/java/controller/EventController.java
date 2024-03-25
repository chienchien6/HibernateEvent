package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import antlr.debug.NewLineEvent;
import model.MyMember;
import model.MyMemberDao;

@WebServlet("/EventPost")
public class EventController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public EventController() {
        super();
       
    }

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession httpSession = request.getSession();
		String loginName=request.getParameter("uname");
		String loginPwd=request.getParameter("pwd");
		
		MyMemberDao myDao = new MyMemberDao();
		MyMember result = myDao.findByUsernameAndPwd(loginName, loginPwd);
	
		if(result!=null) {
			httpSession.setAttribute("loginUserName", result.getMemberName());
			request.setAttribute("loginOK", "登入成功!");
		}else {
			request.setAttribute("errMsg", "沒有此帳號密碼,請重新輸入");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}

}
