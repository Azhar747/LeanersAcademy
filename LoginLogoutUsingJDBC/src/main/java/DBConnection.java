import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	public Connection Dbconnect() throws SQLException, ClassNotFoundException {
		Connection con=null;
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url="jdbc:sqlserver://AZHARPC\\SQLEXPRESS2019;database=Learners;integratedSecurity = true";
		String connectionUrl ="jdbc:sqlserver://AZHARPC\\SQLEXPRESS2019;databaseName=Learners" +";encrypt=true;trustServerCertificate=true";;
		//:1433;databaseName=Student;user=sa;password=focus@123" +"encrypt=true;trustServerCertificate=true";
		String username="sa";
		String password="focus@123";
	    con=DriverManager.getConnection(connectionUrl,username,password);
		
		
		return con;
		
		
	}
	

}
