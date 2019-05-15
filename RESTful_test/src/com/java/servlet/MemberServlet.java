package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.dto.MemberVO;

@WebServlet("/member")
public class MemberServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* JSP를 통한 json 내보내기....
		String url="/data/member.jsp";		
		request.setAttribute("member", new MemberVO("kkk","kkk","kkk","kkk"));		
		request.getRequestDispatcher(url).forward(request, response);
		*/
		
		MemberVO member=new MemberVO("유빈","babo","메롱","질문하지마");
		
		ObjectMapper mapper=new ObjectMapper();
		
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println(mapper.writeValueAsString(member));
	}

	

}
