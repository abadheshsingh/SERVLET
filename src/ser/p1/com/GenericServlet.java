package ser.p1.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class GenericServlet
 */
@WebServlet("/GenericServlet")
public class GenericServlet extends javax.servlet.GenericServlet {
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.print("<html><body>");
		out.print("<p> GenericServlet class.</p>");
		out.print("</body></html>");
		
	}

}
