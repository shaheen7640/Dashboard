package com.Dashboard.TestCases;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Dashboard.Base.BaseClass;
import com.Dashboard.Pages.ForgotPasswordPage;
import com.screenShot.ScreenShotListener;

@Listeners(ScreenShotListener.class)

public class ForgotPasswordTest extends BaseClass {
	
	ForgotPasswordPage forgotPassword;

	//ForgotPasswordTest forgotPasswordTest;
	
	ForgotPasswordTest(){
		super();
	}
	@BeforeClass
	public void setUp() {
		
		initialization();
		forgotPassword = new ForgotPasswordPage();
		//forgotPasswordTest = new ForgotPasswordTest();
	}
	@Test
	public void validate_forgotPassword() throws InterruptedException {
		
		forgotPassword.validate_forgot_password();
	}
	@AfterTest
	public void tearDown() throws InterruptedException {
		//to hold the script deliberately for 3 seconds
		Thread.sleep(3000);
		driver.quit();
		
	}
}
