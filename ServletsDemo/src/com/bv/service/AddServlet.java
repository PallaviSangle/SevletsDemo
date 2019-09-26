package com.bv.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
//import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bv.handler.ProductDBHandler;
import com.bv.model.Products;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String productname=request.getParameter("productname");
		String manufacturername=request.getParameter("manufacturername");
		String price=request.getParameter("price");
		String man_date=request.getParameter("manufacturerDate");
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
        
		java.util.Date udob = null;
		try {
			udob= sdf1.parse(man_date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
		
		Products products=new Products();
		products.setProductname(productname);
		products.setManufacturername(manufacturername);
		products.setPrice(Double.parseDouble(price));
		 java.sql.Date sqdob = new java.sql.Date(udob.getTime());
	        products.setManufacturerDate(sqdob);
		

		int status=ProductDBHandler.addProducts(products);
		
		
		if(status>0)
		{
			out.print("<h2>REcords inserted successfully!!!!!<h2>");
			
		}
		
		else
		{
			out.print("Error in inserting the records");
		}
		
		out.print("<a href='ViewProducts.jsp'>View Products</a>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
