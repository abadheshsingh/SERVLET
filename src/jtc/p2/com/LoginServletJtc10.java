package jtc.p2.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/testjtc10.jtc")
public class LoginServletJtc10 extends HttpServlet {
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String name = req.getParameter("uname");
		String password = req.getParameter("password");
		out.print("<h1>Hi, Welcome to Jtc</h1>");
		String page = "";
		if (name == null || password.trim().isEmpty()) {
			page = "requiredjtc10.html";
			req.getRequestDispatcher(page).forward(req, resp);
		}else if (password == null || password.trim().isEmpty()) {
			page = "requiredjtc10.html";
			req.getRequestDispatcher(page).forward(req, resp);
		} else {
			page = "homejtc10.html";
			req.getRequestDispatcher(page).forward(req, resp);
		}
	}
}
