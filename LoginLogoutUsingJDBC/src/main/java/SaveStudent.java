
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ClassesPackage.AddStudent;
import ClassesPackage.Classes;

/**
 * Servlet implementation class SaveStudent
 */
public class SaveStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveStudent() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection con=null;
		Statement stmt = null;
		DBConnection connect=new DBConnection();
	try {	
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String dob=request.getParameter("dob");
		String add=request.getParameter("add");
		String classname=request.getParameter("classname");
		AddStudent s=new AddStudent();
		s.setFirstname(firstname);
		s.setLastname(lastname);
		s.setDob(dob);
		s.setAdd(add);
		s.setClassname(classname);
		String fstname=s.getFirstname();
		String lstname=s.getLastname();
		String dateob=s.getDob();
		String addess=s.getAdd();
		String classnme=s.getClassname();
		System.out.println(dateob);
		System.out.println(fstname);
		System.out.println(lstname);
		System.out.println(addess);
		System.out.println(classnme);
		con=connect.Dbconnect();
		 stmt=con.createStatement();
		 
		
		if (fstname.equals("null") || lstname.equals("null")|| dateob.equals("null")|| addess.equals("null") || classnme.equals("null")||fstname.isEmpty() || lstname.isEmpty()|| dateob.isEmpty()|| addess.isEmpty() ||classnme.isEmpty() ) {
			response.sendRedirect("Studentnull.jsp");
		}else {
			ResultSet rs  =stmt.executeQuery("select ID from Classes where Class_Name='"+classnme+"'");
			int classid = 0;
			while(rs.next()) {
			classid=rs.getInt(1);
			}
			stmt.executeUpdate("insert into Student values('"+fstname+"','"+lstname+"','"+dateob+"','"+addess+"','"+classid+"','"+classnme+"')");
			response.sendRedirect("SavednewClass.html");
			}
	}
	catch ( NullPointerException e) {
			// TODO Auto-generated catch block
		e.printStackTrace();
		response.sendRedirect("Studentnull.jsp");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
