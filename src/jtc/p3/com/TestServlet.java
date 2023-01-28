package jtc.p3.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jtc14.jtc")
public class TestServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String name = req.getParameter("uname");
		String password = req.getParameter("password");
		
		out.println("<h1>Username: '"+name+"'</h1>");
		out.println("<br><h1>Password: "+password+"</h1>");
		
		Enumeration e = req.getHeaderNames();
		while (e.hasMoreElements()) {
			String hn = e.nextElement().toString();
			String hv = req.getHeader(hn);
			out.println("<br>"+hn+"<======>"+hv);
		}
		out.println("<hr/>");
		out.println("<br>req.getLocale(): "+req.getLocale());
		out.println("<br>request method: "+req.getMethod());
		out.println("<br> URI: "+req.getRequestURI());
		out.println("<br> URL: "+req.getRequestURL());
		out.println("<br> PROTOCOL: "+req.getProtocol());
		out.println("<br> Content Length: "+req.getContentLength());
		out.println("<br> Content type: "+req.getContentType());
		out.println("<br> req.getRemoteAddr(): "+req.getRemoteAddr());
		out.println("<br> req.getRemoteHost(): "+req.getRemoteHost());
		out.println("<br> req.getRemotePort(): "+req.getRemotePort());
		out.println("<br> req.getRemoteUser(): "+req.getRemoteUser());
		out.println("<br> req.getServerName(): "+req.getServerName());
		out.println("<br> req.getServerPort(): "+req.getServerPort());
		out.println("<br> req.getServletPath(): "+req.getServletPath());
		out.println("<br> req.getServletContext(): "+req.getServletContext());
		out.println("<br> req.getQueryString(): "+req.getQueryString());
		out.println("<br> req.getContextPath(): "+req.getContextPath());
	}
}
