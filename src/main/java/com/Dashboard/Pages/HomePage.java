package com.Dashboard.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Dashboard.Base.BaseClass;

public class HomePage extends BaseClass{
	
	@FindBy(css = "a.navbar-brand>img")
	 WebElement homePage_Logo;
    
	//@FindBy(xpath = "//a[@class='nav-link-col3 mr-1 activeHeader3 nav-anchor' and text()='Home']")
	@FindBy(css = "ul.navbar-nav.mr-auto.nav-grp-left-pad>li:nth-of-type(1)>a")
    WebElement menu_Home;
	
	//@FindBy(xpath ="//a[@class='nav-link-col2 mr-1 nav-anchor' and text()='RMS']")
	@FindBy(css = "ul.navbar-nav.mr-auto.nav-grp-left-pad>li:nth-of-type(2)>a")
	WebElement menu_RMS;
			
	//@FindBy(xpath = "//a[@class='nav-link-col1 mr-1 nav-anchor' and text()='Ticket']")
	@FindBy(css = "ul.navbar-nav.mr-auto.nav-grp-left-pad>li:nth-of-type(3)>a")
	WebElement menu_Ticket;
	
	//@FindBy(xpath = "//a[@class='nav-link-col3 mr-1 nav-anchor' and text()='Gallery']")
	@FindBy(css = "ul.navbar-nav.mr-auto.nav-grp-left-pad>li:nth-of-type(4)>a")
	WebElement menu_Gallery;
	
	//@FindBy(xpath = "//a[contains(text(),'My Profile')]")
	@FindBy(css = "ul.navbar-nav.mr-auto.nav-grp-left-pad>li:nth-of-type(5)>a")
	WebElement menu_MyProfile;
	
	//@FindBy(xpath = "//a[contains(text(),'DSR')]")
	@FindBy(css = "ul.navbar-nav.mr-auto.nav-grp-left-pad>li:nth-of-type(6)>a")
	WebElement menu_DSR;
	
	//@FindBy(xpath = "//a[contains(text(),'Admin')]")
	@FindBy(css = "ul.navbar-nav.mr-auto.nav-grp-left-pad>li:nth-of-type(7)>a")
	WebElement menu_Admin;
	
	//@FindBy(xpath = "//a[contains(text(),'Logout')]")
	@FindBy(css = "ul.navbar-nav.mr-auto.nav-grp-left-pad>li:nth-of-type(8)>a")
	WebElement menu_Logout;
	
	//@FindBy(xpath = "//div[@class='user-img anim-user-image']")
	@FindBy(css = "ul.navbar-nav.mr-auto.nav-grp-left-pad>li:nth-of-type(9)>a")
	WebElement user_Picture;
	
	//Initialize all the elements/objects inside the constructor
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	  public String verify_HomePageTitle() {
	    	
	    	return driver.getTitle();
	    }
	    public boolean verify_Logo_On_HomePage() {
	    	
	    	return homePage_Logo.isDisplayed();
	    }
	    
	    public String verify_menu_Home() {
			String txthome=menu_Home.getText();
			System.out.println(txthome);
			return txthome;
			
		}
	public String verify_menu_RMS() {
		String txtRMS=menu_RMS.getText();
		System.out.println(txtRMS);
		return txtRMS;
		
	}
	public String verify_menu_Ticket() {
		
		String txtTicket=menu_Ticket.getText();
		System.out.println(txtTicket);
		return txtTicket;
	}
	public String verify_menu_Gallery() {
		
		String txtGallery=menu_Gallery.getText();
		System.out.println(txtGallery);
		return txtGallery;
	}
	public String verify_menu_MyProfile() {
		
		String txtMyProfile=menu_MyProfile.getText();
		System.out.println(txtMyProfile);
		return txtMyProfile;
	}
	public String verify_menu_DSR() {
		
		String txtDsr=menu_DSR.getText();
		System.out.println(txtDsr);
		return txtDsr;
	}
	
	public String verify_menu_Admin() {
		
		String txtAdmin=menu_Admin.getText();
		System.out.println(txtAdmin);
		return txtAdmin;
	}
	public String verify_menu_Logout() {
		

		String txtLogout=menu_Logout.getText();
		System.out.println(txtLogout);
		return txtLogout;
	}
}
