package jtc.p4.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/addcookie.jtc")
public class AddCookieServlet extends HttpServlet {
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String bookname = req.getParameter("bname");
		
		Cookie cookie = new Cookie(bookname, null);
		resp.addCookie(cookie);
		out.write("<h2>"+bookname);
		Cookie cs[] = req.getCookies();
		if (cs == null) {
			out.write("You are new client");
			HttpSession session = req.getSession();
		} else {
			boolean found = false;
			for (Cookie cookie2 : cs) {
				String cname = cookie2.getName();
				String cvalue = cookie2.getValue();
				out.write(cname+"------------"+cvalue);
				if (cname.equals("JSESSIONID")) {
					found = true;
				}
			}
			if (found) {
				out.write("You are old client.");
			}
		}
		out.print("<hr/>");
		req.getRequestDispatcher("indexjtc22.html").include(req, resp);
	}
}
