package com.java.servlet.board;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.dto.BoardVO;
import com.java.service.BoardService;
import com.java.service.BoardServiceImpl;


@WebServlet("/board/detail")
public class DetailBoardServlet extends HttpServlet {
	
	private BoardService service=BoardServiceImpl.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url="/WEB-INF/views/board/detailBoard.jsp";
		
		int bno=Integer.parseInt(request.getParameter("bno"));
		
		try {
			BoardVO board=service.getBoard(bno);
			request.setAttribute("board", board);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
