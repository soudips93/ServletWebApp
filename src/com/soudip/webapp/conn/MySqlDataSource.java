package com.soudip.webapp.conn;

import java.beans.PropertyVetoException;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.sql.Connection;

public class MySqlDataSource
{
   private static ComboPooledDataSource cpds = new ComboPooledDataSource();

   static
   {
      try
      {
         cpds.setDriverClass(PropertiesContainer.getProperties().getProperty("DB.DRIVER"));
         cpds.setJdbcUrl(PropertiesContainer.getProperties().getProperty("DB.URL"));
         cpds.setUser(PropertiesContainer.getProperties().getProperty("DB.USERNAME"));
         cpds.setPassword(PropertiesContainer.getProperties().getProperty("DB.PASSWD"));
         cpds.setMaxIdleTime(Integer.parseInt(PropertiesContainer.getProperties().getProperty("DB.MAXIDLETIME")));
         cpds.setMaxPoolSize(Integer.parseInt(PropertiesContainer.getProperties().getProperty("DB.MAXPOOLSIZE")));
         cpds.setMaxStatements(Integer.parseInt(PropertiesContainer.getProperties().getProperty("DB.MAXSTMTS")));
         cpds.setMinPoolSize(Integer.parseInt(PropertiesContainer.getProperties().getProperty("DB.MINPOOLSIZE")));
      }
      catch (PropertyVetoException e)
      {
         e.printStackTrace();
      }
   }

   public static Connection getMySqlConnection() throws SQLException
   {
      return cpds.getConnection();
   }

}
