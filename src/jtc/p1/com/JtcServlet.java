package jtc.p1.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class JtcServlet extends HttpServlet {
	String state, country, email, phone;
	@Override
	public void init(ServletConfig config) throws ServletException {
		email = config.getInitParameter("email");
		phone = config.getInitParameter("phone");
		
		ServletContext ctx = config.getServletContext();
		state = ctx.getInitParameter("state");
		country = ctx.getInitParameter("country");
	}
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String name = req.getParameter("username");
		
		out.print("<h1>Username: </h1>"+name);
		out.print("<h1>Phone: </h1>"+phone);
		out.print("<h1>Email: </h1>"+email);
		out.print("<h1>State: </h1>"+state);
		out.print("<h1>Country: </h1>"+country);
	}
	@Override
	public void destroy() {
	
	}
}
