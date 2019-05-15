package com.mybatis.dataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class OracleDBCP2DataSource extends BasicDataSource{
	
	private static OracleDBCP2DataSource instance=
			new OracleDBCP2DataSource();
	private OracleDBCP2DataSource() {}
	public static OracleDBCP2DataSource getInstance() {
		return instance;
	}
	
	{
		setDriverClassName("oracle.jdbc.driver.OracleDriver");
		setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		setUsername("java");
		setPassword("java");
	}
}







