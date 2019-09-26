package com.bv.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public WelcomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out=response.getWriter();
		String username=request.getParameter("username");
		out.print("<h1>Login SuccessFully!!!<h1>");
		out.print("Hello"+username);
		ServletConfig config=getServletConfig();
		String paramName=config.getInitParameter("x");
		out.print("<p>Config Param : </p>"+paramName);
		
		ServletContext context=getServletContext();
		String ctx=context.getInitParameter("contextParameter");
		out.print("Context Param value:"+ctx);
		out.print("<a href='ThirdServlet'>Third Servlet</a>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
