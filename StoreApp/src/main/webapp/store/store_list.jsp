<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.List"%>
<%@page import="store.repository.StoreDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	StoreDAO storeDAO=new StoreDAO();
%>
<%
	List list=storeDAO.selectAll();
	// 여기서 어떻게 주더라
	// 리스트를 찍으면 배열의 형태로 담겨있기 때문에 제이슨으로 전달하면 좋다
	//System.out.print(list);
	
	Gson gson=new Gson();
	String json=gson.toJson(list);
	out.print(json);
	
	
%>