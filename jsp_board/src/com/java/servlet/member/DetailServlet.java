package com.java.servlet.member;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.dto.MemberVO;
import com.java.service.MemberService;
import com.java.service.MemberServiceImpl;

@WebServlet("/member/detail")
public class DetailServlet extends HttpServlet {
	
	private MemberService service=MemberServiceImpl.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/WEB-INF/views/member/memberDetail.jsp";
		
		String id=request.getParameter("id");
		
		MemberVO member=null;
		try {
			member = service.getMember(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("member", member);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
