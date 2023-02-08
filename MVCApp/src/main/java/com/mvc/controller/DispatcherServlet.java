package com.mvc.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet{
	// 1-1) 일반 파일을 읽어들일 속성객체 생성 
	Properties props;
	FileInputStream fis;		// 나중에 닫아줘야 하므로..
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		props=new Properties();		// 일반 클래스이므로 new 하기 

		String contextConfigLocation=config.getInitParameter("contextConfigLocation");		// 경로 얻어오기 
		
		ServletContext context=config.getServletContext();		// application 얻어오기 
		String realPath=context.getRealPath(contextConfigLocation);
		
		// 1-2) 파일정보 읽으려면? 스트림이 필요!
		/* 1-3) 파일객체는 정확한 디렉토리 주소를 알고 있어야 한다. --> 경로 구하러 가자
		 	뽀인트! 
		 	mapping 파일에 적힌 정보는  환경정보이기 때문에 이 서블릿이 반드시 알고 있어야 한다.
		 	따라서 servlet이 생성될 때 초기 파라미터로 넘겨도 된다. 
		 	init-param 이 지정되었으면 이 서블릿이 해당 정보를 안고 태어난다고 보면 됨 */
		try {
			
			fis=new FileInputStream(realPath);
			props.load(fis);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
	
	
	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 어떤 메서드이건 다 받을 수 있는 공통의 request 처리하기
		request.setCharacterEncoding("utf-8");
		
		// 2 읽어들인 파일정보를 가지고 클래스를 직접 new 하기 
		/* 2-1) 우선 클라이언트에서 들어온 uri를 해석해서 props와 연결을 해야함!!
		 * 이때 uri는 mapping 파일에서 왼쪽에 적은 .do 로 끝나는 key값이 된다.
		 * 그러면, key값에 해당하는 value 즉, controller를 생성할 수 있겠지?
		 */
		String uri=request.getRequestURI();
		String controllerPath=props.getProperty(uri);
		
		// 2-2) 클래스 객체를 이용하여 static에 직접 올리기
		try {
			Class controllerClass=Class.forName(controllerPath);	// 요청 온 uri에 해당하는 key와 매칭된 value 값이 추출!
			
			Controller controller=(Controller)controllerClass.getDeclaredConstructor().newInstance();
			// 변수로 날라오는 컨트롤러 경로를 이용하여 최상위 컨트롤러 인터페이스 생성 
			
			// 2-3) 드디어 하위 컨트롤러에게 일 전가!!
			controller.execute(request, response);
			
			String viewName=controller.getViewName();
			
			/* 뷰 페이지는 jsp 객체이므로 매핑 설정 정보에서 얻어온다 */
			String viewPage=props.getProperty(viewName);
			
			// 3 뷰 보여주기!
			if(controller.isForward()) {
				RequestDispatcher dis=request.getRequestDispatcher(viewPage);		// 보여줄 페이지 
				dis.forward(request, response);		
			}else {
				response.sendRedirect(viewPage);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void destroy() {
		if(fis!=null) {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
