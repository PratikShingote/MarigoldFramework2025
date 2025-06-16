package com.PageObjectModelTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.Pages.LoginPage;
import com.SkillioJava.BaseClass;
import com.SkillioJava.Keywords;
import listenersUtility.MyListener;
import static propertiesUtility.PropertiesUtil.*;
import java.io.IOException;

@Listeners(MyListener.class)


public class LoginPageTC extends BaseClass{
	
	LoginPage loginpage;
	Keywords keyword;
	
	@Test
	public void toVerifySuccessfulLogin() throws IOException {
		loginpage=new LoginPage();
		keyword=new Keywords();
		
		loginpage.implicitWait();
		loginpage.waitForUserNameToBeVisible();
		String actualLoginText=loginpage.getLoginText();
		keyword.assertText(actualLoginText, "Login"); // act vs exp
		loginpage.enterUserName(getPropertyFileData(envDataFilePath, "userName"));
		loginpage.enterPassword(getPropertyFileData(envDataFilePath, "password"));
		loginpage.clickOnLoginButton();
		
		loginpage.waitForDashboardTextToBeVisible();
		String actualDashboardText=loginpage.getDashboardText();
		keyword.assertText(actualDashboardText, "Dashboard"); // act vs exp
	}
}
