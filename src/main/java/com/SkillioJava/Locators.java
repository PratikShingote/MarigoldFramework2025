package com.SkillioJava;

public interface Locators {
	//variables by default public, static, final = 
	//public - you can access anywhere, 
	//static - only one copy created
	//final - you can't change only here you can change

	String userName= "//input[@name='username']";
	String password= "//input[@name='password']";
	String submit= "//button[@type='submit']";
	String dashboardText= "//h6[text()='Dashboard']";
	String logoutDropDown= "//i[contains(@class,'oxd-icon bi-caret')]";
	String logoutOption= "//a[text()='Logout']";
	
	String aboutClass= "oxd-userdropdown-link";
	String aboutClassClose= "oxd-dialog-close-button";
	
	String aboutCloseCSSJS= "button.oxd-dialog-close-button";
	
	String invalidMsgAfterLoginClick="//p[text()='Invalid credentials']";
}
