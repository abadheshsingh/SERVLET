package ser.p1.com;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoogleSearch extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String name = req.getParameter("search");
		resp.sendRedirect("https://www.google.com/search?q="+name);
	}
}
