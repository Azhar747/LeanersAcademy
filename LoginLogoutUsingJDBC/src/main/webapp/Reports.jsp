
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<style>
body {
	font-family: Geneva, Arial, Helvetica, sans-serif;
	background-image: url("download.jpeg");
	background-color: #F0EEEE;
	margin: 0px;
	padding: 0px;
}

ul {
	margin: 0px;
	padding: 20px;
	margin-top: 0px;
	margin-left: 0px;
	background-color: #0080FF;
}

li {
	display: inline;
}

a {
	text-decoration: none;
	padding: 10px;
	margin: 0px;
	color: white;
	font-size: 20px;
	font-weight: bold;
}

.butt {
	display: inline-block;
	width: 150px;
	border-radius: 7px;
	margin: 0px;
	margin-top: 60px;
	margin-left: 200px;
	box-sizing: border-box;
	background-color: #0080FF;
	color: white;
	height: 40px;
	border: 0px;
	font-size: 17px;
	font-weight: bold;
}

.formcss {
	margin: 0px;
	padding: 0px;
	background-color: white;
	border-style: outset;
	border-radius: 9px;
	margin-top: 10px;
}

.input_form {
	text-align: left;
	margin: 500px;
	margin-top: 0px;
	padding: 0;
	height: 500px;
}

.names {
	text-shadow: 2px;
}

.submit {
	width: 100px;
	border-radius: 5px;
	margin: 10px;
	box-sizing: border-box;
	background-color: #0080FF;
	color: white;
	height: 35px;
	border: 0px;
}

.username {
	padding: 12px;
	align: center;
}

.cName {
	font-family: Geneva, Arial, Helvetica, sans-serif;
	font-size: 17px;
	text-align: left;
	font-weight: bold;
	font-family: Geneva, Arial, Helvetica, sans-serif;
	padding: 0px;
	padding-bottom: 10px;
	margin-bottom: 2px;
}

h2 {
	margin-left: 210px;
}

.box {
	height: 25px;
	width: 300px;
}

.selcls {
	margin-bottom: 10px;
	margin-top: 20px;
	font-family: Geneva, Arial, Helvetica, sans-serif;
	font-weight: bolder;
}

.selop {
	margin-bottom: 30px;
	margin-top: 30px;
	font-family: Geneva, Arial, Helvetica, sans-serif;
	font-weight: bolder;
	width: 120px;
}
table, td, th {
			 		   
border-bottom: 1px solid rgb(184,184,184);
			 		 
}
			 		 
th{
background-color: #0080FF;
color: white;
height: 30px;
}
table {
border-collapse: collapse;
 margin-left: 205px;
margin-top: 40px;
width: 50%;
}
tr:nth-child(even) {background-color: #f2f2f2;}
tr{
 height: 30px;
}
			 		 
 td {
 text-align: center;
 }
			
</style>
</head>
<body>
	<ul>
		<li><a href="Homepage.html"><img
				src="C:\Users\RIFKAN MA\Downloads\images.jpg" alt="Logo"
				style="width: 42px; height: 42px;"></a></li>
		<li><a href="Homepage">Classes</a></li>
		<li><a href="Student">Students</a></li>
		<li><a href="Subject">Subjects</a></li>
		<li><a href="Teacher">Teachers</a></li>
	</ul>
	<h2>Class Report</h2>

	<table>
		<tr>
			<th>S.NO</th>
			<th>Subject</th>
			<th>Teacher</th>
		</tr>
	
	<%
	try{
       String id=request.getParameter("id");
	   Connection con=null;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url="jdbc:sqlserver://AZHARPC\\SQLEXPRESS2019;database=Learners;integratedSecurity = true";
		String connectionUrl ="jdbc:sqlserver://AZHARPC\\SQLEXPRESS2019;databaseName=Learners" +";encrypt=true;trustServerCertificate=true";;
		//:1433;databaseName=Student;user=sa;password=focus@123" +"encrypt=true;trustServerCertificate=true";
		String username="sa";
		String password="focus@123";
		con=DriverManager.getConnection(connectionUrl,username,password);
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from Assign where ClassID="+id);
		int i=1;
		while(rs.next()){
	       String s1=rs.getString(2);
	       String s2=rs.getString(3);
	       out.println("<tr><td>" + i + "</td><td>" + s1 + "</td><td>" + s2 + "</td></tr>");
	       i++;
		}
	}catch(Exception e){
		e.printStackTrace();
	}
 %>

	
	
 </table>
  <h2>Student List</h2>
  	<table>
		<tr>
			<th>S.NO</th>
			<th>FirstName</th>
			<th>LastName</th>
			<th>DOB</th>
			<th>Address</th>
		</tr>
	
	<%
	try{
        String id=request.getParameter("id");
	    Connection con=null;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url="jdbc:sqlserver://AZHARPC\\SQLEXPRESS2019;database=Learners;integratedSecurity = true";
		String connectionUrl ="jdbc:sqlserver://AZHARPC\\SQLEXPRESS2019;databaseName=Learners" +";encrypt=true;trustServerCertificate=true";;
		//:1433;databaseName=Student;user=sa;password=focus@123" +"encrypt=true;trustServerCertificate=true";
		String username="sa";
		String password="focus@123";
		con=DriverManager.getConnection(connectionUrl,username,password);
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from Student where ClassID="+id);
		int i=1;
		while(rs.next()){
	       String s1=rs.getString(2);
	       String s2=rs.getString(3);
	       String s3=rs.getString(4);
	       String s4=rs.getString(5);
	       out.println("<tr><td>" + i + "</td><td>" + s1 + "</td><td>" + s2 + "</td><td>" + s3 + "</td><td>" + s4 + "</td></tr>");
	       i++;
		}
	}catch(Exception e){
		e.printStackTrace();
	}
 %>
  </table>
</body>
</html>