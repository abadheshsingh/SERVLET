package crud.p1.com;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import JDBCUtil.com.JdbcUtility;

public class EmployeeDao {
	
	
	public static int save(Employee employee) {
		int status = 0;
	
		try {
			Connection con = JdbcUtility.getOracleConnection();
			PreparedStatement ps = con.prepareStatement("INSERT INTO USER905(NAME, PASSWORD, EMAIL, COUNTRY) VALUES(?, ?, ?, ?)");
			ps.setString(1, employee.getName());
			ps.setString(2, employee.getPassword());
			ps.setString(3, employee.getEmail());
			ps.setString(4, employee.getCountry());
			
			status = ps.executeUpdate();
			JdbcUtility.cleapup(ps, con);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public static int update(Employee emp) {
		int status = 0;
		
		try {
			Connection con = JdbcUtility.getOracleConnection();
			PreparedStatement ps = con.prepareStatement("UPDATE USER905 SET NAME = ?, PASSWORD = ? , EMAIL = ?, COUNTRY = ? WHERE ID = ?");
			ps.setString(1, emp.getName());
			ps.setString(2, emp.getPassword());
			ps.setString(3, emp.getEmail());
			ps.setString(4, emp.getCountry());
			ps.setInt(5, emp.getId());
			
			status = ps.executeUpdate();
			JdbcUtility.cleapup(ps, con);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return status;		
	}
	
	public static void delete(int id) {
		try {
			Connection con = JdbcUtility.getOracleConnection();
			PreparedStatement ps = con.prepareStatement("DELETE FROM USER905 WHERE ID = ?");
			ps.setInt(1, id);
			
			
			ps.executeUpdate();
			JdbcUtility.cleapup(ps, con);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Employee getEmployeeById(int id) {
		Employee employee = new Employee();
		try {
			Connection con = JdbcUtility.getOracleConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM USER905 WHERE ID = ?");
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				employee.setId(rs.getInt(1));
				employee.setName(rs.getString(2));
				employee.setPassword(rs.getString(3));
				employee.setEmail(rs.getString(4));
				employee.setCountry(rs.getString(5));
			}
			JdbcUtility.cleapup(ps, con);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return employee;
	}
	
	public static List<Employee> getAllEmployees(int start, int end) {
		List<Employee> list = new ArrayList<Employee>();
		
		try {
			Connection con = JdbcUtility.getOracleConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM (SELECT USER9051.*, ROWNUM RNUM FROM (SELECT * FROM USER905 ORDER BY ID) USER9051 WHERE ROWNUM <= '"+end+"') WHERE RNUM >= '"+start+"'");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Employee employee = new Employee();
				employee.setId(rs.getInt(1));
				employee.setName(rs.getString(2));
				employee.setPassword(rs.getString(3));
				employee.setEmail(rs.getString(4));
				employee.setCountry(rs.getString(5));
				
				list.add(employee);
			}
			JdbcUtility.cleapup(ps, con);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static int[] get_Min_Max_Id() {
		int id[] = new int[2];
		try {
			Connection con = JdbcUtility.getOracleConnection();
			PreparedStatement ps = con.prepareStatement("SELECT MIN(ID), MAX(ID) FROM USER905");
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				id[0] = rs.getInt(1);
				id[1] = rs.getInt(2);
			}
			
			JdbcUtility.cleapup(ps, con);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return id;
	}
}
