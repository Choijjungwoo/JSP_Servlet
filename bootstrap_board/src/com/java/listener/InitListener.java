package com.java.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;

import com.java.dao.AttachDAO;
import com.java.dao.AttachDAOImpl;
import com.java.dao.BoardDAOImpl;
import com.java.dao.MemberDAO;
import com.java.dao.MemberDAOImpl;
import com.java.dao.MybatisMemberDAOImpl;
import com.java.dao.PageBoardDAO;
import com.java.dao.PageMybatisBoardDAOImpl;
import com.java.dao.PdsDAOImpl;
import com.java.dao.ReplyDAO;
import com.java.dao.ReplyDAOImpl;
import com.java.service.BoardServiceImpl;
import com.java.service.MemberServiceImpl;
import com.java.service.PdsServiceImpl;
import com.java.service.ReplyServiceImpl;
import com.java.source.OracleDBCP2DataSource;
import com.mybatis.sqlSession.OracleMyBatisSqlSession;

public class InitListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent arg0)  { 
		DataSource dataSource=OracleDBCP2DataSource.getInstance();
		
		MemberDAOImpl memberDAO=MemberDAOImpl.getInstance();
		MemberServiceImpl memberService=MemberServiceImpl.getInstance();
		
		MemberDAO mybatisMemberDAO = MybatisMemberDAOImpl.getInstance();
		
		memberDAO.setDataSource(dataSource);
		memberService.setMemberDAO(mybatisMemberDAO);
		
		BoardDAOImpl boardDAO=BoardDAOImpl.getInstance();
		BoardServiceImpl boardService=BoardServiceImpl.getInstance();
		
		
		PageBoardDAO mybatisBoardDAO = PageMybatisBoardDAOImpl.getInstance();
		
		boardDAO.setDataSource(dataSource);
		boardService.setBoardDAO(mybatisBoardDAO);
		
		ReplyDAO replyDAO=ReplyDAOImpl.getInstance();
		ReplyServiceImpl replyService=ReplyServiceImpl.getInstance();
		
		replyService.setReplyDAO(replyDAO);
		boardService.setReplyDAO(replyDAO);
		
		SqlSessionFactory sessionFactory=
		OracleMyBatisSqlSession.getInstance().getSqlSessionFactory();
		
		PdsDAOImpl pdsDAO=PdsDAOImpl.getInstance();		
		PdsServiceImpl pdsService=PdsServiceImpl.getInstance();
		
		pdsDAO.setSqlSessionFactory(sessionFactory);
		pdsService.setPdsDAO(pdsDAO);
		
		AttachDAO attachDAO=AttachDAOImpl.getInstance();
		pdsService.setAttachDAO(attachDAO);
		
		System.out.println("[INFO]비지니스 로직의 조립이 완성되었습니다.");
	}
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	
}
