package com.soudip.webapp.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.soudip.webapp.beans.UserAccount;
import com.soudip.webapp.utils.DBUtils;
import com.soudip.webapp.utils.WebUtils;

@WebFilter(filterName = "cookieFilter", urlPatterns = { "/*" })
public class CookieFilter implements Filter
{
   @Override
   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException
   {
      HttpServletRequest req = (HttpServletRequest) request;
      HttpSession session = req.getSession();

      UserAccount userInSession = WebUtils.getLoginedUser(session);
      //
      if (userInSession != null)
      {
         session.setAttribute("COOKIE_CHECKED", "CHECKED");
         chain.doFilter(request, response);
         return;
      }

      // Connection was created in JDBCFilter.
      Connection conn = WebUtils.getStoredConnection(request);

      // Flag check cookie
      String checked = (String) session.getAttribute("COOKIE_CHECKED");
      if (checked == null && conn != null)
      {
         String userName = WebUtils.getUserNameInCookie(req);
         try
         {
            UserAccount user = DBUtils.findUser(conn, userName);
            WebUtils.storeLoginedUser(session, user);
         }
         catch (SQLException e)
         {
            e.printStackTrace();
         }
         // Mark checked Cookies.
         session.setAttribute("COOKIE_CHECKED", "CHECKED");
      }

      chain.doFilter(request, response);
   }

   @Override
   public void destroy()
   {

   }

   @Override
   public void init(FilterConfig arg0) throws ServletException
   {

   }
}
