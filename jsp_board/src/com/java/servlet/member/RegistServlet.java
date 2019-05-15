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

@WebServlet("/member/regist")
public class RegistServlet extends HttpServlet {
	
	private MemberService memberService
					=MemberServiceImpl.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/WEB-INF/views/member/regist.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="list";
		
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		String email=request.getParameter("email");
		/*String[] phoneArray=request.getParameterValues("phone");		
		String phone = phoneArray[0]+phoneArray[1]+phoneArray[2];*/
		
		String phone="";
		for(String data:request.getParameterValues("phone")) {
			phone+=data;
		}
		
		MemberVO member=new MemberVO();
		member.setId(id);
		member.setPwd(pwd);
		member.setPhone(phone);
		member.setEmail(email);
		
		try {
			memberService.regist(member);
		} catch (SQLException e) {			
			e.printStackTrace();			
		}
		
		response.sendRedirect(url);		
		
	}

}







