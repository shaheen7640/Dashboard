package com.Dashboard.TestCases;



import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.Dashboard.Base.BaseClass;
import com.Dashboard.Pages.HomePage;
import com.Dashboard.Pages.LoginPage;
import com.screenShot.ScreenShotListener;
//import com.Dashboard.utill.ExcelUtil;
@Listeners(ScreenShotListener.class) 

public class HomePageTest extends BaseClass {
	
	LoginPage loginPage;
	HomePage homePage;
	LoginPageTest loginPageTest;
	String usrName;
	String pwd;
	String sheetName = property.getProperty("Excel_SheetName");
	SoftAssert softAssertion = new SoftAssert();
	
	public HomePageTest(){
		//Calling base class constructor to load the property file
		super();
	}
	
	@BeforeClass
	public void setUp() {
		initialization();
		loginPage=new LoginPage();
	//	loginPageTest = new LoginPageTest();
	//	loginPageTest.getTestDatafromExcel();
		
	}
	
	@Test
	public void verify_all_menu() {
		homePage = loginPage.verify_User_Login(property.getProperty("UserName"),property.getProperty("Password"));
		String homePageTitle = homePage.verify_HomePageTitle();
		softAssertion.assertEquals(homePageTitle,property.getProperty("Title_HomePage"), "Home page title is mismatch/not appeared");
		System.out.println("Home Page Title: "+homePageTitle);
		
		homePage.verify_Logo_On_HomePage();
		boolean homeLogo = homePage.verify_Logo_On_HomePage();
		softAssertion.assertEquals(homeLogo,true,"Logo is missing on home page");
		
		if(homeLogo == true)
		{
			System.out.println("Logo is available on Home page");
		}
		else
		{
			System.out.println("Logo is missing on Home page");
		}
			//Home
	    homePage.verify_menu_Home();
		String menuHome = homePage.verify_menu_Home();
		//softAssertion.assertEquals(menuHome,true,"Menu Home not visible");
		softAssertion.assertEquals(menuHome,property.getProperty("Home_Label"),"Menu Home not visible");
	   
		//System.out.println(property.getProperty("Home_Label"));
		
		//RMS
		homePage.verify_menu_RMS();
		String menuRms = homePage.verify_menu_RMS();
		softAssertion.assertEquals(menuRms,property.getProperty("RMS_Label"),"Menu RMS not visible");
		
		
		//Ticket
		homePage.verify_menu_Ticket();
		String menuTicket = homePage.verify_menu_Ticket();
		softAssertion.assertEquals(menuTicket,property.getProperty("Ticket_Label"),"Menu Ticket not visible");
		
		
		//Gallery
		homePage.verify_HomePageTitle();
		String menuGallery = homePage.verify_menu_Gallery();
		softAssertion.assertEquals(menuGallery,property.getProperty("Gallery_Label"),"Menu Gallery not visible");
		
		
	         	//MyProfile
				homePage.verify_menu_MyProfile();
				String menuMyProfile = homePage.verify_menu_MyProfile();
				softAssertion.assertEquals(menuMyProfile,property.getProperty("MyProfile_Label"),"Menu MyProfile not visible");
				
				
				//DSR
				homePage.verify_menu_DSR();
				String menuDsr = homePage.verify_menu_DSR();
				softAssertion.assertEquals(menuDsr,property.getProperty("DSR_Label"),"Menu DSR not visible");
				
				
				//Admin
				homePage.verify_menu_Admin();
				String menuAdmin = homePage.verify_menu_Admin();
				softAssertion.assertEquals(menuAdmin,property.getProperty("Admin_Label"),"Menu Admin not visible");
				
				
				//Logout
				homePage.verify_menu_Logout();
				String menuLogout = homePage.verify_menu_Logout();
				softAssertion.assertEquals(menuLogout,property.getProperty("Logout_Label"),"Menu Logout not visible");
				
				
		softAssertion.assertAll();
	}
	@AfterTest
	public void tearDown() {
		
	driver.quit();
	//driver=null;
	}
/*	@AfterMethod
	public void screenShot(ITestResult result) throws IOException {
	
	if(ITestResult.FAILURE==result.getStatus()) {
		takeScreenShot();
		System.out.println(result.getName());
	}
	//driver.quit();
	//driver=null;
	
}*/
}
