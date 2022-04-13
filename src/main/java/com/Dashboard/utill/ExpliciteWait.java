package com.Dashboard.utill;

import java.time.Duration;

import org.openqa.selenium.Alert;import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Dashboard.Base.BaseClass;

public class ExpliciteWait extends BaseClass {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 30;
	
	@FindBy(xpath  = "//div[@class='css-g1d714-ValueContainer']")
	WebElement albumCategory;
	
	//Dynamic wait for alert
	public static void waitForAlert_forgotPassword() {
		
		 WebDriverWait alertWait = new WebDriverWait(driver,Duration.ofSeconds(30));
	 		
    	 alertWait.until(ExpectedConditions.alertIsPresent());
    	 Alert alert = driver.switchTo().alert();
    	 String alertMsg = alert.getText();
    	 System.out.println("Alert Text : "+alertMsg);
    	 alert.accept();
		
	}
	public static void waitFor_albumCategory() {
		
		WebDriverWait categoryWait = new WebDriverWait(driver,Duration.ofSeconds(30));
		categoryWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='css-g1d714-ValueContainer']")));
	}
}
