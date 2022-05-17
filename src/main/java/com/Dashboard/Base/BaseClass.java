package com.Dashboard.Base;

import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Dashboard.utill.ExpliciteWait;

public class BaseClass {

	public static WebDriver driver = null;
	public static Properties property;
	public static Robot robot;
	
	public BaseClass() {
		
		try {
			property = new Properties();
			/*FileInputStream fis = new FileInputStream("C:\\Users\\Shaheen Akhtar\\eclipse-workspace\\"
					+ "Dashboard\\src\\main\\java\\com\\Dashboard\\configuration\\config.properties"); */
			
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\Dashboard\\configuration\\config.properties");
			property.load(fis);
			
		}
		catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getClass());
			e.printStackTrace();
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getClass());
			e.printStackTrace();
		}
	}
	public static void initialization() {
		try {
			if(driver==null) {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "\\src\\test\\resources\\ChromeDriver\\chromedriver.exe");
	    driver = new ChromeDriver();
			}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(ExpliciteWait.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ExpliciteWait.PAGE_LOAD_TIMEOUT));
		//Fetching Url
		driver.get(property.getProperty("Url"));
	
		//to hold the script deliberately for 5 seconds
		//Thread.sleep(5000);
		}
		catch(Exception e) {
			System.out.println("Make sure you are connected with VPN/Connection is slow/Chromedriver is out of date");
			System.out.println(e.getMessage());
			
		}
	}	
	public static void takeScreenShot(String testMethodName) throws IOException {
		
		File scrnShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		
		FileUtils.copyFile(scrnShot,new File(currentDir+"\\Screenshot\\"+testMethodName+".png"));
	}
	public static void quit() {
		
		driver.quit();
		//driver = null;
	}
	}