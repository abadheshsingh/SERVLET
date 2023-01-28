package JDBCUtil.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import crud.p1.com.Employee;
import crud.p1.com.EmployeeDao;

public class JdbcUtility {
	public static Connection getOracleConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "abadhesh", "Intell90");
		return con;
	}
	public static void cleapup(Statement stmt, Connection con){
			try {
				if (stmt != null) 
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}					
	}
//	public static void main(String[] args) {
//		Employee emp = new Employee();
//		emp.setName("Abadhesh Kumar");
//		emp.setPassword("Intell@90");
//		emp.setEmail("kumarabadhesh90@gmail.com");
//		emp.setCountry("USA");
//		
//		int status= EmployeeDao.save(emp);
//		System.out.println("Record inserted..........");
//	}
}