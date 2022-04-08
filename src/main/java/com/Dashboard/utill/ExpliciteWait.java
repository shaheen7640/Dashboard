package com.Dashboard.utill;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Dashboard.Base.BaseClass;

public class ExpliciteWait extends BaseClass {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 30;
	
	
	//Dynamic wait for alert
	public static void waitForAlert_forgotPassword() {
		
		 WebDriverWait alertWait = new WebDriverWait(driver,Duration.ofSeconds(30));
	 		
    	 alertWait.until(ExpectedConditions.alertIsPresent());
    	 Alert alert = driver.switchTo().alert();
    	 String alertMsg = alert.getText();
    	 System.out.println("Alert Text : "+alertMsg);
    	 alert.accept();
		
	}
}
