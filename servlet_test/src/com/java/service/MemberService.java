package com.java.service;

import java.sql.SQLException;

import com.java.dto.MemberVO;
import com.java.exception.IdNotFoundException;
import com.java.exception.InvalidPasswordException;

public interface MemberService {
	
	// 로그인 기능
	void login(String id, String pwd)throws SQLException,
											IdNotFoundException,
											InvalidPasswordException;
	
	// 회원가입
	void regist(MemberVO member)throws SQLException;
	
}







