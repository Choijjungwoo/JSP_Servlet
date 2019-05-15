package com.java.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.exception.IdNotFoundException;
import com.java.exception.InvalidPasswordException;
import com.java.service.MemberServiceImpl;

@WebServlet("/commons/login")
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/WEB-INF/views/commons/loginForm.jsp";
		request.getRequestDispatcher(url).forward(request, response);		
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url=request.getContextPath()+"/main";
		
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		
		String message=null;
		HttpSession session = request.getSession();		
		session.removeAttribute("msg");
		session.removeAttribute("id");		
		
		try {
			MemberServiceImpl.getInstance().login(id, pwd);
			session.setAttribute("loginUser", MemberServiceImpl.getInstance().getMember(id));
			session.setMaxInactiveInterval(60*6);
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (IdNotFoundException e) {
			message="아이디가 존재하지 않습니다.";			
			url="login";
			e.printStackTrace();
		} catch (InvalidPasswordException e) {
			message="패스워드가 일치하지 않습니다.";
			url="login";
			e.printStackTrace();
		}
		
		session.setAttribute("msg",message);
		session.setAttribute("id",id);
		
		response.sendRedirect(url);
		
	}

}




