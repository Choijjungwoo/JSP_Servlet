package com.java.servlet.pds;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.dto.AttachVO;
import com.java.request.Criteria;
import com.java.request.PageMaker;
import com.java.service.PdsService;
import com.java.service.PdsServiceImpl;


@WebServlet("/pds/remove")
public class RemovePdsServlet extends HttpServlet {
	
	private PdsService service = PdsServiceImpl.getInstance();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String url="/WEB-INF/views/pds/removeSuccess.jsp";
		
		int pno = Integer.parseInt(request.getParameter("pno"));
		
		int page=Integer.parseInt(request.getParameter("page"));
		int perPageNum=Integer.parseInt(request.getParameter("perPageNum"));
		
		//pno에 대한 attachList 확보
		List<AttachVO> attachList=null;
		try {
			 attachList= service.getPds(pno).getAttachList();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//각 attachlist 를 이용 파일을 삭제.
		for(AttachVO attach:attachList) {
			String storedFilePath=
			attach.getUploadPath()+File.separator+attach.getFileName();
			File file=new File(storedFilePath);
			if(file.exists()) {
				file.delete();
			}
			
		}
		
		Criteria cri=new Criteria();
		cri.setPage(page);
		cri.setPerPageNum(perPageNum);
		
		PageMaker pageMaker=new PageMaker();
		pageMaker.setCri(cri);
				
		try {
			service.remove(pno);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		request.setAttribute("deleted_pno", pno);
		request.setAttribute("pageMaker", pageMaker);
		
		request.getRequestDispatcher(url).forward(request, response);
		
		
	}

}
