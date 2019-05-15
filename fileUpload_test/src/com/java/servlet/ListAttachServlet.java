package com.java.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.dto.AttachVO;
import com.java.service.AttachService;
import com.java.service.AttachServiceImpl;


@WebServlet("/attach/list")
public class ListAttachServlet extends HttpServlet {
	
	private AttachService service = AttachServiceImpl.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/WEB-INF/views/attachList.jsp";
		
		int pno=Integer.parseInt(request.getParameter("pno"));
		
		try {
			List<AttachVO> attachList=service.getAttachList(pno);
			request.setAttribute("attachList", attachList);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		request.getRequestDispatcher(url).forward(request, response);
	}
}





