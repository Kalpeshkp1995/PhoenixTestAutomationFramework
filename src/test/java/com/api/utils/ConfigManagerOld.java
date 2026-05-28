package com.api.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

public class  ConfigManagerOld {

	private static Properties prop = new Properties();
	
	private ConfigManagerOld(){
		//private constructor 
	}

	static {
		File configFile = new File(
				System.getProperty("user.dir") + File.separator +"src" +File.separator+"test"+File.separator+"resources"+File.separator +"config"+File.separator+"config.properties");
		FileReader filereader = null;
		try {
			filereader = new FileReader(configFile);
			prop.load(filereader);
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
