package crud.p1.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String sid = req.getParameter("id");
		int id = Integer.parseInt(sid);
		
		Employee emp = EmployeeDao.getEmployeeById(id);
		
		out.print("<h1>Update Existing Employee</h1>");
		out.print("<form action='UpdateServlet' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='id'value='"+emp.getId()+"'/></td></tr>");
		out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+emp.getName()+"'/></td></tr>");
		out.print("<tr><td>Password:</td><td><input type='password' name='password' value='"+emp.getPassword()+"'/></td></tr>");
		out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+emp.getEmail()+"'/></td></tr>");
		out.print("<tr><td>Country:</td><td>  \r\n"
				+ "<select name='country' style='width:150px'>  \r\n"
				+ "<option>India</option>  \r\n"
				+ "<option>USA</option>  \r\n"
				+ "<option>UK</option>  \r\n"
				+ "<option>Other</option>  \r\n"
				+ "</select>  \r\n"
				+ "</td></tr>  \r\n"
				+ "<tr><td colspan='2'><input type='submit' value='Edit & Save'/></td></tr>  \r\n"
				+ "</table>  \r\n"
				+ "</form> ");
		
	}
}
