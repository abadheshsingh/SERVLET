package ser.p2.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		
		
		String name = req.getParameter("username");
		String pass = req.getParameter("password");
		
		if (pass.equals("Admin@12345")) {
			req.getRequestDispatcher("links1.html").include(req, resp);
			out.print("<br><br>You are successfully logged in.");
			out.print("<br><br> Welcome "+name);
			Cookie ck = new Cookie("name", name);
			resp.addCookie(ck);
		} else {
			out.print("<br><br>Sorry, username or password is incorrect.");
			req.getRequestDispatcher("login.html").include(req, resp);
		}
	
	}
}
