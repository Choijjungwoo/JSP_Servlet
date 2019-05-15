package com.java.servlet.board;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.request.Criteria;
import com.java.request.PageMaker;
import com.java.service.BoardService;
import com.java.service.BoardServiceImpl;


@WebServlet("/board/remove")
public class RemoveBoardServlet extends HttpServlet {
	
	private BoardService service = BoardServiceImpl.getInstance();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String url="/WEB-INF/views/board/removeSuccess.jsp";
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		int page=Integer.parseInt(request.getParameter("page"));
		int perPageNum=Integer.parseInt(request.getParameter("perPageNum"));
		
		
		Criteria cri=new Criteria();
		cri.setPage(page);
		cri.setPerPageNum(perPageNum);
		
		PageMaker pageMaker=new PageMaker();
		pageMaker.setCri(cri);
				
		try {
			service.remove(bno);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		request.setAttribute("deleted_bno", bno);
		request.setAttribute("pageMaker", pageMaker);
		
		request.getRequestDispatcher(url).forward(request, response);
		
		
	}

}
