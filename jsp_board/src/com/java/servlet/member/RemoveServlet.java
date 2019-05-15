package com.java.servlet.member;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.service.MemberService;
import com.java.service.MemberServiceImpl;

@WebServlet("/member/remove")
public class RemoveServlet extends HttpServlet {
	
	private MemberService service=MemberServiceImpl.getInstance();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/WEB-INF/views/member/removeSuccess.jsp";
		
		String id=request.getParameter("id");
		
		try {
			request.setAttribute("member", service.getMember(id));		
			service.remove(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
