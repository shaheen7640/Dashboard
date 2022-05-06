package com.Dashboard.TestCases;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Dashboard.Base.BaseClass;
import com.Dashboard.Pages.AddAlbum_GalleryPage;
import com.Dashboard.Pages.HomePage;
import com.Dashboard.Pages.LoginPage;
import com.Dashboard.utill.ExcelUtil;
import com.screenShot.ScreenShotListener;

@Listeners(ScreenShotListener.class)
public class AddAlbum_GalleryTest extends BaseClass {

	HomePage homePage;
	LoginPage loginPage;
	AddAlbum_GalleryPage addAlubumPage;
	SoftAssert softAssert = new SoftAssert();
	String sheetName = property.getProperty("sheetName_AddAlbum");

	public AddAlbum_GalleryTest() {

		super();
	}
	@BeforeClass
	public void setUp() throws InterruptedException {

		initialization();
		loginPage = new LoginPage();
		addAlubumPage = new AddAlbum_GalleryPage();
		homePage = loginPage.verify_User_Login(property.getProperty("UserName"), property.getProperty("Password"));

		//to hold the script deliberately for 5 seconds
		Thread.sleep(5000);
	}
	@DataProvider
	public Object[][] getTestDatafromExcel() {
		//Calling the getTestData function from ExcelUtil class
		Object data[][] = ExcelUtil.getTestData(sheetName);
		return data;
	}
	@Test(dataProvider = "getTestDatafromExcel")
	public void uploading_Album(String albumName, String description) throws AWTException {

		addAlubumPage.view_album_lable();
		softAssert.assertEquals(AddAlbum_GalleryPage.lbl_AlbumText, property.getProperty("txtViewAlbum"),"View Album text is not appeared");
		//addAlubumPage.add_album();
		addAlubumPage.add_album(albumName,description);
		softAssert.assertAll();

		boolean flag = addAlubumPage.imageUploadVerification();

		Assert.assertTrue(flag);
		System.out.println("Image container visible");
		
		
			//Calling upload function
			addAlubumPage.uploadAlbum();
			

		String actualText =  driver.findElement(By.xpath("//button[@class='btn btn-primary' and text()='Close']")).getText();
		System.out.println("Verification text : "+actualText);
		String expectedText ="CLOSE";
		Assert.assertEquals(actualText,expectedText,"Album not uploaded, kindly create the album with a unique name");

		/*
    	//Getting upload button text for assertion
		String actualText = driver.findElement(By.xpath("//div[@class='col-lg-12 text-center mt-4']")).getText();
		System.out.println("Verification text : "+actualText);
		String expectedText ="UPLOAD NOW";
		Assert.assertEquals(actualText, expectedText,"Album not uploaded, kindly create the album with a unique name");

		System.out.println("Album uploaded successfully");
		//addAlubumPage.clickOnClose();
		 */
	}
	@AfterTest
	public void tearDown() throws InterruptedException {
		//to hold the script deliberately for 5 seconds
		Thread.sleep(5000);
		driver.quit();
	}
}
