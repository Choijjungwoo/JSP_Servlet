package com.java.servlet.pds;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.dto.AttachVO;
import com.java.dto.PdsVO;
import com.java.service.PdsService;
import com.java.service.PdsServiceImpl;
import com.java.utils.MakeFileName;


@WebServlet("/pds/detail")
public class DetailPdsServlet extends HttpServlet {
	
	private PdsService service=PdsServiceImpl.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url="/WEB-INF/views/pds/detail.jsp";
		
		int pno=Integer.parseInt(request.getParameter("pno"));
		
		try {
			PdsVO pds=service.read(pno);	
			List<AttachVO> renamedAttachList=
  MakeFileName.parseFileNameFromAttaches(pds.getAttachList(), "\\$\\$");
			pds.setAttachList(renamedAttachList);
			request.setAttribute("pds", pds);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
