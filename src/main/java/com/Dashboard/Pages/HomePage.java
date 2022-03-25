package com.Dashboard.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Dashboard.Base.BaseClass;

public class HomePage extends BaseClass{
	
	@FindBy(xpath = "//img[@src='/images/logo-blk.png']")
	WebElement homePage_Logo;
    
	@FindBy(xpath = "//a[@class='nav-link-col3 mr-1 activeHeader3 nav-anchor' and text()='Home']")
    WebElement menu_Home;
	
	@FindBy(xpath ="//a[@class='nav-link-col2 mr-1 nav-anchor' and text()='RMS']")
	WebElement menu_RMS;
			
	@FindBy(xpath = "//a[@class='nav-link-col1 mr-1 nav-anchor' and text()='Ticket']")
	WebElement menu_Ticket;
	
	@FindBy(xpath = "//a[@class='nav-link-col3 mr-1 nav-anchor' and text()='Gallery']")
	WebElement menu_Gallery;
	
	@FindBy(xpath = "//a[contains(text(),'My Profile')]")
	WebElement menu_MyProfile;
	
	@FindBy(xpath = "//a[contains(text(),'DSR')]")
	WebElement menu_DSR;
	
	@FindBy(xpath = "//a[contains(text(),'Admin')]")
	WebElement menu_Admin;
	
	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	WebElement menu_Logout;
	
	@FindBy(xpath = "//div[@class='user-img anim-user-image']")
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
	public boolean verify_menu_Home() {
		
		return menu_Home.isDisplayed();
		
	}
	public boolean verify_menu_RMS() {
		
		return menu_RMS.isDisplayed();
	}
	public boolean verify_menu_Ticket() {
		
		return menu_Ticket.isDisplayed();
	}
	public boolean verify_menu_Gallery() {
		
		return menu_Gallery.isDisplayed();
	}
	public boolean verify_menu_MyProfile() {
		
		return menu_MyProfile.isDisplayed();
	}
	public boolean verify_menu_DSR() {
		
		return menu_DSR.isDisplayed();
	}
	
	public boolean verify_menu_Admin() {
		
		return menu_Admin.isDisplayed();
	}
	public boolean verify_menu_Logout() {
		
		return menu_Logout.isDisplayed();
	}
}
