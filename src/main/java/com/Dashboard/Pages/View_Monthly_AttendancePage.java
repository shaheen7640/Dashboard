package com.Dashboard.Pages;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Dashboard.Base.BaseClass;

public class View_Monthly_AttendancePage extends BaseClass{

	@FindBy(css = "ul.navbar-nav.mr-auto.nav-grp-left-pad>li:nth-of-type(7)>a")
	WebElement menu_Admin;

	@FindBy(css = "#navbarText > div > ul > li.nav-item.dropdown.show > ul > li:nth-child(7) > a")
	WebElement submenu_View_Monthly_Attendance;

	@FindBy(className = "head-title2")
	public WebElement verification_text;

	@FindBy(id = "react-select-2-input")
	WebElement dropDwn_Year;

	@FindBy(id= "react-select-3-input")
	WebElement dropDwn_Month;

	public View_Monthly_AttendancePage() {

		PageFactory.initElements(driver, this);
	}
	public void click_On_menuAdmin() {
		menu_Admin.click();
	}

	public void click_On_submenu_View_Monthly_Attendance() {
		submenu_View_Monthly_Attendance.click();
	}
	public void select_duration(String year, String month) throws InterruptedException {

		//drop-down year
		dropDwn_Year.sendKeys(year.strip());
		dropDwn_Year.sendKeys(Keys.ENTER);

		Thread.sleep(2000);

		//drop-down month
		dropDwn_Month.sendKeys(month);
		dropDwn_Month.sendKeys(Keys.ENTER);

		//click on view button
		driver.findElement(By.cssSelector(".btn.btn-primary.btn-lg.mr-2")).click();

	}
	//Wait for attendance data table
	public void waitForAttendanceTable() {
		
		//String str = driver.findElement(By.cssSelector("#root > div.layout-width.layout-width-height > div > div > div:nth-child(4) > div.attendance.large-grid")).getText();
		String str;
		try {
			
			WebDriverWait waitForTable = new WebDriverWait(driver,Duration.ofSeconds(30));
			waitForTable.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#root > div.layout-width.layout-width-height > div > div > div:nth-child(4) > div.attendance.large-grid > table > tbody:nth-child(1)")));

			
		} catch (Exception e) {
		
			e.printStackTrace();
			System.out.println("Attendance table not loaded");
		}
		str = driver.findElement(By.cssSelector("#root > div.layout-width.layout-width-height > div > div > div:nth-child(4) > div.attendance.large-grid > table > tbody:nth-child(1)")).getText();
		System.out.println(str);
		Assert.assertEquals(str, str,"Data not loaded");
		System.out.println("Attendance table loaded successfully.");
	}
}
