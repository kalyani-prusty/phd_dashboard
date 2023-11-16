package com.phd.backend.profile;

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
 * Servlet implementation class Report_out_by_stud
 */
@WebServlet("/Report_out_by_stud")
public class Report_out_by_stud extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Report_out_by_stud() {
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
		String branch=request.getParameter("branch");
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/phd_dashboard","root","root");
			PreparedStatement ps=con.prepareStatement("select * from fa_in_report where email=? and branch=?");
			ps.setString(1, email);
			ps.setString(2, branch);
			
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				HttpSession session=request.getSession();
				session.setAttribute("brname", rs.getString("branch"));
				session.setAttribute("email", rs.getString("email"));
				session.setAttribute("total_mark", rs.getString("tot_mark"));
				session.setAttribute("cgpa", rs.getString("cgpa"));
				session.setAttribute("grades", rs.getString("grade"));
				
				
				response.setContentType("text/html");
				//out.print("<h3> Data insertion successful</h3>");
				RequestDispatcher rd=request.getRequestDispatcher("/Report_by_student.jsp");
				rd.include(request, response);
				
				
			}else {
				response.setContentType("text/html");
				out.print("<h3> Data insertion failed</h3>");
				//RequestDispatcher rd=request.getRequestDispatcher("/Login_normal_user.jsp");
				//rd.include(request, response);
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setContentType("text/html");
			out.print("<h3> "+e.getMessage()+"</h3>");
			RequestDispatcher rd=request.getRequestDispatcher("/Normal_user-redg.html");
			rd.include(request, response);
		}
		
	}

}
