package org.wpq.common.util;

import java.io.IOException;
import java.io.StringWriter;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonUtil {
	private static JsonFactory jf = new JsonFactory();
	
	public static String obj2Json(Object obj){
		StringWriter out = null;
		JsonGenerator jg = null;
		try {
			out = new StringWriter();
			jg = jf.createGenerator(out);
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(jg, obj);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(jg!=null)jg.close();
				if(out!=null)out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return out.toString();
	}
	
	public static Object json2OneObj(String json,Class<?> clz){
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(json, clz);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
