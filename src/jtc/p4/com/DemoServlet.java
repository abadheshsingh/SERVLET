package jtc.p4.com;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoServlet extends HttpServlet{
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init()*********************");
		String city = config.getInitParameter("city");
	}
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
