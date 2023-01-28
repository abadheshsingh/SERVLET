package crud.p1.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String country = req.getParameter("country");
		
		Employee employee = new Employee();
		employee.setName(name);
		employee.setPassword(password);
		employee.setEmail(email);
		employee.setCountry(country);		
		
		
		int status = EmployeeDao.save(employee);
		
		if (status > 0) {
			out.print("<p>Record saved successfully.</p>");
			req.getRequestDispatcher("crudindex.html").include(req, resp);
		} else {
			out.print("</p> Sorry! unable to save record.</p>");
		}
	}
}
