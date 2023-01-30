package com.jspshop.util;

// 파일과 관련된 유용한 기능
public class FileManager {

	
	public static String getExt(String path) {
		int index=path.lastIndexOf("."); 		//제일 마지막 점의 index
		return path.substring((index+1), path.length());
	}

}