package com.java.filter;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


public class NullParameterFilter implements Filter {
	
	private String[] parameterNames = null;
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
				
		NullParameterRequestWrapper requestWrapper = 
	            new NullParameterRequestWrapper((HttpServletRequest) request);
	        requestWrapper.checkNull(parameterNames);
		
		chain.doFilter(requestWrapper, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		String names = fConfig.getInitParameter("names");
		StringTokenizer st = new StringTokenizer(names, ",");
		
		parameterNames = new String[st.countTokens()];
		
		for (int i = 0; st.hasMoreTokens(); i++) {
            parameterNames[i] = st.nextToken();
        }

		
	}
	public void destroy() {}
	

}
