package ser.p3.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("Filter that is invoked at the preprocessing of request.");
		chain.doFilter(request, response);
		out.print("<br><br>Filter That is invoked at the postprocessing of request.");
		out.close();
	}
	@Override
	public void destroy() {
		
		
	}
}
