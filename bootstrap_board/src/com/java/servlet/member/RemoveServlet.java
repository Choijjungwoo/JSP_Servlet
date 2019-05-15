package com.java.servlet.member;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.dto.MemberVO;
import com.java.service.MemberService;
import com.java.service.MemberServiceImpl;
import com.java.utils.GetUploadPath;

@WebServlet("/member/remove")
public class RemoveServlet extends HttpServlet {
	
	private MemberService service=MemberServiceImpl.getInstance();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/WEB-INF/views/member/removeSuccess.jsp";
		
		String id=request.getParameter("id");
		
		try {
			//이미지 파일을 삭제
			MemberVO member=service.getMember(id);
			String fileName=member.getPicture();
			String savedPath=GetUploadPath.getUploadPath("member.picture.upload");
			File file = new File(savedPath+fileName);
			if(file.exists()) {
				file.delete();
			}
						
			//삭제되는 회원이 로그인 회원인경우 로그아웃 해야함.
			MemberVO loginUser=
				(MemberVO)request.getSession().getAttribute("loginUser");
			if(loginUser.getId().equals(member.getId())) {
				request.getSession().invalidate();
			}
			
			request.setAttribute("member", member);	
			service.remove(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
