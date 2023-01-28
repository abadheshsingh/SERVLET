package stream.p1.com;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DisplayImage.jtc")
public class DisplayImage extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("image/jpeg");
		ServletOutputStream stream = resp.getOutputStream();
		
		FileInputStream fin = new FileInputStream("C:\\Users\\Abadhesh Kumar\\eclipse-workspace\\SERVLET\\WebContent\\WEB-INF\\images\\flower.jpg");
		
		BufferedInputStream bis = new BufferedInputStream(fin);
		BufferedOutputStream bos = new BufferedOutputStream(stream);
		int ch = 0;
		while ((ch = bis.read()) != -1) {
			stream.write(ch);
		}
		bis.close();
		fin.close();
		bos.close();
		stream.close();
	}
}
