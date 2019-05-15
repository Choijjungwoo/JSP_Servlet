package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.java.dto.MemberVO;

public class MemberDAOImpl implements MemberDAO{
	//싱글톤 패턴 구현
	private static MemberDAOImpl instance = new MemberDAOImpl();
	private MemberDAOImpl() {}
	public static MemberDAOImpl getInstance() {
		return instance;
	}
	
	//DataSource
	private DataSource dataSource;
	public void setDataSource(DataSource dataSource) {
		this.dataSource=dataSource;
	}
	
	
	@Override
	public List<MemberVO> selectMemberList() throws SQLException {
		List<MemberVO> memberList=new ArrayList<MemberVO>();
		String sql="select * from member";
		
		Connection conn=dataSource.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		
		while(rs.next()) {
			MemberVO member=new MemberVO();
			member.setEmail(rs.getString("email"));
			member.setId(rs.getString("id"));
			member.setPhone(rs.getString("phone"));
			member.setPwd(rs.getString("pwd"));
			
			memberList.add(member);
		}
		
		rs.close();
		stmt.close();
		conn.close();
		
		return memberList;
	}

	@Override
	public MemberVO selectMemberById(String id) throws SQLException {
		
		MemberVO member=null;
		
		String sql="select * from member where id=?";
		
		Connection conn=dataSource.getConnection();
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, id);
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			member=new MemberVO();
			member.setEmail(rs.getString("email"));
			member.setId(rs.getString("id"));
			member.setPhone(rs.getString("phone"));
			member.setPwd(rs.getString("pwd"));
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return member;
	}

	@Override
	public void insertMember(MemberVO member) throws SQLException {
		String sql="insert into member(id,pwd,email,phone) "
				+ "values(?,?,?,?)";
		
		Connection conn=dataSource.getConnection();
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, member.getId());
		pstmt.setString(2, member.getPwd());
		pstmt.setString(3, member.getEmail());
		pstmt.setString(4, member.getPhone());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		
	}

	@Override
	public void updateMember(MemberVO member) throws SQLException {
		String sql="update member set pwd=?,email=?,phone=? "
				+ "where id=?";
		
		Connection conn=dataSource.getConnection();
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, member.getPwd());
		pstmt.setString(2, member.getEmail());
		pstmt.setString(3, member.getPhone());
		pstmt.setString(4, member.getId());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		
		
	}

	@Override
	public void deleteMember(String id) throws SQLException {
		String sql="delect from member where id=?";
		
		Connection conn=dataSource.getConnection();
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, id);		
		
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();		
	}	
}
