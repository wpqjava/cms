package org.wpq.common.util;

import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreemarkerUtil {
	private static Configuration config;
	private static FreemarkerUtil util;
	
	private FreemarkerUtil() {
	}
	
	@SuppressWarnings("deprecation")
	public static FreemarkerUtil getInstance(String basePackagePath){
		if(util==null){
			config = new Configuration();
			config.setClassForTemplateLoading(FreemarkerUtil.class, basePackagePath);
			util = new FreemarkerUtil();
		}
		return util;
	}
	/**
	 * 获得模板
	 * @param name 模板文件名
	 * @return
	 */
	public static Template getTemplate(String name){
		try {
			return config.getTemplate(name);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 通过标准输出流输出到控制台
	 * @param root 写入数据
	 * @param ftlName 模板文件名
	 */
	public void systemPrint(Map<String,Object> root,String ftlName){
		try {
			getTemplate(ftlName).process(root, new PrintWriter(System.out));
		} catch (TemplateException | IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 通过标准输出流输出到文件
	 * @param root
	 * @param ftlName
	 * @param filePath
	 */
	public void filePrint(Map<String,Object> root,String ftlName,String filePath){
		try {
			getTemplate(ftlName).process(root, new FileWriter(new File(filePath)));
		} catch (TemplateException | IOException e) {
			e.printStackTrace();
		}
	}
	
}
