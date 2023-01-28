package jtc.p1.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String firstName = req.getParameter("fname");
		String lastName = req.getParameter("lname");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String gender = req.getParameter("gemder");
		String cardType = req.getParameter("ctype");
		String cardColor = req.getParameter("color");
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>JTC Bookstore</h1>");
		out.print("<h2>Hi '"+firstName+"' '"+lastName+"'. You are registered successfully. </h2>");
		out.println("</body>");		
		out.println("</html>");
	}
}
