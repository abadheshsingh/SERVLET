package ser.p3.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyContextEvent extends HttpServlet {
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		ServletContext context = getServletContext();
		try {
			Connection connection = (Connection)context.getAttribute("connection");
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM EMP");
			ResultSet resultSet = statement.getResultSet();
			
			while (resultSet.next()) {
				out.print("<br>"+resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getInt(3));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
}
