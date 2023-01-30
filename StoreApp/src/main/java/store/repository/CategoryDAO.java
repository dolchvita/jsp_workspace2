package store.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import store.domain.Category;
import store.mybatis.MybatisConfig;

public class CategoryDAO {
	MybatisConfig config=MybatisConfig.getInstance();
	
	public List selectAll() {
		List list=null;
		SqlSession sqlSession=config.getSqlSession();
		list=sqlSession.selectList("Category.selectAll");
		config.release(sqlSession);
		
		return list;
	}
	
	public int insert(Category category) {
		int result=0;
		SqlSession sqlSession=config.getSqlSession();
		result=sqlSession.insert("Category.insert", category);
		sqlSession.commit();
		config.release(sqlSession);
		return result;
	}
}
