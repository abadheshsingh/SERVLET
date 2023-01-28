package mail.com.p1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/SendMail")
public class SendMail extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String to = req.getParameter("userid");
		String subject = req.getParameter("subject");
		String message = req.getParameter("message");
		
		Mailer.send(to, subject, message);
		
		out.print("Message has been sent successfully.");
		out.close();
	}
}
