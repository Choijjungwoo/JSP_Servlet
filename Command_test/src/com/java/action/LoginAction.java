package com.java.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url="/WEB-INF/views/loginResult.jsp";
		
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		
		String msg=null;
		
		if(id.equals("admin")) {
			if(pwd.equals("admin")) {
				msg="로그인 성공입니다.";
			}else {
				msg="패스워드가 일치하지 않습니다.";
			}
		}else {
			msg="존재하지 않는 아이디 입니다.";
		}
		
		request.setAttribute("msg",msg);
		
		return url;
	}

}
