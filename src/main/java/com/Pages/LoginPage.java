package com.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.SkillioJava.Keywords;

public class LoginPage {

	//it identifies using id or name
	@FindBy
	WebElement username;

	// THis is using By class instance
	By userNameTxtBoxusingByClass= By.cssSelector("input[name='username']");
	
	// Identify WebElements
	@FindBy(css = "input[name='username']")
	WebElement userNameTxtBox;

	@FindBy(css = "input[name='password']")
	WebElement passwordTxtBox;

	@FindBy(css = "button[type='submit']")
	WebElement loginBtn;

	@FindBy(xpath = "//p[contains(@class,'oxd-text oxd-text--p orangehrm-login')]")
	WebElement forgotPasswordLink;

	@FindBy(xpath = "//h5[text()='Login']")
	WebElement loginTxt;
	
	@FindBy(css = "h6.oxd-text.oxd-text--h6")
	WebElement dashboardTxt;

	// WebElemnt Initialization

	public LoginPage() // constructor
	{
		PageFactory.initElements(Keywords.driver, this);
	}

	// Methods Creation


	
	public void enterUserName(String userName) {
		userNameTxtBox.sendKeys(userName);
	}

	public void enterPassword(String password) {
		passwordTxtBox.sendKeys(password);
	}

	public void clickOnLoginButton() {
		loginBtn.click();
	}

	public void clickOnForgotPasswordLink() {
		forgotPasswordLink.click();
	}

	public String getLoginText() {
		return loginTxt.getText();
	}
	
	public String getDashboardText() {
		return dashboardTxt.getText();
	}

	public void waitForUserNameToBeVisible() {
		 Keywords.wait.until(ExpectedConditions.visibilityOf(userNameTxtBox));
	}
	
	public void waitForDashboardTextToBeVisible() {
		 Keywords.wait.until(ExpectedConditions.visibilityOf(dashboardTxt));
	}
	
	public void implicitWait() {
		Keywords.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}
	

}
