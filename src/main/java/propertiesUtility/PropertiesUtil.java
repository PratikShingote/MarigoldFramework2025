package propertiesUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
	
	public static String locatorFilePath="\\src\\main\\resources\\propertiesFile\\Locators.properties";
	public static String envDataFilePath="\\src\\main\\resources\\propertiesFile\\EnvironmentData.properties";
	public static String cssDataFilePath="\\src\\main\\resources\\propertiesFile\\CSS.properties";
	
	public static String getPropertyFileData(String filepath,String key) throws IOException {
		FileInputStream fis = null;

		// G:\\eclipse-workspace\\MarigoldFramework2025 --- hardcoded path solution

		String baseDirectory = System.getProperty("user.dir");

		fis = new FileInputStream(baseDirectory + filepath);

		Properties prop = new Properties();
		prop.load(fis);

		return prop.getProperty(key);
	}

//	public String readPropertiesFile() throws IOException {
//		String value=getLocatorsProperty("\\src\\main\\resources\\EnvironmentData.properties", "userName");
//		return value;
//	}
	
	
	
	
//	public static String getEnvData(String key) throws IOException {
//		FileInputStream fis = null;
//
//		// G:\\eclipse-workspace\\MarigoldFramework2025 --- hardcoded path solution
//
//		String baseDirectory = System.getProperty("user.dir");
//
//		fis = new FileInputStream(baseDirectory + "\\src\\main\\resources\\EnvironmentData.properties");
//
//		Properties prop = new Properties();
//		prop.load(fis);
//
//		return prop.getProperty(key);
//	}
	
	
	
//	public static void main(String[] args) throws IOException {
//		String user=getLocatorsProperty("userName");
//		System.out.println(user);
//	}
}
