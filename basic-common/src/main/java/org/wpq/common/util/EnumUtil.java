package org.wpq.common.util;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@SuppressWarnings("rawtypes")
public class EnumUtil {
	
	public static List<String> Enum2Name(Class<? extends Enum> clz){
		List<String> ls = new ArrayList<String>();
		for(Enum e : clz.getEnumConstants()){
			ls.add(e.name());
		}
		return ls;
	}
	
	public static List<String> Enum2PropList(Class<? extends Enum> clz,String prop){
		if(!clz.isEnum()) return null;
		List<String> ls = new ArrayList<String>();
		try {
			for(Enum e : clz.getEnumConstants()){
				String first = prop.substring(0,1);
				String methodName = "get"+prop.replace(first, first.toUpperCase());
				Method m = clz.getMethod(methodName,null);
				ls.add((String)m.invoke(e, null));
			}
			return ls;
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return ls;
	}
	
	public static Map<String,String> Enum2PropNameMap(Class<? extends Enum> clz,String prop){
		if(!clz.isEnum()) return null;
		Map<String,String> map = new HashMap<String,String>();
		try {
			for(Enum e : clz.getEnumConstants()){
				String first = prop.substring(0,1);
				String methodName = "get"+prop.replace(first, first.toUpperCase());
				Method m = clz.getMethod(methodName,null);
				map.put(e.name(), (String)m.invoke(e, null));
			}
			return map;
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return map;
	}
}
