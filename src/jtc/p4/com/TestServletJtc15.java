package jtc.p4.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/testjtc15.jtc")
public class TestServletJtc15 extends HttpServlet {
	static int count = 0;
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		count++;
		System.out.println("---------service-------"+count);
		Date date = new Date();
		out.write("<h1>"+date+"</h1>");
		if (count <= 10) {
			resp.setHeader("Refresh", "1");
		} else {
			resp.setHeader("Refresh", "1:URL=http://jtcindia.com");
		}
	}
}
