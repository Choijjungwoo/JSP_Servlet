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


@WebServlet("/member/detail")
public class DetailServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/WEB-INF/views/member/detail.jsp";
		
		String id=request.getParameter("id");

		MemberVO member=null;
		try {
			member = MemberDAO.getInstance().selectMemberById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("member", member);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
