package jtc.p4.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DemoFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("DemoFIlter init...................");
		String city = filterConfig.getInitParameter("city");
		System.out.println(city);
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String ip = request.getRemoteAddr();
		System.out.println(name);
		System.out.println(email);
		System.out.println(ip);
		chain.doFilter(request, response);
		System.out.println("demo filter post processing........");
		Object obj = request.getAttribute("MSG");
		System.out.println(obj);
		String msg = obj.toString();
		System.out.println(msg);
	}
	@Override
	public void destroy() {
		System.out.println("Destroy().....................");
	}
}
