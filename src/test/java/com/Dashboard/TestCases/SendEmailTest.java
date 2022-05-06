package com.Dashboard.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Dashboard.Base.BaseClass;
import com.Dashboard.Pages.HomePage;
import com.Dashboard.Pages.LoginPage;
import com.Dashboard.Pages.SendEmailPage;
import com.Dashboard.utill.ExcelUtil;
import com.screenShot.ScreenShotListener;


@Listeners(ScreenShotListener.class)
public class SendEmailTest extends BaseClass{

	LoginPage obj_LoginPage;
	HomePage obj_HomePage;
	SendEmailPage obj_sendEmailPage;
	String sheetName = property.getProperty("sheetName_SendEmail");
	SoftAssert softAssert = new SoftAssert();

	public SendEmailTest() {

		super();
	}

	@BeforeClass
	public void setUp() throws InterruptedException {

		initialization();
		obj_LoginPage = new LoginPage();
		obj_sendEmailPage = new SendEmailPage();
		obj_HomePage = obj_LoginPage.verify_User_Login(property.getProperty("UserName"), property.getProperty("Password"));

		//to hold the script deliberately for 5 seconds
		Thread.sleep(5000);
	}
	@DataProvider
	public Object[][] getTestDatafromExcel(){

		Object data[][] = ExcelUtil.getTestData(sheetName) ;

		return data;
	}
	@Test(priority = 1, dataProvider = "getTestDatafromExcel")
	public void verify_send_email(String txt_To, String txt_Bcc, String txt_CC, String txt_Subject,String txt_Body) throws InterruptedException {


		boolean disp_menuAdmin = obj_sendEmailPage.verify_menuAdmin();
		Assert.assertTrue(disp_menuAdmin,"Menu Admin not visible");
		System.out.println("Menu Admin visible");

		obj_sendEmailPage.click_On_menuAdmin();

		boolean disp_EmailLink = obj_sendEmailPage.verify_emailLink();
		Assert.assertTrue(disp_EmailLink,"Email link not visible");
		System.out.println("Clicked on Email link");

		obj_sendEmailPage.click_On_EmailLink();

		String lbl_sendEmail = obj_sendEmailPage.lbl_SendEmail.getText();
		softAssert.assertEquals(lbl_sendEmail, "SEND EMAIL");
		System.out.println("Verification text: "+lbl_sendEmail);
		softAssert.assertAll();

		obj_sendEmailPage.sendEmail(txt_To, txt_Bcc, txt_CC, txt_Subject,txt_Body);


		//obj_sendEmailPage.btn_SendMail();
	}
	@Test(priority = 2)
	public void verify_email_confirmation_popup() throws InterruptedException {
		obj_sendEmailPage.btn_Send.click();

		Thread.sleep(3000);

		obj_sendEmailPage.wait_for_alert();
		/*
		 * WebDriverWait alertWait = new WebDriverWait(driver,Duration.ofSeconds(30));
		 * 
		 * //Validating email confirmation popup Assert.assertEquals(alertWait,
		 * alertWait,"Mail not sent, Kindly check the data in excel file, All six input fields are mandatory in excel"
		 * );
		 * 
		 * if(alertWait.until(ExpectedConditions.alertIsPresent())==null) {
		 * System.out.println("No alert present"); } else { Alert alert =
		 * driver.switchTo().alert(); String alertText= alert.getText();
		 * System.out.println("Alert Text : "+alertText); alert.accept();
		 * 
		 * }
		 */

	}
	@AfterClass
	public void tearDown() throws InterruptedException {
		//to hold the script deliberately for 5 seconds
				Thread.sleep(5000);
		driver.quit();
	}

}
