

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
import ClassesPackage.SubjectPojo;

/**
 * Servlet implementation class SaveSubject
 */
public class SaveSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveSubject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		Connection con=null;
		Statement stmt=null;
		DBConnection connect=new DBConnection();
		SubjectPojo p=new SubjectPojo();
		p.setSubjectname(name);
		String ssname=p.getSubjectname();
		System.out.println(ssname);
		try {
			con=connect.Dbconnect();
			 stmt=con.createStatement();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}try{
			
			if((ssname.equals("null")) || (ssname.isEmpty())){
				response.sendRedirect("Subjectnull.html");
					}
			else{
				stmt.executeUpdate("insert into Subjects values ('"+ssname+"')");
				response.sendRedirect("SavednewClass.html");
				}
			}catch(NullPointerException | SQLException e){
				response.sendRedirect("Subjectnull.html");
				
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
