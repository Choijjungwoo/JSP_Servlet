package com.java.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionUtils {
	
	public static void close(Connection conn,Statement stmt, 
								ResultSet rs)throws SQLException{
		
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();
		if(conn!=null)conn.close();
	}
	public static void close(Connection conn,Statement stmt)
												throws SQLException{
		if(stmt!=null)stmt.close();
		if(conn!=null)conn.close();
	}
	public static void close(Connection conn)throws SQLException{
		
		if(conn!=null)conn.close();
	}
	
	public static void close(Statement stmt, ResultSet rs)throws SQLException{
		
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();
		
	}
	public static void close(Statement stmt) throws SQLException{
		close(stmt,null);
	}
}
