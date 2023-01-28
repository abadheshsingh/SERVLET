package ser.p1.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class First
 */
@WebServlet("/First")
public class First extends HttpServlet {
	public ServletConfig config;
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		System.out.println("Servlet initialised.");
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.print("<p>Hello Simple Servlet.</p>");
		out.print("</body></html>");
	}

	@Override
	public void destroy() {
		System.out.println("destroy web container.");
	}
	
	@Override
	public ServletConfig getServletConfig() {
		return config;
	}
	@Override
	public String getServletInfo() {
		return "Copyright";
	}
}
