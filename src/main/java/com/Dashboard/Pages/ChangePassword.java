package com.Dashboard.Pages;


import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Dashboard.Base.BaseClass;


public class ChangePassword extends BaseClass {

	@FindBy(css = "ul.navbar-nav.mr-auto.nav-grp-left-pad>li:nth-of-type(5)>a")
	public WebElement myProfile;

	//@FindBy(xpath = "//a[@class='dd-link dd-link-selected' and text()='Change Password']")
	@FindBy(css = "#navbarText > div > ul > li:nth-child(5) > ul > li:nth-child(4) > a")
	WebElement menu_changePassword;

	@FindBy(name = "oldPassword")
	WebElement txtOldpass;

	@FindBy(name = "newPassword")
	WebElement txtNewPass;

	@FindBy(name = "confirmPassword")
	WebElement txtCnfPass;

	@FindBy(css = "h4.pb-2.txt-black.col-lg-12")
	public WebElement lblChangePass;

	@FindBy(css = "button.btn.btn-primary.btn-lg")
	WebElement btnSubmit;

	@FindBy(xpath = "//button[@class='btn btn-primary btn-lg' and text()='SIGN IN']")
	WebElement btnSignIn;

	public ChangePassword(){

		PageFactory.initElements(driver, this);
	}
	public boolean verify_Menu() {

		return myProfile.isDisplayed();
	}

	public void click_On_MyProfile() {

		myProfile.click();
	}
	public void validate_ChangePassword(String oldPass, String newPass, String cnfPass) {

		Actions action = new Actions(driver);
		action.moveToElement(menu_changePassword).click().build().perform();		

		txtOldpass.sendKeys(oldPass);
		txtNewPass.sendKeys(newPass);
		txtCnfPass.sendKeys(cnfPass);
		btnSubmit.click();

		/*
		 * try { waitForAlert();
		 * 
		 * System.out.println("Kindly check if you are giving valid old/new password.");
		 * } catch (Exception e) {
		 * 
		 * e.printStackTrace(); }
		 */

		try { 
			WebDriverWait alertWait = new WebDriverWait(driver,Duration.ofSeconds(30));

			if(alertWait.until(ExpectedConditions.alertIsPresent())==null) {
				System.out.println("No alert present"); 
			} 
			else
			{
				Alert alert =  driver.switchTo().alert();
				String alertText= alert.getText();
				System.out.println("Alert Text : "+alertText);
				alert.accept();
			} 
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("Kindly check if you are giving valid old/new password."); 
		}
	}
	public boolean waitForLabel() {
		//WebDriverWait labelWait = new WebDriverWait(driver,Duration.ofSeconds(20));

		//labelWait.until(ExpectedConditions.visibilityOf(lblChangePass)).isDisplayed();
		return lblChangePass.isDisplayed();
	}
	public boolean btnSignIn() {

		return btnSignIn.isDisplayed();
	}

	/*
	 * public boolean waitForAlert() {
	 * 
	 * 
	 * WebDriverWait alertWait = new WebDriverWait(driver,Duration.ofSeconds(30));
	 * alertWait.until(ExpectedConditions.alertIsPresent()); Alert alert =
	 * driver.switchTo().alert();
	 * 
	 * String alertMsg = alert.getText();
	 * System.out.println("Alert Text : "+alertMsg); alert.accept(); return true;
	 * 
	 * 
	 * }
	 */

}
