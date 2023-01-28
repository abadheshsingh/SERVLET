package ser.p1.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class login1 extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String name = req.getParameter("userName");
		String pass = req.getParameter("userPass");
		if (pass.equals("Intell@90")) {
			RequestDispatcher rd = req.getRequestDispatcher("servlet2.jtc");
			rd.forward(req, resp);
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("/index1.html");
			rd.include(req, resp);
		}
	}
}
