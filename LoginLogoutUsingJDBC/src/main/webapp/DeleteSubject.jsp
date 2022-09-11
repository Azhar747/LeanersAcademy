
<%@page import="java.sql.*,java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>





<%  String id=request.getParameter("id");
    System.out.println("id");

try{

    Connection con=null;
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	String url="jdbc:sqlserver://AZHARPC\\SQLEXPRESS2019;database=Learners;integratedSecurity = true";
	String connectionUrl ="jdbc:sqlserver://AZHARPC\\SQLEXPRESS2019;databaseName=Learners" +";encrypt=true;trustServerCertificate=true";;
	//:1433;databaseName=Student;user=sa;password=focus@123" +"encrypt=true;trustServerCertificate=true";
	String username="sa";
	String password="focus@123";
	con=DriverManager.getConnection(connectionUrl,username,password);
	Statement stmt=con.createStatement();
	stmt.executeQuery("delete from Subjects where ID="+id);;

}catch(NullPointerException|SQLException e){
   e.printStackTrace();
}

response.sendRedirect("Subject");
%>






</body>
</html>