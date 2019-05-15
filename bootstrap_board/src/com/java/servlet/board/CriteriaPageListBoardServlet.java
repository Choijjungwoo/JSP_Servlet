package com.java.servlet.board;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.request.Criteria;
import com.java.service.BoardServiceImpl;

@WebServlet("/board/listCri")
public class CriteriaPageListBoardServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url="/WEB-INF/views/board/listCri.jsp";
		
		String page=request.getParameter("page");
		String perPageNum=request.getParameter("perPageNum");		
		
		Criteria cri=new Criteria();
		if(page!=null && perPageNum!=null) {
			cri.setPage(Integer.parseInt(page));
			cri.setPerPageNum(Integer.parseInt(perPageNum));
		}
		
		try {
			Map<String,Object> dataMap=
					BoardServiceImpl.getInstance().getBoardList(cri);
			request.setAttribute("dataMap", dataMap);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
		
		request.getRequestDispatcher(url).forward(request, response);
	}
}
