package com.soudip.webapp.utils;

import java.sql.Connection;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.soudip.webapp.beans.UserAccount;

public class WebUtils
{
   public static final String ATT_NAME_CONNECTION = "CONNECTION";
   public static final String ATT_NAME_USERNAME = "USERNAME";

   public static void storeConnection(ServletRequest request, Connection conn)
   {
      request.setAttribute(ATT_NAME_CONNECTION, conn);
   }

   // Get the Connection object has been stored in attribute of the request.
   public static Connection getStoredConnection(ServletRequest request)
   {
      Connection conn = (Connection) request.getAttribute(ATT_NAME_CONNECTION);
      return conn;
   }

   // Store user info in Session.
   public static void storeLoginedUser(HttpSession session, UserAccount loginedUser)
   {
      // On the JSP can access via ${loginedUser}
      session.setAttribute("loginedUser", loginedUser);
   }

   // Get the user information stored in the session.
   public static UserAccount getLoginedUser(HttpSession session)
   {
      UserAccount loginedUser = (UserAccount) session.getAttribute("loginedUser");
      return loginedUser;
   }

   // Store info in Cookie
   public static void storeUserCookie(HttpServletResponse response, UserAccount user)
   {
      System.out.println("Store user cookie");
      Cookie cookieUserName = new Cookie(ATT_NAME_USERNAME, user.getUserName());
      // 1 day (Converted to seconds)
      cookieUserName.setMaxAge(2 * 60 * 60);
      response.addCookie(cookieUserName);
   }

   public static String getUserNameInCookie(HttpServletRequest request)
   {
      Cookie[] cookies = request.getCookies();
      if (cookies != null)
      {
         for (Cookie cookie : cookies)
         {
            if (ATT_NAME_USERNAME.equals(cookie.getName()))
            {
               return cookie.getValue();
            }
         }
      }
      return null;
   }
   
   // Delete cookie.
   public static void deleteUserCookie(HttpServletResponse response) {
       Cookie cookieUserName = new Cookie(ATT_NAME_USERNAME, null);
       // 0 seconds (This cookie will expire immediately)
       cookieUserName.setMaxAge(0);
       response.addCookie(cookieUserName);
   }
}
