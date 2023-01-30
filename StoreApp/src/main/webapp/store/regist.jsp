
<%@page import="store.domain.Store"%>
<%@page import="store.domain.Category"%>
<%@page import="store.repository.StoreDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%!
	StoreDAO storeDAO=new StoreDAO();
%>
<%
	request.setCharacterEncoding("utf-8");
	// pk값을 받아서 처리할 것!
	String lati=request.getParameter("lati");
	String longi=request.getParameter("longi");
	String store_name=request.getParameter("store_name");
	String category_idx=request.getParameter("category_idx");
	
	/* 비동기 방식이므로 시스템 로그로 찍어봐야 함!! */
	System.out.print("라티는 "+lati);
	System.out.print("롱기는 "+longi);
	System.out.print("상호명은 "+store_name);
	System.out.print("pk 는"+category_idx);
	
	Store store=new Store();
	store.setLati(Double.parseDouble(lati));
	store.setLongi(Double.parseDouble(longi));
	store.setStore_name(store_name);
	
	Category category=new Category();
	category.setCategory_idx(Integer.parseInt(category_idx));
	store.setCategory(category);
	
	int result=storeDAO.insert(store);
	
	out.print(result);
	
%>