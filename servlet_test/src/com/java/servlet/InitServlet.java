package com.java.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.sql.DataSource;

import com.java.dao.MemberDAOImpl;
import com.java.service.MemberServiceImpl;
import com.java.source.OracleDBCP2DataSource;


public class InitServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		DataSource dataSource=OracleDBCP2DataSource.getInstance();
		MemberDAOImpl memberDAO=MemberDAOImpl.getInstance();
		MemberServiceImpl memberService=MemberServiceImpl.getInstance();
		
		memberDAO.setDataSource(dataSource);
		memberService.setMemberDAO(memberDAO);
		
		System.out.println("[INFO]비지니스 로직의 조립이 완성되었습니다.");
		
	}
	
	

}




