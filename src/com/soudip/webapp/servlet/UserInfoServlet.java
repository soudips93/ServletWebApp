package com.soudip.webapp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.soudip.webapp.beans.UserAccount;
import com.soudip.webapp.utils.WebUtils;

/**
 * Servlet implementation class UserInfoServlet
 */
@WebServlet("/userInfo")
public class UserInfoServlet extends HttpServlet
{
   private static final long serialVersionUID = 1L;
   private static final String USER_INFO_VIEW = "/WEB-INF/views/userInfoView.jsp";
   /**
    * @see HttpServlet#HttpServlet()
    */
   public UserInfoServlet()
   {
      super();
      // TODO Auto-generated constructor stub
   }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
   {
      HttpSession session = request.getSession();

      // Check User has logged on
      UserAccount loginedUser = WebUtils.getLoginedUser(session);

      // Not logged in
      if (loginedUser == null)
      {
         // Redirect to login page.
         response.sendRedirect(request.getContextPath() + "/login");
         return;
      }
      // Store info to the request attribute before forwarding.
      request.setAttribute("user", loginedUser);

      // If the user has logged in, then forward to the page
      // /WEB-INF/views/userInfoView.jsp
      RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(USER_INFO_VIEW);
      dispatcher.forward(request, response);
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
   {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

}
