package com.Dashboard.TestCases;





import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Dashboard.Base.BaseClass;
import com.Dashboard.Pages.HomePage;
import com.Dashboard.Pages.LoginPage;
import com.Dashboard.Pages.View_Monthly_AttendancePage;
import com.Dashboard.utill.ExcelUtil;
import com.screenShot.ScreenShotListener;

@Listeners(ScreenShotListener.class)

public class View_Monthly_AttendanceTest extends BaseClass {

	LoginPage obj_LoginPage;
	HomePage obj_HomePage;
	View_Monthly_AttendancePage obj_View_Monthly_Attendance;
	String sheetName = property.getProperty("sheetName_ViewMonthlyAttendance");


	public View_Monthly_AttendanceTest(){

		super();

	}
	@BeforeClass
	public void setUp() throws InterruptedException {

		initialization();

		obj_LoginPage = new LoginPage();
		obj_View_Monthly_Attendance = new View_Monthly_AttendancePage();
		obj_HomePage = obj_LoginPage.verify_User_Login(property.getProperty("UserName"), property.getProperty("Password"));

		//to hold the script deliberately for 5 seconds
		Thread.sleep(5000);

		//Validating home page
		String actualUrl = "http://192.168.0.27:5000/"; String expectedUrl =
				driver.getCurrentUrl();
		Assert.assertNotEquals(actualUrl,expectedUrl,"Email/Password is incorrect");
		System.out.println("User logged-in successfully");
	}
	@DataProvider
	public Object[][] getTestDatafromExcel() {
		//Calling the getTestData function from ExcelUtil class
		Object data[][] = ExcelUtil.getTestData(sheetName);
		return data;
	}
	@Test(dataProvider = "getTestDatafromExcel")
	public void verify_view_monthly_attendance(String year, String month) throws InterruptedException {

		obj_View_Monthly_Attendance.click_On_menuAdmin();
		Thread.sleep(2000);

		obj_View_Monthly_Attendance.click_On_submenu_View_Monthly_Attendance();

		String page_verification_Text=obj_View_Monthly_Attendance.verification_text.getText();
		String expectedText = "MONTH WISE ATTENDANCE RECORD";
		Assert.assertEquals(page_verification_Text,expectedText,"Monthly attendance page not visible, please check your internet connection/Credentials");
		System.out.println("You are on the attendance page: "+page_verification_Text);

		//Calling select duration function
		obj_View_Monthly_Attendance.select_duration(year, month);

		//Calling wait function
		obj_View_Monthly_Attendance.waitForAttendanceTable();
	}
	@AfterTest
	public void tearDown() throws InterruptedException {
		//to hold the script deliberately for 3 seconds
		Thread.sleep(3000);
		BaseClass.quit();
	}
}
