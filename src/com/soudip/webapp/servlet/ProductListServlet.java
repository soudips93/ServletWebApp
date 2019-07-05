package com.soudip.webapp.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soudip.webapp.beans.Product;
import com.soudip.webapp.utils.DBUtils;
import com.soudip.webapp.utils.WebUtils;

/**
 * Servlet implementation class ProductListServlet
 */
@WebServlet("/productList")
public class ProductListServlet extends HttpServlet
{
   private static final long serialVersionUID = 1L;
   private static final String PRODUCT_LIST_VIEW = "/WEB-INF/views/productListView.jsp";

   /**
    * @see HttpServlet#HttpServlet()
    */
   public ProductListServlet()
   {
      super();
      // TODO Auto-generated constructor stub
   }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
   {
      Connection conn = WebUtils.getStoredConnection(request);

      String errorString = null;
      List<Product> list = null;
      try
      {
         list = DBUtils.queryProduct(conn);
      }
      catch (SQLException e)
      {
         e.printStackTrace();
         errorString = e.getMessage();
      }
      // Store info in request attribute, before forward to views
      request.setAttribute("errorString", errorString);
      request.setAttribute("productList", list);

      // Forward to /WEB-INF/views/productListView.jsp
      RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(PRODUCT_LIST_VIEW);
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
