package ser.p3.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyContextListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "abadhesh", "Intell90");
			ServletContext context = sce.getServletContext();
			context.setAttribute("connection", con);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("project undeployed....................");
	}
}
