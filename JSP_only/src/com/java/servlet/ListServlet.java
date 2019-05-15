package com.java.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.dao.MemberDAO;
import com.java.dto.MemberVO;

@WebServlet("/member/list")
public class ListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url="/WEB-INF/views/member/list.jsp";
		
		List<MemberVO> memberList=null;
		try {
			memberList = MemberDAO.getInstance().selectMemberList();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//EL문을 사용하기 위해 pageContext에 추가한다.
		request.setAttribute("memberList", memberList);
		
		request.getRequestDispatcher(url).forward(request,response);	
	}

	
	

}
