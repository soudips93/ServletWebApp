package com.soudip.webapp.conn;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesContainer
{
   private static Properties properties;
   private static final String KEY_PROPERTIES_FILE_PATH = "/config/config.properties";

   public static synchronized Properties getProperties()
   {
      if (properties != null)
         return properties;
      InputStream inputStream = null;
      try
      {
         System.out.println("Class path: " + PropertiesContainer.class.getResource("/config/config.properties"));
         inputStream = PropertiesContainer.class.getResourceAsStream(KEY_PROPERTIES_FILE_PATH);
         properties = new Properties();
         properties.load(inputStream);
         inputStream.close();
         System.out.println("Properties: " + properties.toString());
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }
      return properties;
   }
}
