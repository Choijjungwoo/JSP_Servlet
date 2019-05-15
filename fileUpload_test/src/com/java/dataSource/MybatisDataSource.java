package com.java.dataSource;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisDataSource {
	private static MybatisDataSource instance=new MybatisDataSource();
	private MybatisDataSource() {}
	public static MybatisDataSource getInstance() {
		return instance;
	}
	
	private SqlSessionFactory sqlSessionFactory;
	
	{
		
		String config="com/mybatis/resource/sqlConfig.xml";
		
		try {
			Reader reader=Resources.getResourceAsReader(config);
			
			sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
			
			/*reader.close();*/
			
			System.out.println("sqlSessionFactory 성공했습니다.");
		}catch(Exception e) {			
			System.out.println("sqlSessionFactory 실패했습니다.");
			e.printStackTrace();
		}		
		
	}
	
	public SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}
	public SqlSession getSqlSession(boolean autoCommit) {
		return sqlSessionFactory.openSession(autoCommit);
	}
	
}
