package com.java.servlet.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.dto.MemberVO;
import com.java.service.MemberService;
import com.java.service.MemberServiceImpl;

@WebServlet("/member/stop")
public class DisableMemberServlet extends HttpServlet {
	
	private MemberService service = MemberServiceImpl.getInstance();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("id");
		MemberVO member=null;
		try {
			member = service.getMember(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//service 호출	(enabled -> 0)
		try {
			service.disable(id);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		//loginUser와 동일할 경우 로그아웃
		String url="/WEB-INF/views/member/stopMember.jsp";
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		if(id.equals(loginUser.getId())) {
			session.invalidate();
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('현재 접속중인 아이디이므로 로그아웃합니다.')");
			out.println("location.href='"+request.getContextPath()+"/commons/login';");
			out.println("</script>");
		}else {
			request.setAttribute("member", member);
			request.getRequestDispatcher(url).forward(request, response);
		}
	}

}
