package com.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {

	// 하위 업무 
	public void execute(HttpServletRequest request, HttpServletResponse response);
	
	// 뷰 지정 
	public String getViewName();
	
	// 저장 방법 
	public boolean isForward();
	
}
