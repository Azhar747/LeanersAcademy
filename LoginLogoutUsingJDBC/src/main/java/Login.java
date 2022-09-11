

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		Connection connection=null;
		PreparedStatement stmt=null;
		String checkuser=null;
		String checkpass=null;
		DBConnection con=new DBConnection();
		StoreUsername s=new StoreUsername();
		s.setUsername(request.getParameter("username"));
		s.setPassword(request.getParameter("password"));
		String uname=s.getUsername();
		String pass=s.getPassword();
		try {
			connection = con.Dbconnect();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			stmt= connection.prepareStatement("select * from Admin where Username=? and Password=?");
			stmt.setString(1, uname);
			stmt.setString(2, pass);
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next()) {
			    checkuser =rs.getString(2);
				checkpass =rs.getString(3);
			}
			
			try {
		

	        if((checkuser.equals(uname)) && (checkpass.equals(pass)))
	        {
	   
	            response.sendRedirect("Homepage");
	        }
	        else 
	        {
	             response.sendRedirect("Logout.html");
	        }
			}catch (NullPointerException e) {
				response.sendRedirect("Logout.html");
				
			}

	        connection.close();  
	      
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
