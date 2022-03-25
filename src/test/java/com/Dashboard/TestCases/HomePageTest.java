package com.Dashboard.TestCases;


import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Dashboard.Base.BaseClass;
import com.Dashboard.Pages.HomePage;
import com.Dashboard.Pages.LoginPage;
//import com.Dashboard.utill.ExcelUtil;


public class HomePageTest extends BaseClass {
	
	LoginPage loginPage;
	HomePage homePage;
	LoginPageTest loginPageTest;
	String usrName;
	String pwd;
	String sheetName = property.getProperty("Excel_SheetName");
	SoftAssert softAssertion = new SoftAssert();
	
	HomePageTest(){
		//Calling base class constructor to load the property file
		super();
	}
	
	@BeforeMethod()
	public void setUp() {
		initialization();
		loginPage=new LoginPage();
		loginPageTest = new LoginPageTest();
	//	loginPageTest.getTestDatafromExcel();
		homePage = loginPage.verify_User_Login(property.getProperty("UserName"),property.getProperty("Password"));
	}
	
	
	
	@Test
	public void verify_all_menu() {
		
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
		boolean menuHome = homePage.verify_menu_Home();
		softAssertion.assertEquals(menuHome,true,"Menu Home not visible");
		System.out.println(property.getProperty("Home_Label"));
		
		//RMS
		homePage.verify_menu_RMS();
		boolean menuRms = homePage.verify_menu_RMS();
		softAssertion.assertEquals(menuRms,true,"Menu RMS not visible");
		System.out.println(property.getProperty("RMS_Label"));
		
		//Ticket
		homePage.verify_menu_Ticket();
		boolean menuTicket = homePage.verify_menu_Ticket();
		softAssertion.assertEquals(menuTicket,true,"Menu Ticket not visible");
		System.out.println(property.getProperty("Ticket_Label"));
		
		//Gallery
		homePage.verify_HomePageTitle();
		boolean menuGallery = homePage.verify_menu_Gallery();
		softAssertion.assertEquals(menuGallery,true,"Menu Gallery not visible");
		System.out.println(property.getProperty("Gallery_Label"));
		
		//MyProfile
				homePage.verify_menu_MyProfile();
				boolean menuMyProfile = homePage.verify_menu_MyProfile();
				softAssertion.assertEquals(menuMyProfile,true,"Menu MyProfile not visible");
				System.out.println(property.getProperty("MyProfile_Label"));
				
				//DSR
				homePage.verify_menu_DSR();
				boolean menuDsr = homePage.verify_menu_DSR();
				softAssertion.assertEquals(menuDsr,true,"Menu DSR not visible");
				System.out.println(property.getProperty("DSR_Label"));
				
				//Admin
				homePage.verify_menu_Admin();
				boolean menuAdmin = homePage.verify_menu_Admin();
				softAssertion.assertEquals(menuAdmin,true,"Menu Admin not visible");
				System.out.println(property.getProperty("Admin_Label"));
				
				//Logout
				homePage.verify_menu_Logout();
				boolean menuLogout = homePage.verify_menu_Logout();
				softAssertion.assertEquals(menuLogout,true,"Menu Logout not visible");
				System.out.println(property.getProperty("Logout_Label"));
				
		softAssertion.assertAll();
	}
	
}
