package com.SkillioProject;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.SkillioJava.BaseClass;
import com.SkillioJava.Keywords;
import com.SkillioJava.Locators;

import listenersUtility.MyListener;

import static propertiesUtility.PropertiesUtil.*;
import java.io.IOException;

@Listeners(MyListener.class)
public class CSSLoginTestCases extends BaseClass
{
	Keywords key=new Keywords();
	
	@Test
	public void toVerifySuccessfulLoginWithKeywordDriven() throws IOException {
		//key.implicitWait();
		key.waitElementToBePresent("css",getPropertyFileData(cssDataFilePath, "userName"));
		key.enterText("css",getPropertyFileData(cssDataFilePath, "userName"), getPropertyFileData(envDataFilePath, "userName"));
		key.enterText("css",getPropertyFileData(cssDataFilePath, "password"), getPropertyFileData(envDataFilePath, "password"));
		key.locatorStrat("css",getPropertyFileData(cssDataFilePath, "submit"));
		String expectedTextAfterLogin="Dashboard";
		key.waitElementToBePresent("css",getPropertyFileData(cssDataFilePath, "dashboardText"));
		String actualTextAfterLogin=key.getActualText("css",getPropertyFileData(cssDataFilePath, "dashboardText"));
		//Assert.assertEquals(actualTextAfterLogin, expectedTextAfterLogin);
		key.assertText(actualTextAfterLogin, expectedTextAfterLogin);
		
		key.locatorStrat("css",getPropertyFileData(cssDataFilePath, "logoutDropDown"));
		//key.performClick(Locators.logoutOption);
		key.locatorStrat("className", Locators.aboutClass);
		//key.locatorStrat("className", Locators.aboutClassClose);
		key.clicklUsingJavaScript(Locators.aboutCloseCSSJS);
		
	}
}
