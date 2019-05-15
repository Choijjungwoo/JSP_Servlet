package com.java.source;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.tomcat.jdbc.pool.DataSource;

public class OracleDBCP2DataSource extends DataSource{
	
	private static OracleDBCP2DataSource instance
							=new OracleDBCP2DataSource();
	private OracleDBCP2DataSource() {}
	public static OracleDBCP2DataSource getInstance() {
		return instance;
	}
	
	private BasicDataSource dataSource= new BasicDataSource();
	public BasicDataSource getDataSource() {
		return dataSource;
	}
	
	public void setDataSource(String driverClassName,String url,
							  String username, String password) {
		setDriverClassName(driverClassName);
		setUrl(url);
		setUsername(username);
		setPassword(password);
	}
}






