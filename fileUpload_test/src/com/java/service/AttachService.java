package com.java.service;

import java.sql.SQLException;
import java.util.List;

import com.java.dto.AttachVO;

public interface AttachService {
	
	List<AttachVO> getAttachList(int pno)throws SQLException;
	AttachVO getAttach(int ano)throws SQLException;
	
	void addAttach(AttachVO attach)throws SQLException;
	void removeAttach(int ano)throws SQLException;
	void removeAllAttach(int pno)throws SQLException;
}
