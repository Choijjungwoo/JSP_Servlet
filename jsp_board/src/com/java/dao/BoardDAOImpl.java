package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.java.dto.BoardVO;
import com.java.utils.ConnectionUtils;

public class BoardDAOImpl implements BoardDAO {
	private static BoardDAOImpl instance = new BoardDAOImpl();

	private BoardDAOImpl() {
	}

	public static BoardDAOImpl getInstance() {
		return instance;
	}

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<BoardVO> selectBoardList() throws SQLException {
		String sql = "select * from board order by bno desc";

		Connection conn = dataSource.getConnection();
		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery(sql);

		List<BoardVO> boardList = new ArrayList<BoardVO>();
		while (rs.next()) {
			boardList.add(toBoardVO(rs));
		}

		ConnectionUtils.close(conn, stmt, rs);

		return boardList;
	}

	@Override
	public BoardVO selectBoardByBno(int bno) throws SQLException {
		String sql="select * from board where bno=?";
		
		Connection conn=dataSource.getConnection();
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, bno);
		
		ResultSet rs=pstmt.executeQuery();
		
		BoardVO board=null;
		if(rs.next()) {
			board=toBoardVO(rs);
		}
		
		ConnectionUtils.close(conn,pstmt,rs);
		
		return board;
	}

	@Override
	public void insertBoard(BoardVO board) throws SQLException {
		String sql="insert into board(bno,title,writer,content)"
				+ " values(?,?,?,?)";
		
		Connection conn=dataSource.getConnection();
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, board.getBno());
		pstmt.setString(2, board.getTitle());
		pstmt.setString(3, board.getWriter());
		pstmt.setString(4,board.getContent());
		
		pstmt.executeUpdate();
		
		ConnectionUtils.close(conn,pstmt);
	}

	@Override
	public void updateBoard(BoardVO board) throws SQLException {
		String sql="update board set title=?, content=?, "
				+ "updatedate=sysdate where bno=?";
		
		Connection conn=dataSource.getConnection();
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, board.getTitle());
		pstmt.setString(2,board.getContent());
		pstmt.setInt(3, board.getBno());
		
		pstmt.executeUpdate();
		
		ConnectionUtils.close(conn,pstmt);
	}

	@Override
	public void deleteBoard(int bno) throws SQLException {
		String sql="delete from board where bno=?";
		
		Connection conn=dataSource.getConnection();
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, bno);
		
		pstmt.executeUpdate();
		
		ConnectionUtils.close(conn,pstmt);

	}

	private BoardVO toBoardVO(ResultSet rs) throws SQLException {

		BoardVO board = new BoardVO();

		board.setBno(rs.getInt("bno"));
		board.setContent(rs.getString("content"));
		board.setRegDate(rs.getDate("regDate"));
		board.setTitle(rs.getString("title"));
		board.setUpdatedate(rs.getDate("updatedate"));
		board.setViewcnt(rs.getInt("viewcnt"));
		board.setWriter(rs.getString("writer"));

		return board;
	}

	@Override
	public void increaseViewCnt(int bno) throws SQLException {
		String sql = "update board set viewcnt=viewcnt+1 "
					+ "where bno=?";

		Connection conn = dataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bno);

		pstmt.executeUpdate();

		ConnectionUtils.close(conn,pstmt);

	}

	@Override
	public int selectBoardSeqNext() throws SQLException {
		String sql = "select board_seq.nextval as bno from dual";

		int bno = -1;

		Connection conn = dataSource.getConnection();
		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery(sql);

		if (rs.next()) {
			bno = rs.getInt("bno");
		}

		ConnectionUtils.close(conn,stmt,rs);
		return bno;

	}

}
