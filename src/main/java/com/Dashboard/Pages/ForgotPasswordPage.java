package com.Dashboard.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Dashboard.Base.BaseClass;
import com.Dashboard.utill.ExpliciteWait;

public class ForgotPasswordPage extends BaseClass {
	
	@FindBy(linkText = "Forgot your password?")
	WebElement forgotPass;
	
	@FindBy(name = "email")
	WebElement registeredMail;
	
	@FindBy(className = "btn-block-sm")//due to compound class error I have removed btn btn-login class
	WebElement btnSendPassword;
	
	public ForgotPasswordPage() {
		
		PageFactory.initElements(driver, this);
	}
     public void validate_forgot_password() throws InterruptedException {
    	 
    	 forgotPass.click();
    	 registeredMail.sendKeys(property.getProperty("Registered_Mail"));
    	 btnSendPassword.click();
       //Explicit wait for alert
    	ExpliciteWait.waitForAlert_forgotPassword();
    	 
     }
}
