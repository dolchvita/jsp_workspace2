<%@page import="com.google.gson.Gson"%>
<%@page import="store.domain.Category"%>
<%@page import="store.repository.CategoryDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	CategoryDAO categoryDAO=new CategoryDAO();
%>
<%
	
	List<Category> ct_list=categoryDAO.selectAll();
	
	//out.println(ct_list.size());
	
	// 배열로 담긴 리스트를 제이슨 형태로 전달하기
	StringBuilder sb=new StringBuilder();
	sb.append("[");
	for(int i=0; i<ct_list.size(); i++){
		Category category=ct_list.get(i);
		sb.append("{");
		sb.append("\"category_idx\" : "+category.getCategory_idx()+",");
		sb.append("\"category_name\" : \""+category.getCategory_name()+"\"");
		
		if(i<ct_list.size()-1){
			sb.append("},");
		}else{
			sb.append("}");
		}
	}
	sb.append("]");
	
	out.print(sb.toString());
	
%>