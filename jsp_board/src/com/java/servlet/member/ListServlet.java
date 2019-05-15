package com.java.servlet.member;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.dto.MemberVO;
import com.java.service.MemberService;
import com.java.service.MemberServiceImpl;


@WebServlet("/member/list")
public class ListServlet extends HttpServlet {
	
	private MemberService service=MemberServiceImpl.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/WEB-INF/views/member/memberList.jsp";
		
		try {
			List<MemberVO> memberList=service.getMemberList();
			request.setAttribute("memberList", memberList);
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}
}






