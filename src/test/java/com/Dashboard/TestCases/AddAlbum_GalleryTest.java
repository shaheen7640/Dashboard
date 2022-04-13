package com.Dashboard.TestCases;

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
	String sheetName = property.getProperty("Add_newAlbum");
	
	public AddAlbum_GalleryTest() {
		
		super();
	}
	@BeforeClass
	public void setUp() {
		
		initialization();
		loginPage = new LoginPage();
		addAlubumPage = new AddAlbum_GalleryPage();
		homePage = loginPage.verify_User_Login(property.getProperty("UserName"), property.getProperty("Password"));
	}
	@DataProvider
	public Object[][] getTestDatafromExcel() {
		//Calling the getTestData function from ExcelUtil class
		Object data[][] = ExcelUtil.getTestData(sheetName);
		return data;
	}
	@Test(dataProvider = "getTestDatafromExcel")
	public void validate_view_album_label(String albumName) {
		
		addAlubumPage.view_album_lable();
		softAssert.assertEquals(AddAlbum_GalleryPage.lbl_AlbumText, property.getProperty("txtViewAlbum"),"View Album text is not appeared");
		//addAlubumPage.add_album();
	 addAlubumPage.add_album(albumName);
		softAssert.assertAll();
	}
	/*
	@Test
	public void validate_add_newAlbum() {
		//addAlubumPage.add_album();
	}*/
@AfterTest
public void tearDown() {
	
	//driver.quit();
}
}
