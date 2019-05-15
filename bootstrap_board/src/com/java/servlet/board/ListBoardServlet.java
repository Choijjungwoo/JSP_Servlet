package com.java.servlet.board;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.dto.BoardVO;
import com.java.service.BoardService;
import com.java.service.BoardServiceImpl;

@WebServlet("/board/list")
public class ListBoardServlet extends HttpServlet{
	
	private BoardService service=BoardServiceImpl.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/WEB-INF/views/board/listBoard.jsp";
		
		List<BoardVO> boardList=null;
		try {
			boardList = service.getBoardList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("boardList",boardList);
		
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	
	
}




