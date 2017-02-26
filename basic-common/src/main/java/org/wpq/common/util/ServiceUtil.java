package org.wpq.common.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;

public class ServiceUtil {
	/**
	 * 传入一个原List和一个新的List,求需要删除的ID,返回一个List
	 * @param exist
	 * @param current
	 * @return
	 */
	public static List<Integer> needDeleteId(List<Integer> exist,List<Integer> current){
		List<Integer> needDelete = new ArrayList<Integer>();
		for(Integer i:exist){
			if(current.contains(i)) continue;
			needDelete.add(i);
		}
		return needDelete;
	}
	/**
	 * 传入一个原List和一个新的List,求需要添加的ID,返回一个List
	 * @param exist
	 * @param current
	 * @return
	 */
	public static List<Integer> needAddId(List<Integer> exist,List<Integer> current){
		List<Integer> needAdd = new ArrayList<Integer>();
		for(Integer i:current){
			if(exist.contains(i)) continue;
			needAdd.add(i);
		}
		return needAdd;
	}
	/**
	 * 传入一个int数组转化为列表
	 * @param array
	 * @return
	 */
	public static List<Integer> ArrayToList(int[] array){
		List<Integer> ls = new ArrayList<Integer>();
		for(int i=0;i<array.length;i++){
			ls.add(array[i]);
		}
		return ls;
	}
	public static List<Integer> ArrayToList(Integer[] array){
		List<Integer> ls = new ArrayList<Integer>();
		for(int i=0;i<array.length;i++){
			ls.add(array[i]);
		}
		return ls;
	}
	
	public static Integer[] ListToArray(List<Integer> list){
		Integer[] is = new Integer[list.size()];
		return list.toArray(is);
	}
	
	public static int[] ListToArrayInt(List<Integer> list){
		return ArrayUtils.toPrimitive(ListToArray(list));
	}
}
