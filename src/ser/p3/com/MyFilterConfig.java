package ser.p3.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilterConfig implements Filter {
	FilterConfig config;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.config = filterConfig;
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String result = config.getInitParameter("construction");
		
		if (result.equals("Yes")) {
			out.print("Web application is under construction..........");
		} else {
			chain.doFilter(request, response);
		}
		
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
