package com.jspshop.exception;

// 강요하지 않는 예외처리 객체 만들
public class ProductException extends RuntimeException{

	public ProductException(String msg) {
		super(msg);
	}
	
}
