package com.flipKart.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.flipKart.utilities.BrowserFactory;
import com.flipKart.utilities.ConfigDataProvider;
import com.flipKart.utilities.ExcelDataProvider;
import com.flipKart.utilities.Helper;

public class BaseClass {


	public WebDriver driver;
	public ExcelDataProvider excel; 
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	

	
	//public String url = excel.getStringData(0, 0, 0);
	//public String browser = excel.getStringData(0, 0, 4);
	
	@BeforeSuite
	public void setUpSuite() {
		Reporter.log("setting up the Reports and Test is getting started", true);
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();	
		
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/Flipkart"+Helper.getCurrentDateTime()+".html"));
		report=new ExtentReports();
		report.attachReporter(extent);
		
		Reporter.log("settings completed and Test started", true);
	}

	@BeforeClass
	public void setup() {
		Reporter.log("Launching browser", true);
		driver = BrowserFactory.startApplication(config.getDataFromConfig("browser"), driver,config.getDataFromConfig("url"));
		Reporter.log("browser launched", true);
	}

	@AfterClass
	public void tearDown() {
		Reporter.log("browser is about close", true);
		BrowserFactory.quitBrowser(driver);		
		Reporter.log("browser closed", true);
	}
	
	// ITestResult testNg interface : ASA test case completes 'result' variable will have all the information
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) {
		Reporter.log("capturing ScreenShots", true);
		if (result.getStatus()==ITestResult.FAILURE) {
			//Helper.captureScreenshot(driver);
			try {
				logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			} catch (Exception e) {
				System.out.println("unable to take ScreenShot"+e.getMessage());
			}
		}else if (result.getStatus()==ITestResult.SUCCESS) {
			try {
				logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			} catch (Exception e) {
				System.out.println("unable to take ScreenShot"+e.getMessage());
			}
		} else if (result.getStatus()==ITestResult.SKIP) {
			try {
				logger.skip("Test Skipped", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			} catch (Exception e) {
				System.out.println("unable to take ScreenShot"+e.getMessage());
			}
		} 
		
		report.flush();
		Reporter.log("Test Completed and report get generated", true);
	}

}


