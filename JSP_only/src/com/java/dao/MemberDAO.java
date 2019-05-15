package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

import com.java.dto.MemberVO;
import com.java.source.OracleDataSource;

public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();

	private MemberDAO() {
	}

	public static MemberDAO getInstance() {
		return instance;
	}	

	/*
	1. DB driver loading
	2. DB Connection
	3. SQL injection
	4. ResultSet recevie
	5. table data (Row)→ MemberVO object	
	*/ 
	
	
	// 1. DB driver loading
	BasicDataSource dataSource = OracleDataSource.getInstance().getDataSource();

	public List<MemberVO> selectMemberList() throws SQLException {

		// 2. DB Connection
		Connection conn = dataSource.getConnection();

		// 3. SQL injection
		String sql = "select * from member";
		Statement stmt = conn.createStatement();

		// 4. ResultSet recevie
		ResultSet rs = stmt.executeQuery(sql);

		// 5. table data (Row)→ List object (MemberVO)
		List<MemberVO> memberList = new ArrayList<MemberVO>();

		while (rs.next()) {
			MemberVO member = new MemberVO();
			member.setId(rs.getString("id"));
			member.setPwd(rs.getString("pwd"));
			member.setPhone(rs.getString("phone"));
			member.setEmail(rs.getString("email"));

			memberList.add(member);
		}

		// close
		rs.close();
		stmt.close();
		conn.close();

		return memberList;
	}

	public void insertMember(MemberVO member) throws SQLException {

		// 2. DB Connection
		Connection conn = dataSource.getConnection();

		// 3. SQL injection
		String sql = "insert into member(id,pwd,email,phone)" + " values(?,?,?,?)";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, member.getId());
		pstmt.setString(2, member.getPwd());
		pstmt.setString(3, member.getEmail());
		pstmt.setString(4, member.getPhone());

		pstmt.executeUpdate();

		// close
		pstmt.close();
		conn.close();

	}

	public void updateMember(MemberVO member) throws SQLException {

		// 2. DB Connection
		Connection conn = dataSource.getConnection();

		// 3. SQL injection
		String sql = "update member set pwd=?, email=?, phone=? where id=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, member.getPwd());
		pstmt.setString(2, member.getEmail());
		pstmt.setString(3, member.getPhone());
		pstmt.setString(4, member.getId());

		pstmt.executeUpdate();

		// close
		pstmt.close();
		conn.close();

	}

	public MemberVO selectMemberById(String id) throws SQLException {

		// 2. DB Connection
		Connection conn = dataSource.getConnection();

		// 3. SQL injection

		String sql = "select * from member where id=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);

		// 4. ResultSet recevie
		ResultSet rs = pstmt.executeQuery();
		// 5. table data (Row)→ MemberVO object
		MemberVO member = new MemberVO();

		if (rs.next()) {
			member.setId(rs.getString("id"));
			member.setPwd(rs.getString("pwd"));
			member.setPhone(rs.getString("phone"));
			member.setEmail(rs.getString("email"));
		}

		rs.close();
		pstmt.close();
		conn.close();

		return member;

	}

	public void deleteMember(String id) throws SQLException {

		// 2. DB Connection
		Connection conn = dataSource.getConnection();

		// 3. SQL injection

		String sql = "delete from member where id=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);

		pstmt.executeUpdate();

		pstmt.close();
		conn.close();

	}
}
