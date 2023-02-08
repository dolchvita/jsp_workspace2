package com.mvc.model.emp;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mvc.domain.Dept;
import com.mvc.domain.Emp;
import com.mvc.exception.DeptException;
import com.mvc.exception.EmpException;
import com.mvc.mybatis.MybatisConfig;

// 데이터처리 객체
public class EmpService {
	MybatisConfig mybatisConfig=MybatisConfig.getInstance();
	DeptDAO deptDAO;
	EmpDAO empDAO;
	
	public EmpService() {
		deptDAO=new DeptDAO();
		empDAO=new EmpDAO();
	}
	
	public void insert(Emp emp) {
		SqlSession sqlSession=mybatisConfig.getSqlSession();
		deptDAO.setSqlSession(sqlSession);
		empDAO.setSqlSession(sqlSession);
		
		try {
			deptDAO.insert(emp.getDept());
			empDAO.insert(emp);
			
			sqlSession.commit();
		} catch (DeptException e) {
			sqlSession.rollback();
		}catch (EmpException e) {
			sqlSession.rollback();
		}finally {
			mybatisConfig.release(sqlSession);
		}
	}

	
	public List selectAll() {
		SqlSession sqlSession=mybatisConfig.getSqlSession();
		empDAO.setSqlSession(sqlSession);
		List list=empDAO.selectAll();
		
		// 결과를 바로 보내면 세션을 닫아줄 수가 없음! --> 변수에 담아 가
		mybatisConfig.release(sqlSession);
		return list; 
	}
	
	
	public Emp select(int empno) {
		SqlSession sqlSession=mybatisConfig.getSqlSession();
		empDAO.setSqlSession(sqlSession);
		Emp emp=empDAO.select(empno);
		mybatisConfig.release(sqlSession);
		return emp;
	}
	
	public void delete(Emp emp) {
		SqlSession sqlSession=mybatisConfig.getSqlSession();
		empDAO.setSqlSession(sqlSession);
		deptDAO.setSqlSession(sqlSession);
		
		try {
			empDAO.delete(emp.getEmpno());
			deptDAO.delete(emp.getDept().getDeptno());
			
			sqlSession.commit();
			
		} catch (EmpException e) {
			sqlSession.rollback();
		}catch (DeptException e) {
			sqlSession.rollback();		
		}finally {
			mybatisConfig.release(sqlSession);
		}
	}


}
