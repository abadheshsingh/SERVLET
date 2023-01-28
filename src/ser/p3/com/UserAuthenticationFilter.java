package ser.p3.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class UserAuthenticationFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String userid = request.getParameter("username");
		String password = request.getParameter("password");
		
		if (password.equals("Admin@12345")) {
			chain.doFilter(request, response);
		} else {
			out.print("Sorry, your credential is incorrect.");
			request.getRequestDispatcher("userauthentication.html").include(request, response);
		}
		
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
