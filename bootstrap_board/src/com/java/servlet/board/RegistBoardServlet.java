package com.java.servlet.board;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.dto.BoardVO;
import com.java.request.RegistBoardRequest;
import com.java.service.BoardService;
import com.java.service.BoardServiceImpl;

@WebServlet("/board/regist")
public class RegistBoardServlet extends HttpServlet {
	
	private BoardService service=BoardServiceImpl.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/WEB-INF/views/board/registBoard.jsp";
			
		request.getRequestDispatcher(url).forward(request, response);
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="listSearch";		
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		String writer=request.getParameter("writer");
			
		BoardVO board=
		new RegistBoardRequest(title,content,writer).toBoardVO();
		
		try {
			service.write(board);
		} catch (SQLException e) {
			e.printStackTrace();		
		}
		
		
		response.sendRedirect(url);
	}

}








