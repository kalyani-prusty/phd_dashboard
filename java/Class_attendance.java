

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
 * Servlet implementation class Class_attendance
 */
@WebServlet("/Class_attendance")
public class Class_attendance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Class_attendance() {
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
		String atten=request.getParameter("atten");
		String date=request.getParameter("date");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/phd_dashboard","root","root");
			PreparedStatement ps=con.prepareStatement("insert into attendance values(?,?,?)");
			ps.setString(1, roll);
			ps.setString(2, atten);
			ps.setString(3, date);
			
			
			int c=ps.executeUpdate();
			if(c>0) {
				
				
				response.setContentType("text/html");
				out.print("<h3> attendance updated</h3>");
				

				RequestDispatcher rd=request.getRequestDispatcher("/Staff_class.jsp");
				rd.include(request, response);
				
				
			}else {
				response.setContentType("text/html");
				out.print("<h3> attendance can not updated</h3>");
				RequestDispatcher rd=request.getRequestDispatcher("/Staff_class.jsp");
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
			
		}
	}

}
