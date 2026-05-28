package com.api.utils;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class  ConfigManager {

	private static Properties prop = new Properties();
	private static String path= "config/config.properties";
	private static String env;
	
	private ConfigManager(){
		//private constructor 
	}

	static {
		env=System.getProperty("env","qa");
		env.toLowerCase().trim();

		switch (env) {
		case "dev" -> path = "config/config.dev.properties";

		case "qa" -> path = "config/config.qa.properties";

		case "uat" -> path = "config/config.uat.properties";

		default -> path = "config/config.uat.properties";
		}

		InputStream input= Thread.currentThread().getContextClassLoader().getResourceAsStream("config/config.properties");
		
		if(input==null) {
			throw new RuntimeException("Cannot Find the File at the path" + path);
		}
		
		try {
			prop.load(input);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static String getProperty(String key) {

		return (prop.getProperty(key));
	}

}
