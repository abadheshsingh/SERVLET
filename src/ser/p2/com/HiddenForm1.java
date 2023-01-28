package ser.p2.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HiddenForm1 extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String name1 = req.getParameter("username");
		out.print("Welcome "+name1);
		
		out.print("<form action='hiddenform2.jtc'>");
		out.print("<input type='hidden' name='uname' value='"+name1+"'><br><br>");
		out.print("<input type='submit' value='GO1'>");
		out.print("</form>");
		
		  
		out.close();
	}
}
