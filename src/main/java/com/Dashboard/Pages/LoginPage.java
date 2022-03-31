package com.Dashboard.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Dashboard.Base.BaseClass;

public class LoginPage extends BaseClass{
	
	//Page Factory -OR(Object Repository)
    @FindBy(name="username")
    WebElement username;
    
    @FindBy(name="password")
    WebElement password;
    
    @FindBy(xpath = "//button[@type='submit' and text()='Log in']")
    WebElement loginbtn;
    
    @FindBy(css = "a.nav-link>img.img-fluid")
    WebElement logo_LoginPage;
    
    @FindBy(css = "a.darkbluelink")
    WebElement forgotPaswrd_linktext;
    

    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    WebElement btnLogout;
    
    @FindBy(css = "a.navbar-brand>img")
	WebElement homePage_Logo;
    
    //Constructor
    public LoginPage() {
    	
   //Initializing page factory by using initElements() with current(this) class object e.g. username, password, logo and forgotpaswrd_linkText
    	PageFactory.initElements(driver, this);
        }
    public String verify_LoginPageTitle() {
    	
    	return driver.getTitle();
    }
    public boolean verify_Logo_On_LoginPage() {
    	
    	return logo_LoginPage.isDisplayed();
    }
    public boolean verify_user_after_login() {
    	
    	return homePage_Logo.isDisplayed();
    }
    //this function contains HomePage return type
    public HomePage verify_User_Login(String usrName, String pwd) {
    	
    	username.sendKeys(usrName);
    	password.sendKeys(pwd);
    	loginbtn.click();
    //	btnLogout.click();
    	//Returns the HomePage class object bcoz after login user will redirect to home page
    	return new HomePage();
    }
    /*public boolean verify_user_after_login() {
    	
    	
    	System.out.println(notification);
    	return notification.isDisplayed();
    	
    }*/
     /*public void verify_User_Login(String usrName, String pwd) {
    	
    	username.sendKeys(usrName);
    	password.sendKeys(pwd);
    	loginbtn.click();
    	//Returns the HomePage class object bcoz after login user will redirect to home page
    	//return new HomePage();
    }*/
}
