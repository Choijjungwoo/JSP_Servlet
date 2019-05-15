package com.java.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.java.source.OracleDBCP2DataSource;


public class DBCP2InitServlet extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		
		String driverClassName=config.getInitParameter("driverClassName");
		String url=config.getInitParameter("url");
		String username=config.getInitParameter("username");
		String password=config.getInitParameter("password");
		
		OracleDBCP2DataSource dataSource=OracleDBCP2DataSource.getInstance();
		
		dataSource.setDataSource(driverClassName, url, username, password);
		
		System.out.println("DBCP2 DataSource loading is success!!");
	}
	
	
	
}
