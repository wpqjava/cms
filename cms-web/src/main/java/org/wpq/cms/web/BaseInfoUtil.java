package org.wpq.cms.web;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.chainsaw.Main;
import org.wpq.cms.model.BaseInfo;

public class BaseInfoUtil {
	private static BaseInfoUtil biu = new BaseInfoUtil();
	private static Properties prop;
	
	private BaseInfoUtil() {
	}
	
	public static BaseInfoUtil getInstance(){
		prop = new Properties();
		try {
			prop.load(BaseInfoUtil.class.getClassLoader().getResourceAsStream("baseInfo.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return biu;
	}
	
	public BaseInfo read(){
		BaseInfo bi = new BaseInfo();
		bi.setName(prop.getProperty("name"));
		bi.setRecordCode(prop.getProperty("recordCode"));
		bi.setEmail(prop.getProperty("email"));
		bi.setUrl(prop.getProperty("url"));
		return bi;
	}
	
	public void write(BaseInfo bi){
		FileOutputStream fos = null;
		prop.setProperty("name", bi.getName());
		prop.setProperty("recordCode", bi.getRecordCode());
		prop.setProperty("email",bi.getEmail());
		prop.setProperty("url", bi.getUrl());
		try {
			fos = new FileOutputStream(BaseInfoUtil.class.getClassLoader()
					.getResource("baseInfo.properties").getPath());
			prop.store(fos, null);
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				if(fos!=null) fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
