

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
 * Servlet implementation class Course_thesis
 */
@WebServlet("/Course_thesis")
public class Course_thesis extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Course_thesis() {
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
		String roll=request.getParameter("roll");
		String email=request.getParameter("email");
		String file=request.getParameter("file");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/phd_dashboard","root","root");
			PreparedStatement ps=con.prepareStatement("insert into thesis values(?,?,?)");
			ps.setString(1, roll);
			ps.setString(2, email);
			ps.setString(3, file);
			
			
			int c=ps.executeUpdate();
			if(c>0) {
				response.setContentType("text/html");
				out.print("<h3> Data insertion successful</h3>");
				//RequestDispatcher rd=request.getRequestDispatcher("/Normal_user_profile.jsp");
				//rd.include(request, response);
				
				
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
