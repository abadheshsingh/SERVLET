package crud.p1.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		out.println("<a href='crudindex.html'>Add New Employee</a>");  
	    out.println("<h1>Employees List</h1>");
	    
	    String spage = req.getParameter("page");
	    int page = Integer.parseInt(spage);
	    int total = 3;
	    
	    if (page == 1) {}
	    else {
			page = page - 1;
			page = page*total + 1;
			total = page + total - 1;
		}
	      
	    List<Employee> employees = EmployeeDao.getAllEmployees(page, total);
	    out.print("<table width='100%' border='1'");
	    out.print("<tr>\r\n"
	    		+ "<th>ID</th>\r\n"
	    		+ "<th>Name</th>\r\n"
	    		+ "<th>Password</th>\r\n"
	    		+ "<th>Email</th>\r\n"
	    		+ "<th>Country</th>\r\n"
	    		+ "<th>Edit</th>\r\n"
	    		+ "<th>Delete</th>\r\n"
	    		+ "</tr>");
	    for (Employee e : employees) {
			out.print("<tr>"
					+ "<td>"+e.getId()+"</td>"
					+ "<td>"+e.getName()+"</td>"
					+ "<td>"+e.getPassword()+"</td>"
					+ "<td>"+e.getEmail()+"</td>"
					+ "<td>"+e.getCountry()+"</td>"
					+ "<td><a href='EditServlet?id="+e.getId()+"'>edit</a></td>"
					+ "<td><a href='DeleteServlet?id="+e.getId()+"'>delete</a></td>"
					+ "</tr>");
		}
	    out.print("</table>");
	    out.print("<a href='ViewServlet?page=1'>1</a> ");  
        out.print("<a href='ViewServlet?page=2'>2</a> ");  
        out.print("<a href='ViewServlet?page=3'>3</a> ");
        out.print("<a href='ViewServlet?page=4'>4</a> ");
        out.print("<a href='ViewServlet?page=5'>5</a> ");
	    out.close();
	}
}
