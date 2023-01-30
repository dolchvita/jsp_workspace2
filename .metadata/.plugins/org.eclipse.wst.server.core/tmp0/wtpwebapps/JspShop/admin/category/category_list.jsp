<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.List"%>
<%@page import="com.jspshop.repository.CategoryDAO"%>
<%@ page contentType="application/json; charset=UTF-8"%>
<%!
	CategoryDAO categoryDAO=new CategoryDAO();
%>
<%
	List list=categoryDAO.selectAll();

	 Gson gson=new Gson();
	 
	 out.print(gson.toJson(list));
	 
%>