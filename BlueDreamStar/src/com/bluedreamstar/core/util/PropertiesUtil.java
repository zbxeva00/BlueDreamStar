package com.bluedreamstar.core.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * config.properties配置文件读取工具类
 * @author zbxeva00
 *
 */
public class PropertiesUtil {
	
	public static String getPropertyValueByPropertyKey(String propertyKey){
		String value = "";
		InputStream is = null;
		Properties p = new Properties();
		try {
			//获取config.properties文件输入流
			is = PropertiesUtil.class.getResourceAsStream("/config.properties");
			p.load(is);
			value = p.getProperty(propertyKey);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (p != null) {
				p.clear();
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		}
		return value;
	}
	
}
