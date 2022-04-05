package com.screenShot;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Dashboard.Base.BaseClass;

public class ScreenShotListener extends BaseClass implements ITestListener {
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test has been started");
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test has been passed");
	}
	@Override
	public void onTestFailure(ITestResult result) {
		
		System.out.println("Test Failed");
		try {
			takeScreenShot(result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void onTestSkipped(ITestResult result) {
	
		System.out.println("Test skipped");
	}

}
