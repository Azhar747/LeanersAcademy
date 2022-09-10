
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
	margin-left: 2px;
}

.box {
	height: 25px;
	width: 300px;
}
.selcls{
margin-bottom: 10px;
margin-top: 20px;
font-family: Geneva, Arial, Helvetica, sans-serif;
font-weight: bolder;

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
			<h2>Add a Teacher</h2>
			<form class=formcss action="SaveTeacher" method="post">
				<div class="username">
					<h6 class="cName">First Name</h6>
					<input class="box" type="text" name=firstname
						placeholder="Enter the Teacher First Name"> <br>
						<h6 class="cName">Last Name</h6>
					<input class="box" type="text" name=lastname
						placeholder="Enter the Teacher Last Name"> <br>
						<h6 class="cName">DOB</h6>
					<input class="box" type="date" name=dob
						placeholder="Enter the Teacher's Date of Birth"> <br>
						<h6 class="cName">Address</h6>
					<input class="box" type="text" name=add
						placeholder="Enter the Teacher's Address"> <br>
						<h6 class="cName">Phone</h6>
					<input class="box" type="tel" name=phone
						placeholder="Enter the Teacher's Phone"> <br>
		               <h6 class="cName">Designation</h6>
					<input class="box" type="text" name=designation
						placeholder="Enter the Teacher's Designation"> <br>
				<input class="submit" type="submit" value="Save">
		</div>
		</form>
		</div>
        </div>
</body>
</html>