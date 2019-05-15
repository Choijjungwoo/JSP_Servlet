package com.java.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.dto.AttachVO;
import com.java.service.AttachService;
import com.java.service.AttachServiceImpl;

@WebServlet("/attach/remove")
public class RemoveAttachServlet extends HttpServlet {

	private AttachService service=AttachServiceImpl.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ano = Integer.parseInt(request.getParameter("ano"));
		
		String fileName=null;
		String filePath=null;
				
		try {
			AttachVO attach = service.getAttach(ano);
			fileName=attach.getFileName();
			filePath=attach.getUploadPath()+File.separator+fileName;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		File deleteFile=new File(filePath);
		
		String message="";
		if(deleteFile.exists()) {
			deleteFile.delete();
			try {
				service.removeAttach(ano);
				message=fileName+"파일을 삭제했습니다.";
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			message=fileName+"파일을 찾을 수 없습니다.";
		}
		
		String pno=request.getParameter("pno");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println("<script>");
		out.println("alert('"+message+"');");
		out.println("location.href='list?pno="+pno+"';");		
		out.println("</script>");		
	}
}








