package com.java.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class TestListener implements ServletContextListener {

	
	public void contextInitialized(ServletContextEvent sce)  { 
		
		ServletContext context=sce.getServletContext();
		String name=context.getInitParameter("name");
		System.out.println("context Listener loading : "+name);
	}

    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }
	
}
