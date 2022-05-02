package com.Dashboard.TestCases;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Dashboard.Base.BaseClass;
import com.Dashboard.Pages.ChangePassword;
import com.Dashboard.Pages.HomePage;
import com.Dashboard.Pages.LoginPage;
import com.Dashboard.utill.ExcelUtil;

import com.screenShot.ScreenShotListener;

@Listeners(ScreenShotListener.class)

public class ChangePasswordTest extends BaseClass {

	LoginPage loginPage;
	HomePage homePage;
	ChangePassword changePassword;
	String sheetName = property.getProperty("sheetName_changePass");
	SoftAssert softAssert = new SoftAssert();

	public ChangePasswordTest(){

		super();
	}
	@BeforeClass
	public void setUp() throws InterruptedException {

		initialization();
		loginPage = new LoginPage();
		changePassword = new ChangePassword();
		homePage = loginPage.verify_User_Login(property.getProperty("UserName"), property.getProperty("Password"));
		
		//to hold the script deliberately for 5 seconds
				Thread.sleep(5000);
	}

	@DataProvider
	public Object[][] getTestDatafromExcel(){

		Object data[][] = ExcelUtil.getTestData(sheetName) ;

		return data;
	}
	@Test(dataProvider = "getTestDatafromExcel")
	public void varify_ChangePassword(String oldPass, String newPass, String cnfPass) {

		//Verifying the my profile menu
		Boolean myProfile = changePassword.verify_Menu();
		Assert.assertTrue(myProfile,"Menu not appeared");
		System.out.println("Menu appeared");

        //Clicking on my profile menu
		changePassword.click_On_MyProfile();

		//Calling validate_ChangePassword function
		changePassword.validate_ChangePassword(oldPass,newPass,cnfPass);
		
		//Verifying label
		//	boolean myLabel =changePassword.waitForLabel();
		//	softAssert.assertTrue(myLabel, "Change Password text not visible");
		//	System.out.println("Change Password text: "+changePassword.lblChangePass.getText());
		//softAssert.assertEquals(changePassword.lblChangePass.getText(), "Change Password");
		//System.out.println("Change password text: "+changePassword.lblChangePass.getText());

		boolean btnSignIn = changePassword.btnSignIn();
		Assert.assertTrue(btnSignIn, "Kindly check the credentials");
		System.out.println("Sign In button visible");
		softAssert.assertAll();

		//changePassword.waitForAlert();
		/*
		 * boolean myAlert = changePassword.waitForAlert(); Assert.assertEquals(myAlert,
		 * myAlert);
		 */
	}
	@AfterClass
	public void tearDown() throws InterruptedException {
		//to hold the script deliberately for 5 seconds
				Thread.sleep(5000);
		driver.quit();
	}
}
