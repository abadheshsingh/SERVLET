package upload.p1.com;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/FileUploadServlet.jtc")
@MultipartConfig(
		fileSizeThreshold = 1024*1024*1, // 1MB
		maxFileSize = 1024*1024*10, // 10MB
		maxRequestSize = 1024*1024*100 // 100MB
		)
public class FileUploadServlet extends HttpServlet {
	ServletContext ctx = null;
	@Override
	public void init() throws ServletException {
		String rootPath = System.getProperty("catalina.home");
		ctx = getServletContext();
		String relativePath = ctx.getInitParameter("tempfile.dir");
		File file = new File(rootPath + File.separator + relativePath);
		if(!file.exists()) file.mkdirs();
    	ctx.setAttribute("FILES_DIR_FILE", file);
    	ctx.setAttribute("FILES_DIR", rootPath + File.separator + relativePath);	
	}
	
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		Part part1 = req.getPart("filename");
		ctx.setAttribute("filename", part1.getName());
		String fname = part1.getSubmittedFileName();
		String location = (String) ctx.getAttribute("FILES_DIR");
		for (Part part2 : req.getParts()) {
			part2.write(location+"\\"+fname);
		}
		out.print("File successfully uploaded..........");
	}
}
