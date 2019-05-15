package com.java.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.java.dao.AttachDAO;
import com.java.dao.AttachDAOImpl;
import com.java.service.AttachServiceImpl;

public class InitListener implements ServletContextListener {
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

    public void contextInitialized(ServletContextEvent arg0)  {
    	
    	AttachDAO attachDAO = AttachDAOImpl.getInstance();
    	AttachServiceImpl attachService=AttachServiceImpl.getInstance();
    	
    	attachService.setAttachDAO(attachDAO);
    }
	
}
