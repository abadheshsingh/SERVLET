package crud.p1.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String sid = req.getParameter("id");
		int id = Integer.parseInt(sid);
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String country = req.getParameter("country");
		
		Employee emp = new Employee();
		emp.setId(id);
		emp.setName(name);
		emp.setPassword(password);
		emp.setEmail(email);
		emp.setCountry(country);
	
		int status = EmployeeDao.update(emp);
		if (status > 0) {
			resp.sendRedirect("ViewServlet?page=1");
		} else {
			out.print("Sorry! unable to update record");
		}
		out.close();
	}
}
