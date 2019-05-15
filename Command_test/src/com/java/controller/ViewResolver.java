package com.java.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewResolver {
	public static void view(HttpServletRequest request, 
						    HttpServletResponse response, 
						    String url)
						    	throws ServletException, IOException {

		if (url.contains("redirect:")) {
			url = url.replace("redirect:", "");
			response.sendRedirect(url);
		} else {			
		request.getRequestDispatcher(url).forward(request, response);
		}
	}
}
