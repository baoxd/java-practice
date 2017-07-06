package com.test.maven.util;

import java.util.Random;

/**
 * 
 * @author baoxd
 *
 */
public class TestUtils {
	
	/**
	 * 生成指定长度的随机数
	 * @param len
	 * @return
	 */
	public String uuid(Integer len){
		String ret = "";
		Random r = new Random();
		
		if(len == null){
			len = 10;
		}
		String[] strs = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
		
		for(int i = 0 ; i < len ; i++){
			ret += strs[r.nextInt(35)];
		}
		
		return ret;
	}
	
	
}
