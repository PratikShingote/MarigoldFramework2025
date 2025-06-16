package com.SkillioProject;

import java.io.IOException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.SkillioJava.BaseClass;
import com.SkillioJava.Keywords;
import com.SkillioJava.Locators;
import com.SkillioJava.TestData;
import listenersUtility.MyListener;

import static propertiesUtility.PropertiesUtil.*; //class is static all data members becomes static import

@Listeners(MyListener.class)

public class KeywordDrivenLoginTestCases extends BaseClass
{
	Keywords key=new Keywords();
	
	
	/**
	 * This test case to perform successfully login with valid cred and validate Dashboard text
	 * @return - Test case result pass / fail
	 * @param {@code - null}
	 */
	@Test
	public void toVerifySuccessfulLoginWithKeywordDriven() {
		//key.implicitWait();
		key.waitElementToBePresent(Locators.userName);
		key.enterText(Locators.userName, TestData.userName);
		key.enterText(Locators.password, TestData.password);
		key.performClick(Locators.submit);
		String expectedTextAfterLogin="Dashboard";
		key.waitElementToBePresent(Locators.dashboardText);
		String actualTextAfterLogin=key.getActualText(Locators.dashboardText);
		//Assert.assertEquals(actualTextAfterLogin, expectedTextAfterLogin);
		key.assertText(actualTextAfterLogin, expectedTextAfterLogin);
		
		key.performClick(Locators.logoutDropDown);
		//key.performClick(Locators.logoutOption);
		key.locatorStrat("className", Locators.aboutClass);
		//key.locatorStrat("className", Locators.aboutClassClose);
		key.clicklUsingJavaScript(Locators.aboutCloseCSSJS);
		
	}
	
	/**
	 * This test case to check login using invalid credentials
	 * @throws IOException 
	 */
	@Test(enabled = false)
	public void toVerifyLoginWithInvalidCredentials() throws IOException {
		
		key.waitElementToBePresent(Locators.userName);
		key.enterText(Locators.userName, TestData.invalidUserName);
		key.enterText(Locators.password, TestData.invalidPassword);
		key.performClick(Locators.submit);
		String expectedErrorMsgAfterLogin="Invalid credentials";
		key.waitElementToBePresent(Locators.invalidMsgAfterLoginClick);
		String actualErrorMsgAfterLogin=key.getActualText(Locators.invalidMsgAfterLoginClick);
		key.assertText(actualErrorMsgAfterLogin, expectedErrorMsgAfterLogin);
		
		//key.takeScreenshot();
	}
	
	/**
	 * This test case is used for to check test data reading using Property File
	 * @throws IOException
	 */
	@Test
	public void toVerifyLoginWithInvalidCredPropertyFile() throws IOException {
		
		key.waitElementToBePresent(getPropertyFileData(locatorFilePath,"userName"));
		key.enterText(getPropertyFileData(locatorFilePath,"userName"), getPropertyFileData(envDataFilePath, "invalidUserName"));
		key.enterText(getPropertyFileData(locatorFilePath,"password"), getPropertyFileData(envDataFilePath, "invalidPassword"));
		key.performClick(getPropertyFileData(locatorFilePath,"submit"));
		String expectedErrorMsgAfterLogin="Invalid credentials";
		key.waitElementToBePresent(getPropertyFileData(locatorFilePath,"invalidMsgAfterLoginClick"));
		String actualErrorMsgAfterLogin=key.getActualText(getPropertyFileData(locatorFilePath,"invalidMsgAfterLoginClick"));
		key.assertText(actualErrorMsgAfterLogin, expectedErrorMsgAfterLogin);
		
		//key.takeScreenshot();
	}
}
