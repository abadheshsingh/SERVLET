package ser.p2.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		req.getRequestDispatcher("index3.html").include(req, resp);
		
		Cookie ck = new Cookie("name", "");
		ck.setMaxAge(0);
		resp.addCookie(ck);
		
		out.print("<br><br>You are successfully logged out.");
		
	}
}
