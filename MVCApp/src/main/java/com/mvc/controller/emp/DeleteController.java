package com.mvc.controller.emp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.controller.Controller;
import com.mvc.domain.Emp;
import com.mvc.model.emp.EmpService;

public class DeleteController implements Controller{
	EmpService empService=new EmpService();
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		// 배열로 넘어오는 체크박스의 value 값 추출
		String[] empnoList=request.getParameterValues("empno");
		
		for(int i=0; i<empnoList.length; i++) {
			Emp emp=empService.select(Integer.parseInt(empnoList[i]));
			System.out.println("작동했니?");
			System.out.println(emp);
			empService.delete(emp);
		}
		
	}

	@Override
	public String getViewName() {
		return "/emp/view/delete";
	}

	@Override
	public boolean isForward() {

		return false;
	}

}
