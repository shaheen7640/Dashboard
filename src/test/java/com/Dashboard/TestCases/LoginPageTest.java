package com.Dashboard.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Dashboard.Base.BaseClass;
import com.Dashboard.Pages.HomePage;
import com.Dashboard.Pages.LoginPage;
import com.Dashboard.utill.ExcelUtil;
import com.screenShot.ScreenShotListener;
@Listeners(ScreenShotListener.class)
public class LoginPageTest extends BaseClass {
	LoginPage loginPage;
	HomePage homePage; //Reference variable(page classes)
	String sheetName = property.getProperty("Excel_SheetName");
	//Constructor
	public LoginPageTest() {
		
		super();
	}
	@BeforeClass
	public void setUp() {
		
		//Calling initialization method from Base class
		initialization();
		//Creation of object of LoginPage class bcoz verify_LoginPageTitle is a non static function
		loginPage = new LoginPage();
	}
	/*
	@AfterMethod
	public void screenShot(ITestResult result) throws IOException {
	
	if(ITestResult.FAILURE==result.getStatus()) {
		takeScreenShot(result.getMethod().getMethodName());
		//System.out.println(result.getName());
	}
	}
	*/
	@Test(priority = 1)
	public void title_loginPage() throws IOException {
		
		
		String loginPageTitle = loginPage.verify_LoginPageTitle();
		System.out.println("Login Page Title: "+ loginPageTitle);
		Assert.assertEquals(loginPageTitle, property.getProperty("LoginTitle"));
	}
	@Test(priority = 2)
	public void validate_logoOnLoginPage() {
		
		boolean flag = loginPage.verify_Logo_On_LoginPage();
		Assert.assertTrue(flag);
		System.out.println("Logo appeared on login page");
	}
	@Test(priority = 3)
	public void validate_Forgot_Password() {
		
		String txtForgotPass = loginPage.verify_ForgotPasswordText_OnLoginPage();
		System.out.println("Forgot password text : "+txtForgotPass);
		Assert.assertEquals(txtForgotPass, property.getProperty("Forgot_Pass"));
	}
	@DataProvider
	public Object[][] getTestDatafromExcel() {
		//Calling the getTestData function from ExcelUtil class
		Object data[][] = ExcelUtil.getTestData(sheetName);
		return data;
	}
	@Test(priority = 4, dataProvider = "getTestDatafromExcel")
	public void validateUserLogin(String email, String password) {
	
		homePage = loginPage.verify_User_Login(email,password);
		//homePage = loginPage.verify_User_Login(property.getProperty("UserName"), property.getProperty("Pass"));		
		//loginPage.verify_User_Login(property.getProperty("UserName"), property.getProperty("Pass"));
		
		boolean flag = loginPage.verify_user_after_login();
		Assert.assertTrue(flag);
		System.out.println("User logged in");
	}
	@AfterTest
	public void tearDown()  {
		driver.quit();
		//driver=null;
	}

}
