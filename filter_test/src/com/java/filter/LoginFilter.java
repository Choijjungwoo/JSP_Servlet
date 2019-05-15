package com.java.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginFilter implements Filter {

	public void destroy() {}
	public void init(FilterConfig fConfig) throws ServletException {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpReq=(HttpServletRequest)request;
		HttpServletResponse httpResp=(HttpServletResponse)response;
		
		HttpSession session = httpReq.getSession();
		
		String id = (String)session.getAttribute("loginUser");
		
		if(id==null) { // 비로그인 상태
			String url=httpReq.getContextPath()+"/commons/login";
			httpResp.sendRedirect(url);
		}else { //로그인 상태
			chain.doFilter(request, response);
		}	
		
	}


}
