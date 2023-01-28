package ser.p1.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AttributeScope1 extends HttpServlet {
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		ServletContext sct = getServletContext();
		sct.setAttribute("name", "Abadhesh Kumar");
		pw.print("Welcome to first attribute servlet");
		pw.print("<a href='attribute2.jtc'>Visit</a>");
		pw.close();
		
	}
}
