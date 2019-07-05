package com.soudip.webapp.servletcontextlistener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.soudip.webapp.conn.PropertiesContainer;

public class WebappContextListener implements ServletContextListener
{

   @Override
   public void contextDestroyed(ServletContextEvent arg0)
   {
      System.out.println("DB.URL: " + PropertiesContainer.getProperties().getProperty("DB.URL"));
      System.out.println("DB.MAXIDLETIME: " + PropertiesContainer.getProperties().getProperty("DB.MAXIDLETIME"));
      System.out.println("DB.MINPOOLSIZE: " + PropertiesContainer.getProperties().getProperty("DB.MINPOOLSIZE"));
      System.out.println("DB.MAXSTMTS: " + PropertiesContainer.getProperties().getProperty("DB.MAXSTMTS"));
   }

   @Override
   public void contextInitialized(ServletContextEvent arg0)
   {
      // TODO Auto-generated method stub
      
   }

}
