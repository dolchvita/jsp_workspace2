package com.mvc.controller.emp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.controller.Controller;
import com.mvc.domain.Dept;
import com.mvc.domain.Emp;
import com.mvc.model.emp.EmpService;

public class RegistController implements Controller{
	EmpService empService=new EmpService();
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String dname=request.getParameter("dname");
		String ename=request.getParameter("ename");
		String sal=request.getParameter("sal");
		
		Dept dept=new Dept();
		dept.setDname(dname);
		Emp emp=new Emp();
		emp.setDept(dept);
		emp.setEname(ename);
		emp.setSal(Integer.parseInt(sal));

		empService.insert(emp);
		
	}

	@Override
	public String getViewName() {
		return "/emp/view/regist";
	}

	@Override
	public boolean isForward() {
		return false;
	}

}
