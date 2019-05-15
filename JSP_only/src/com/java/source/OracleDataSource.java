package com.java.source;

import org.apache.commons.dbcp2.BasicDataSource;

public class OracleDataSource {
	private static OracleDataSource instance
					=new OracleDataSource();
	private OracleDataSource() {}
	public static OracleDataSource getInstance() {
		return instance;
	}
	
	private BasicDataSource dataSource;
	
	{
		dataSource=new BasicDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		dataSource.setUsername("java");
		dataSource.setPassword("java");
	}
	
	public BasicDataSource getDataSource() {
		return dataSource;
	}
}
