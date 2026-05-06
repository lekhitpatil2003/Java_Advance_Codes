package com;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ServletTwo
 */
//@WebServlet("/ServletTwo")
public class ServletTwo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTwo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("test/html");
		PrintWriter pw = response.getWriter();
		
		ServletConfig config = getServletConfig();
		String n = config.getInitParameter("driver");
		String s = config.getInitParameter("setting");
		pw.print("Your Init Parameter is : " +n+ " " +s);
		
		ServletContext context = getServletContext();
		String p = context.getInitParameter("Project");
		pw.print("Your context Parameter is : " + p);	
		
		pw.close();
	}

}
