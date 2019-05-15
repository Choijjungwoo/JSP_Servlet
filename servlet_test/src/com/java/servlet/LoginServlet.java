package com.java.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.exception.IdNotFoundException;
import com.java.exception.InvalidPasswordException;
import com.java.service.MemberService;
import com.java.service.MemberServiceImpl;

public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, 
						 HttpServletResponse resp) throws ServletException, IOException {
		//login form 보여주기
		
		String url="/WEB-INF/views/loginForm.jsp";
		
		req.getRequestDispatcher(url).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req,
			              HttpServletResponse resp) throws ServletException, IOException {
		
		String url=req.getContextPath()+"/main";
		
		MemberService service=MemberServiceImpl.getInstance();		
		
		//login 처리
		String id=req.getParameter("id");
		String pwd=req.getParameter("pwd");		
		
		try {
			service.login(id, pwd);	
		} catch (SQLException e) {			
			e.printStackTrace();
		} catch (IdNotFoundException | InvalidPasswordException e) {//패스워드 불일치
			url=req.getContextPath()+"/login";			
		}
		
		//처리된 후의 화면결정.
		resp.sendRedirect(url);
	}

	
	
}





