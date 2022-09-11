<%@page import="java.sql.*,java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	margin: 0px;
}

h2 {
	margin-left: 2px;
	font-size: 19px;
}

.box {
	height: 25px;
	width: 300px;
}
.selop{
margin-bottom: 30px;
margin-top: 30px;
font-family: Geneva, Arial, Helvetica, sans-serif;
font-weight: bolder;
width: 120px;

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
	<div>
		<div class="input_form">
			<h2>Assign Subjects and Teachers To <% out.println(request.getParameter("id")) ; %></h2>
			<% String id=request.getParameter("id"); %>
			  <form class=formcss action="SaveAssign?id=<%=id%>" method="post">
			 <div class="username">
						<label class="selcls">Select Teacher :</label>
					<select class="selop" name="TeacherName">
					  <option>Select</option>
		         <%  
		            
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
						ResultSet  rs1=stmt.executeQuery("select * from Teacher");;
						while(rs1.next()){
							%>
							<option><%out.println(rs1.getString(2));%></option>
						<%
						
					
						}
					}catch(Exception e){
						e.printStackTrace();
					}
				
				 %> 

					  
				</select><br>
					<label class="selcls">Select Subject :</label>
				    <select class="selop" name="SubjectName">
					  <option>Select</option>
		         <%  
		            
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
						ResultSet  rs2=stmt.executeQuery("select * from Subjects");;
						while(rs2.next()){
							%>
							<option><%out.println(rs2.getString(2));%></option>
						<%
						
					
						}
					}catch(Exception e){
						e.printStackTrace();
					}
				
				 %> 

					  
				</select><br>	
				
				<input class="submit" type="submit" value="Save">
		</div>
       </form>
       </div>
       </body>
</html>