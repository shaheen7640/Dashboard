package com.screenShot;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Dashboard.Base.BaseClass;

@Listeners(ScreenShotListener.class)
public class ScreenShot extends BaseClass {
	
	@BeforeMethod
	public void setUp() {
		initialization();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@Test
	public void takeScreenShotTest() {
		
		Assert.assertEquals(false, true);
	}
	

}
