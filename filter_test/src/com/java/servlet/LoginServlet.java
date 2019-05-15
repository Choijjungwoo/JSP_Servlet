package com.java.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/commons/login")
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/WEB-INF/views/commons/form.jsp";
		request.getRequestDispatcher(url).forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="redirect:"+request.getContextPath()+"/member/main";
		
		String id=request.getParameter("id");
		String pwd=request.getParameter("password");
		String idSave=request.getParameter("idSave");
		
		if(idSave.equals("1")) {
			request.setAttribute("id",id);
		}
		
		if(id.equals("admin")) {
			if(pwd.equals("admin")) {
				HttpSession session = request.getSession();
				session.setMaxInactiveInterval(60*6);
				session.setAttribute("loginUser", id);
			}else { //패스워드 불일치
				url="/WEB-INF/views/commons/form.jsp";
			}
		}else { //아이디 불일치
			url="/WEB-INF/views/commons/form.jsp";
		}
		
		if(url.contains("redirect:")) {			
			response.sendRedirect(url.substring("redirect:".length()));
		}else {
			request.getRequestDispatcher(url).forward(request, response);
		}
	}

}




