package org.wpq.cms.auth;

import java.io.File;

import java.io.FilenameFilter;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class AuthUtil {
	private AuthUtil() {
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map<String,Set<String>> initAuth(String packageName){
		Map<String,Set<String>> authMap = new HashMap<>();
		try {
			authMap.put("LOGIN", new HashSet<String>());
			authMap.put("ADMIN", new HashSet<String>());
			authMap.put("PUBLISH", new HashSet<String>());
			authMap.put("AUDIT", new HashSet<String>());
			for(String str:getClassByPackageName(packageName)){
				String fn = packageName+"."+str.substring(0, str.lastIndexOf(".class"));
				Class clz = Class.forName(fn);
				if(clz.isAnnotationPresent(AuthClass.class)){
					AuthClass ac = (AuthClass) clz.getAnnotation(AuthClass.class);
					String value = ac.value();
					if(!value.equals("ADMIN")){
						for(Method m :clz.getDeclaredMethods()){
							if(m.isAnnotationPresent(AuthMethod.class)){
								String roleNames = m.getAnnotation(AuthMethod.class).role();
								String[] roleName = roleNames.split(",");
								for(String s:roleName){
									authMap.get(s).add(fn+"."+m.getName());
								}
							}else{
								authMap.get("LOGIN").add(fn+"."+m.getName());
							}
						}
					}
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return authMap;
	}
	/**
	 * 通过包名找类名
	 * @param packageName 需要进行权限管理的包名
	 * @return
	 */
	private static String[] getClassByPackageName(String packageName) {
		String packagePath = AuthUtil.class.getClassLoader().getResource(packageName.replace(".", "/")).getPath();
		File packageFile = new File(packagePath);
		String[] fs = packageFile.list(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				if(name.endsWith(".class"))return true;
				return false;
			}
		});
		return fs;
	}
	
}
