package com.java.service;

import java.sql.SQLException;
import java.util.List;

import com.java.dao.AttachDAO;
import com.java.dto.AttachVO;

public class AttachServiceImpl implements AttachService {
	private static AttachServiceImpl instance=new AttachServiceImpl();
	private AttachServiceImpl() {}
	public static AttachServiceImpl getInstance() {
		return instance;
	}
	
	private AttachDAO attachDAO;
	public void setAttachDAO(AttachDAO attachDAO) {
		this.attachDAO=attachDAO;
	}
	
	
	@Override
	public List<AttachVO> getAttachList(int pno) throws SQLException {
		List<AttachVO> attachList=attachDAO.selectAttachesByPno(pno);
		return attachList;
	}

	@Override
	public void addAttach(AttachVO attach) throws SQLException {
		attachDAO.insertAttach(attach);
	}

	@Override
	public void removeAttach(int ano) throws SQLException {
		attachDAO.deleteAttach(ano);
	}

	@Override
	public void removeAllAttach(int pno) throws SQLException {
		attachDAO.deleteAllAttach(pno);
	}
	@Override
	public AttachVO getAttach(int ano) throws SQLException {
		AttachVO attach=attachDAO.selectAttachByAno(ano);
		return attach;
	}
	
	

}
