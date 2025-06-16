package com.SkillioJava;

public interface TestData {

	String appURL="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	String browserName="chrome";
	
	//valid test data
	String userName="Admin";
	String password="admin123";
	
	//invalid test data
	String invalidUserName="Admin123";
	String invalidPassword="admin12345";
}
