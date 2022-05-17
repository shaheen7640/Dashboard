package com.Dashboard.TestCases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Dashboard.Base.BaseClass;
import com.Dashboard.Pages.HomePage;
import com.Dashboard.Pages.LoginPage;

public class Sample extends BaseClass{
	LoginPage obj_LoginPage;
	HomePage obj_HomePage;
	//View_Monthly_AttendancePage obj_View_Monthly_Attendance;\
	Sample obj_Sample;
	
	public Sample() {
		super();
	}
	@BeforeClass
	public void setUp() {

		initialization();
		obj_LoginPage = new LoginPage();
		
		//obj_Sample = new obj_Sample();
		obj_HomePage = obj_LoginPage.verify_User_Login(property.getProperty("UserName"), property.getProperty("Password"));
	}
	
	@Test
	public void launchGoogle() {
		
		System.out.println("inside - launch google method");
	}
	
	@AfterTest
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		BaseClass.quit();
				
	}

}
