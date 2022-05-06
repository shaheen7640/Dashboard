package com.Dashboard.Pages;


import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Dashboard.Base.BaseClass;

public class SendEmailPage extends BaseClass {

	@FindBy(css = "ul.navbar-nav.mr-auto.nav-grp-left-pad>li:nth-of-type(7)>a")
	WebElement menu_Admin;

	@FindBy(css ="#navbarText > div > ul > li.nav-item.dropdown.show > ul > li:nth-child(11) > a")
	WebElement link_Email;

	@FindBy(className = "head-title1")
	public WebElement lbl_SendEmail;

	@FindBy(css = "div.layout-width.layout-width-height>div>div>div:nth-child(2)>div:nth-child(1) > div:nth-child(1) > input")
	WebElement txtBox_To;

	@FindBy(css = "div.layout-width.layout-width-height>div>div>div:nth-child(2)>div:nth-child(1) > div:nth-child(2) > input")
	WebElement txtBox_Bcc;

	@FindBy(css = "div.layout-width.layout-width-height>div>div>div:nth-child(2)>div:nth-child(1) > div:nth-child(3) > input")
	WebElement txtBox_CC;

	@FindBy(name = "subject")
	WebElement txtBox_Subject;

	@FindBy(xpath = "//div[starts-with(@id,'cke_1_contents')]//iframe")
	WebElement email_BodyArea;
	
	@FindBy(css = ".btn.btn-primary.btn-lg.mr-3")
	public WebElement btn_Send;

	public SendEmailPage() {

		PageFactory.initElements(driver, this);
	}

	public boolean verify_menuAdmin() {

		return menu_Admin.isDisplayed();
	}
	public boolean verify_emailLink() {

		return link_Email.isDisplayed();
	}
	public void click_On_menuAdmin() {
		menu_Admin.click();
	}
	public void click_On_EmailLink() {
		link_Email.click();
	}                                                       
	public void sendEmail(String txt_To, String txt_Bcc, String txt_CC, String txt_Subject, String txt_Body) throws InterruptedException {

		
			txtBox_To.sendKeys(txt_To);
			driver.findElement(By.cssSelector("div.layout-width.layout-width-height>div>div>div:nth-child(2)>div:nth-child(1) > div:nth-child(1) > input"))
			.sendKeys(Keys.ENTER);
			txtBox_Bcc.sendKeys(txt_Bcc);
			driver.findElement(By.cssSelector("div.layout-width.layout-width-height>div>div>div:nth-child(2)>div:nth-child(1) > div:nth-child(2) > input"))
			.sendKeys(Keys.ENTER);
			txtBox_CC.sendKeys(txt_CC);
			driver.findElement(By.cssSelector("div.layout-width.layout-width-height>div>div>div:nth-child(2)>div:nth-child(1) > div:nth-child(3) > input"))
			.sendKeys(Keys.ENTER);
			txtBox_Subject.sendKeys(txt_Subject);
			Thread.sleep(3000);
			//driver.switchTo().frame("Rich Text Editor, editor1");

			// WebElement iframe = driver.findElement(By.xpath("/html/body/p"));
			//driver.switchTo().frame(iframe);

			//		WebDriverWait waitForMessage = new WebDriverWait(driver,Duration.ofSeconds(30));
			//		waitForMessage.until(ExpectedConditions.elementToBeClickable(email_BodyArea));

			//Focus on email body area
			driver.findElement(By.xpath("//div[starts-with(@id,'cke_1_contents')]//iframe")).sendKeys(Keys.TAB);
			email_BodyArea.sendKeys(txt_Body);
			//Thread.sleep(5000);
			//btn_Send.click();	
	      
	}
	public void wait_for_alert() {
		
		  WebDriverWait alertWait = new WebDriverWait(driver,Duration.ofSeconds(30));
		  
		  //Validating email confirmation popup
		  Assert.assertEquals(alertWait,
		  alertWait,"Mail not sent, Kindly check the data in excel file, All six input fields are mandatory in excel"
		  );
		  
		  if(alertWait.until(ExpectedConditions.alertIsPresent())==null) {
		  System.out.println("No alert present"); } else { Alert alert =
		  driver.switchTo().alert(); String alertText= alert.getText();
		  System.out.println("Alert Text : "+alertText); alert.accept();
		  
		  }
		 
		 
	}
}
