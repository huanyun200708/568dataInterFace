package cn.com.hq.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream; 
import java.util.Properties;

public class PropertiesUtils {
	public static String getPropertyValueByKey(String key){
		Properties prop = new Properties();  
		String value = "";
	    try{
	    	String path = PropertiesUtils.class.getClassLoader().getResource("").getPath().substring(1);
	        InputStream in = new BufferedInputStream (new FileInputStream("/"+path + "property.properties"));
	        prop.load(in);     ///加载属性列表
	        value = prop.getProperty(key);
	        //System.out.println(key+":"+prop.getProperty(key));
	        in.close();
	    }
	    catch(Exception e){
	        e.printStackTrace();
	    }
		return value;
	}
}
