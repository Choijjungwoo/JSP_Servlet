package com.java.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.dao.MemberDAO;
import com.java.dto.MemberVO;


@WebServlet("/member/regist")
public class RegistServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/WEB-INF/views/member/registForm.jsp";
		request.getRequestDispatcher(url).forward(request,response);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url="list";
		
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		
		MemberVO member=new MemberVO(id,pwd,email,phone);
		
		try {
			MemberDAO.getInstance().insertMember(member);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		response.sendRedirect(url);
	
	}

}
