package com.mvc.model.emp;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mvc.domain.Dept;
import com.mvc.domain.Emp;
import com.mvc.exception.DeptException;
import com.mvc.exception.EmpException;

public class EmpDAO {
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public void insert(Emp emp) throws EmpException{
		int result=sqlSession.insert("Emp.insert", emp);
		if(result<1) {
			throw new EmpException("사원 등록 실패");
		}
	}
	
	public List selectAll() {
		return sqlSession.selectList("Emp.selectAll");
	}
	
	
	public Emp select(int empno) {
		return sqlSession.selectOne("Emp.select", empno);
	}
	
	
	public void delete(int empno) throws EmpException{
		int result=sqlSession.delete("Emp.delete", empno);
		if(result<1) {
			throw new EmpException("사원 삭제 실패");
		}
	}
	
	
}
