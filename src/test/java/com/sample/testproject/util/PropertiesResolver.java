package com.sample.testproject.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesResolver {
	
private static Properties properties = new Properties();
	
	static {
		String filePath = "src/main/resources/application.properties";
		File file = new File(filePath);
		FileInputStream fileInput = null;
		try{
			fileInput = new FileInputStream(file);
			properties.load(fileInput);
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		finally{
			try{
				if(null != fileInput){
					fileInput.close();
				}
			}catch(IOException e){
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static String getProperty(String propertyName){
		return properties.getProperty(propertyName);
	}

}
