package com.jspshop.domain;

import lombok.Data;

@Data
public class Cart{
	// "누가" & "몇개" 정보 추가!
	private Product product;
	private int ea;
	private Member member;
}
