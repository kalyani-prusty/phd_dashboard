package com.phd.backend.reg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register_normal_user
 */
@WebServlet("/Register_normal_user")
public class Register_normal_user extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register_normal_user() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter out=response.getWriter();
		String name=request.getParameter("fname");
		String uname=request.getParameter("uname");
		String email=request.getParameter("email");
		String ph_no=request.getParameter("phno");
		String password=request.getParameter("Password");
		String c_password=request.getParameter("c_Password");
		String gender=request.getParameter("gender");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/phd_dashboard","root","root");
			PreparedStatement ps=con.prepareStatement("insert into normal_user_redg values(?,?,?,?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2, uname);
			ps.setString(3, email);
			ps.setString(4, ph_no);
			ps.setString(5, password);
			ps.setString(6, c_password);
			ps.setString(7, gender);
			
			int c=ps.executeUpdate();
			if(c>0) {
				response.setContentType("text/html");
				out.print("<h3> user  Registered Successfully</h3>");
				RequestDispatcher rd=request.getRequestDispatcher("/Login.jsp");
				rd.include(request, response);
				
			}
			else {
				response.setContentType("text/html");
				out.print("<h3> user Not Registered Due to some ERROR</h3>");
				RequestDispatcher rd=request.getRequestDispatcher("/Login.jsp");
				rd.include(request, response);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setContentType("text/html");
			out.print("<h3> user Not Registered Due to some ERROR like"+e.getMessage()+"</h3>");
			RequestDispatcher rd=request.getRequestDispatcher("/Normal_user-redg.html");
			rd.include(request, response);
		}
		
	}

	

}
