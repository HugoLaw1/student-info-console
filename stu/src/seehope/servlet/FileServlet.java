package seehope.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doService(req,resp);
	}

	
	protected void doService(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println("file");
		//得到上传文件的保存目录，将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
		String path = this.getServletContext().getRealPath("/WEB-INF/upload");
		System.out.println(path);
		//判断上传文件的保存目录是否存在
		File file = new File(path);
		if(!file.isDirectory()&&!file.exists()) {
			file.mkdir();
		}
		////使用Apache文件上传组件处理文件上传步骤：
		//1、创建一个DiskFileItemFactory工厂
		DiskFileItemFactory dfif = new DiskFileItemFactory();
		//2、创建一个文件上传解析器
		ServletFileUpload upload = new ServletFileUpload(dfif);
		//解决上传文件名的中文乱码
		upload.setHeaderEncoding("UTF-8");
		
	}
	
}
