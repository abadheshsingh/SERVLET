package ser.p1.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContext1 extends HttpServlet {
//	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		resp.setContentType("text/html");
//		PrintWriter pw = resp.getWriter();
//		
//		ServletConfig sc = getServletConfig();
//		ServletContext sct = sc.getServletContext();
//		String name = sct.getInitParameter("drivername");
//		pw.print("Driver provided by: "+name);
//		pw.close();
//	}
	
	/*
	 * ServletConfig config;
	 * 
	 * @Override public void init(ServletConfig config) throws ServletException {
	 * this.config = config; } public void service(HttpServletRequest req,
	 * HttpServletResponse res) throws ServletException, IOException {
	 * res.setContentType("text/html"); PrintWriter pw = res.getWriter(); String
	 * name = config.getServletContext().getInitParameter("drivername");
	 * pw.print("Driver given by: "+name); pw.close(); }
	 */
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		ServletContext sct = getServletContext();
		String name = sct.getInitParameter("drivername");
		pw.print("Driver : "+name);
	}
}
