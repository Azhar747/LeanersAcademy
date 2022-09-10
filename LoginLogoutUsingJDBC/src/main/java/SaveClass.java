

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import ClassesPackage.Classes;

/**
 * Servlet implementation class SaveClass
 */
public class SaveClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		Connection con=null;
		Statement stmt=null;
		DBConnection connect=new DBConnection();
		Classes c=new Classes();
		c.setClassname(name);
		String classname=c.getClassname();
		System.out.println(classname);
		try {
			con=connect.Dbconnect();
			 stmt=con.createStatement();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}try{
			
			if((classname.equals("null")) || (classname.isEmpty())){
				response.sendRedirect("Classnull.html");
					}
			else{
				stmt.executeUpdate("insert into Classes values ('"+classname+"')");
				response.sendRedirect("SavednewClass.html");
				}
			}catch(NullPointerException | SQLException e){
				response.sendRedirect("Classnull.html");
				
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
