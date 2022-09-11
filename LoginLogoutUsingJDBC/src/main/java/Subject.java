

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
 * Servlet implementation class Homepage
 */
public class Subject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Subject() {
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
		DBConnection con=new DBConnection();
		PreparedStatement stmt=null;
		out.println("<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<style>\r\n" + "body {\r\n"
				+ "	font-family: Geneva, Arial, Helvetica, sans-serif;\r\n"
				+ "	background-image: url(\"download.jpeg\");\r\n" + "	background-color: #F0EEEE;\r\n"
				+ "	margin: 0px;\r\n" + "	padding: 0px;\r\n" + "}\r\n" + "\r\n" + "ul {\r\n" + "	margin: 0px;\r\n"
				+ "	padding: 20px;\r\n" + "	margin-top: 0px;\r\n" + "	margin-left: 0px;\r\n"
				+ "	background-color: #0080FF;\r\n" + "}\r\n" + "\r\n" + "li {\r\n" + "	display: inline;\r\n" + "}\r\n"
				+ "\r\n" + "a {\r\n" + "	text-decoration: none;\r\n" + "	padding: 10px;\r\n" + "	margin: 0px;\r\n"
				+ "	color: white;\r\n" + "	font-size: 20px;\r\n" + "	font-weight: bold;\r\n" + "}\r\n" + "\r\n"
				+ ".butt {\r\n" + "	display: inline-block;\r\n" + "	width: 150px;\r\n" + "	border-radius: 7px;\r\n"
				+ "	margin: 0px;\r\n" + "	margin-top: 60px;\r\n" + "	margin-left: 200px;\r\n"
				+ "	box-sizing: border-box;\r\n" + "	background-color: #0080FF;\r\n" + "	color: white;\r\n"
				+ "	height: 40px;\r\n" + "	border: 0px;\r\n" + "	font-size: 17px;\r\n" + "	font-weight: bold;\r\n"
				+ "}\r\n" + "</style>\r\n" + "</head>\r\n" + "<body>\r\n" + "	<ul>\r\n"
				+ "	    <li> <a href=\"Homepage\"><img src=\"C:\\Users\\RIFKAN MA\\Downloads\\images.jpg\" alt=\"Logo\"\r\n"
				+ "		style=\"width: 42px; height: 42px;\"></a></li>\r\n"
				+ "		<li><a href=\"Homepage\">Classes</a></li>\r\n"
				+ "		<li><a href=\"Student\">Students</a></li>\r\n"
				+ "		<li><a href=\"Subject\">Subjects</a></li>\r\n"
				+ "		<li><a href=\"Teacher\">Teachers</a></li>\r\n <li><a href=\"index.html\">Logout</a></li>" + "	</ul>\r\n"
				+ "	<form action=\"AddSubject.jsp\" method=\"post\">\r\n"
				+ "		<input class=\"butt\" type=\"submit\" value=\"Add New Subject\">\r\n" + "	</form>\r\n"
				+ "</body>\r\n" + "</html>");
		
		try {
			connection = con.Dbconnect();
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			 stmt=connection.prepareStatement("select * from Subjects");
			 ResultSet rs=stmt.executeQuery();
			 out.println("<!DOCTYPE html>\r\n"
			 		+ "<html>\r\n"
			 		+ "<head>\r\n"
			 		+ "<meta charset=\"ISO-8859-1\">\r\n"
			 		+ "<title>Leaners Academy</title>\r\n"
			 		+ "<style>\r\n"
			 		+ "   table, td, th {\r\n"
			 		+ "  border-bottom: 1px solid rgb(184,184,184);\r\n"
			 		+ "}\r\n"
			 		+ "th{\r\n"
			 		+ "    background-color: #0080FF;\r\n"
			 		+ "    color: white;\r\n"
			 		+ "    height: 30px;\r\n"
			 		+ "}\r\n"
			 		+ "\r\n"
			 		+ "table {\r\n"
			 		+ "  border-collapse: collapse;\r\n"
			 		+ "  margin-left: 205px;\r\n"
			 		+ "  margin-top: 40px;\r\n"
			 		+ "  width: 50%;\r\n"
			 		+ "}\r\n"
			 		+ "tr:nth-child(even) {background-color: #f2f2f2;}\r\n"
			 		+ "tr{\r\n"
			 		+ "    height: 30px;\r\n"
			 		+ "}\r\n"
			 		+ "\r\n"
			 		+ "td {\r\n"
			 		+ "  text-align: center;\r\n"
			 		+ "}\r\n"
			 		+ "\r\n"
			 		+".link{\r\n"
			 		+ " color: #0080FF;\r\n"
			 		+"font-size: 15px;text-align: left; text-decoration: underline; "
			 		+ "}"
			 		+ "\r\n"
			 		+ "</style>\r\n"
			 		+ "</head>\r\n"
			 		+ "<body>\r\n"
			 		+ "<table>\r\n"
			 		+ "<tr>\r\n"
			 		+ " <th>ID </th>\r\n"
			 		+ " <th>Subject</th><th>Action</th><th>Action</th>\r\n"
			 		+ " </tr>\r\n"
			 		+ " ");

			while(rs.next()) {
				
				String s1=rs.getString(1);
			    String s2=rs.getString(2);
			    out.println("<tr><td>" + s1 + "</td><td>" + s2 + "</td><td><a class=\"link\" href=\"EditSubject.jsp?id="+s1+"\">Edit </a></td><td><a class=\"link\" href=\"SubjectDeleteconfirmatoin.jsp?id="+s1+"\">Delete</a></td> </tr>"); 
			
			}
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		out.println("</table></body></html>");
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
