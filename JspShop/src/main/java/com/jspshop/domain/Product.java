package com.jspshop.domain;

import java.util.List;

import lombok.Data;

@Data
public class Product {
	private int product_idx;
	private Category category;
	private String product_name;
	private String brand;
	private int price;
	private int discount;
	private String detail;
	
	private List<Psize> PsizeList;		// 부모테이블이 자식들을 모아놓은 Collection의 대상!
	private List<Color> colorList;
	private List<Pimg> pimgList;
	
}
