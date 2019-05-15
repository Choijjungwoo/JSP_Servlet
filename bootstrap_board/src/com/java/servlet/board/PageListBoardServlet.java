package com.java.servlet.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.dao.PageMybatisBoardDAOImpl;
import com.java.dto.BoardVO;
import com.java.request.Criteria;

@WebServlet("/board/listPage")
public class PageListBoardServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/WEB-INF/views/board/listBoard.jsp";
		
		String page=request.getParameter("page");
		String perPageNum=request.getParameter("perPageNum");
		
		Criteria cri=new Criteria();
		cri.setPage(Integer.parseInt(page));
		cri.setPerPageNum(Integer.parseInt(perPageNum));				
		
		List<BoardVO> boardList=null;
		try {
			boardList = PageMybatisBoardDAOImpl.getInstance().selectBoardCriteria(cri);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("boardList", boardList);
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
