package com.java.servlet.member;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.request.Criteria;
import com.java.service.MemberService;
import com.java.service.MemberServiceImpl;


@WebServlet("/member/list")
public class ListServlet extends HttpServlet {
	
	private MemberService service=MemberServiceImpl.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/WEB-INF/views/member/memberList.jsp";
				
		/*String pageStr=request.getParameter("page");
		String perPageNumStr=request.getParameter("perPageNum");
		
		int page=1;	
		int perPageNum=10;
		if(pageStr!=null && perPageNumStr!=null) {
			page=Integer.parseInt(pageStr);
			perPageNum=Integer.parseInt(perPageNumStr);
		}*/
		
		String searchType=request.getParameter("searchType");
		String keyword=request.getParameter("keyword");
		
		Criteria cri =new Criteria();
		try {
			int page=Integer.parseInt(request.getParameter("page"));
			int perPageNum=Integer.parseInt(request.getParameter("perPageNum"));
			cri.setPage(page);
			cri.setPerPageNum(perPageNum);	
			
		}catch(NumberFormatException e) {
			System.out.println("페이지 번호가 누락으로 기본 1페이지로 세팅됩니다.");
		}
		cri.setSearchType(searchType);
		cri.setKeyword(keyword);
		
		try {
			//List<MemberVO> memberList=service.getMemberList();
			//request.setAttribute("memberList", memberList);
			
			Map<String,Object> dataMap = service.getMemberList(cri);
			request.setAttribute("dataMap", dataMap);
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}
}






