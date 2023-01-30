package store.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisConfig {
	private static MybatisConfig instance;
	SqlSessionFactory sqlSessionFactory;
	
	
	private MybatisConfig() {
		String resource = "store/mybatis/config.xml";
		InputStream inputStream=null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	
	public SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();	
	}
	
	
	public void release(SqlSession sqlSession) {
		if(sqlSession!=null) {
			sqlSession.close();
		}
	}
	
	
	public static MybatisConfig getInstance() {
		if(instance==null) {
			instance=new MybatisConfig();
		}
		return instance;
	}
	
}
