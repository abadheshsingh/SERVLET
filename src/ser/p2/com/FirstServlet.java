package ser.p2.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String name = req.getParameter("userName");
		out.print("Welcome: "+name);
		
		Cookie ck = new Cookie("uname", name);
		resp.addCookie(ck);
		
		out.print("<form action='cookie2.jtc'>");
		out.print("<input type=\"submit\" value=\"Go\"/></form>");
		out.close();
	}
}
