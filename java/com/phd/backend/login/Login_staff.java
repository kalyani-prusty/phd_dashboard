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
 * Servlet implementation class Login_staff
 */
@WebServlet("/Login_staff")
public class Login_staff extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login_staff() {
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
			PreparedStatement ps=con.prepareStatement("select * from faculty_redg where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				HttpSession session=request.getSession();
				session.setAttribute("a_name", rs.getString("fname"));
				session.setAttribute("a_uname", rs.getString("uname"));
				session.setAttribute("a_email", rs.getString("email"));
				session.setAttribute("a_phno", rs.getString("phno"));
				session.setAttribute("a_id_no", rs.getString("id_f"));
				session.setAttribute("a_asgn_branch", rs.getString("branch_f"));
				session.setAttribute("a_branch_id", rs.getString("branch_id_f"));
				session.setAttribute("a_dt_jn", rs.getString("date"));
				session.setAttribute("a_gender", rs.getString("gender"));

				RequestDispatcher rd=request.getRequestDispatcher("/Staff_profile.jsp");
				rd.include(request, response);
				
				
			}else {
				response.setContentType("text/html");
				out.print("<h3> Email id And password  did not match</h3>");
				RequestDispatcher rd=request.getRequestDispatcher("/Login_staff.jsp");
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
			RequestDispatcher rd=request.getRequestDispatcher("/Staff-redg.html");
			rd.include(request, response);
		}
		

	}

}
