package com.java.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.dto.MemberVO;

public interface MemberDAO {
	
	//공통사항 : throws SQLException
	
	//MemberVO 리스트
	List<MemberVO> selectMemberList()throws SQLException;
	
	//id 조회 MemberVO
	MemberVO selectMemberById(String id)throws SQLException;
	
	//insert MemberVO
	void insertMember(MemberVO member)throws SQLException;
	
	//update MemberVO
	void updateMember(MemberVO member)throws SQLException;
	
	//id를 받아서 delete MemberVO  
	void deleteMember(String id)throws SQLException;
	
}
