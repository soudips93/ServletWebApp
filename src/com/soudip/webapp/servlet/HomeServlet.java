package com.soudip.webapp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/home")
public class HomeServlet extends HttpServlet
{
   private static final long serialVersionUID = 1L;
   private static final String JSP_PATH = "/WEB-INF/views/homeView.jsp";
   
   /**
    * @see HttpServlet#HttpServlet()
    */
   public HomeServlet()
   {
      super();
      // TODO Auto-generated constructor stub
   }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
   {
   // Forward to /WEB-INF/views/homeView.jsp
      // (Users can not access directly into JSP pages placed in WEB-INF)
      RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(JSP_PATH);
       
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
