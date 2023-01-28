package ser.p2.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProfileServlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		req.getRequestDispatcher("links1.html").include(req, resp);
		
		Cookie ck[] = req.getCookies();
		
		if (ck != null) {
			String name = ck[0].getValue();
			if (!name.equals("")||name != null) {
				out.print("<br><br><b>Welcome to Profile Section.");
				out.print("<br><br>Welcome "+name);
			} else {
				out.print("To see profile first you have to login.");
				req.getRequestDispatcher("login.html").include(req, resp);
			}
		}
	}
}
