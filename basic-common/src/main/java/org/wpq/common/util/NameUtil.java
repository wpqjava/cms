package org.wpq.common.util;

import java.util.Random;

public class NameUtil {
	private static Random randow = new Random();
	private static String[] firstPhone = new String[]{"135","136","138","186","168","189","158"};
	private static String[] firstName = new String[]{"赵","钱","孙","李","周","吴","郑","王",
			"冯","陈","楚","魏","辽","沈","韩","杨","秦","尤","许","何","吕","施","张","孔","曹","严","华","温"};
	private static String[] lastName = new String[]{"曼婷","玥婷","优璇","雨嘉","娅楠","明美","惠茜","漫妮","媛馨","梦涵",
			"致远","俊驰","雨泽","烨磊","晟睿","天佑","文昊","修洁","黎昕","远航","梦晨"};
	
	
	public static String createName(){
		String name = firstName[randow.nextInt(firstName.length)]+lastName[randow.nextInt(lastName.length)];
		return name;
	}
	public static String createPhone(){
		String Phone = firstPhone[randow.nextInt(firstPhone.length)]+(int)(Math.random()*100000000);
		return Phone;
	}
	
}
