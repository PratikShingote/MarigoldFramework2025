package com.SkillioJava;

import static propertiesUtility.PropertiesUtil.envDataFilePath;
import static propertiesUtility.PropertiesUtil.getPropertyFileData;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass 
{
	Keywords key= new Keywords();
	
// using interface	
//	@BeforeMethod
//	public void setup() throws IOException {
//		key.launchBrowser(TestData.browserName);
//		key.launchURL();
//	}
	
	
	@BeforeMethod
	public void setup() throws IOException {
		key.launchBrowser(getPropertyFileData(envDataFilePath, "browserName"));
		key.launchURL();
	} 
	
	
	@AfterMethod
	public void tearDown() {
		key.driver.quit();
	}
}
