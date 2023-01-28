package ser.p1.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfig1 extends HttpServlet {
	
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter ps = resp.getWriter();
		ServletConfig sc = getServletConfig();
		String driver = sc .getInitParameter("driver");
		ps.print("Driver provided by: "+driver);
		
		Enumeration<String> en= sc.getInitParameterNames();
		String str = null;
		while (en.hasMoreElements()) {
			str = (String) en.nextElement();
			ps.print("<br> Name: "+str);
			ps.print("  Value: "+sc.getInitParameter(str));
		}
		ps.close();
	}
}
