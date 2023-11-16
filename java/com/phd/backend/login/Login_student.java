package com.phd.backend.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login_student")
public class Login_student extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login_student() {
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
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/phd_dashboard","root","root");
			PreparedStatement ps=con.prepareStatement("select * from student_redg where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				HttpSession session=request.getSession();
				session.setAttribute("name", rs.getString("fname"));
				session.setAttribute("uname", rs.getString("uname"));
				session.setAttribute("email", rs.getString("email"));
				session.setAttribute("phno", rs.getString("phno"));
				session.setAttribute("branch",rs.getString("branch"));
				session.setAttribute("dt_en", rs.getString("date"));
				session.setAttribute("gender", rs.getString("gender"));
				
				RequestDispatcher rd=request.getRequestDispatcher("/Student_profile.jsp");
				rd.include(request, response);
				
				
			}else {
				response.setContentType("text/html");
				out.print("<h3> Email id And password  did not match</h3>");
				RequestDispatcher rd=request.getRequestDispatcher("/Login_student.jsp");
				rd.include(request, response);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setContentType("text/html");
			out.print("<h3> "+e.getMessage()+"</h3>");
			RequestDispatcher rd=request.getRequestDispatcher("/Student-redg.html");
			rd.include(request, response);
		}
		
	}

}
