package com.flipKart.testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.flipKart.pages.BaseClass;
import com.flipKart.pages.LoginPage;
import com.flipKart.utilities.BrowserFactory;
import com.flipKart.utilities.ExcelDataProvider;
import com.flipKart.utilities.Helper;
import com.mongodb.diagnostics.logging.Logger;

public class FlipKartLogin extends BaseClass { 
	
	
	@Test
	public void login() {	
		
			String un = excel.getStringData(0, 0, 1);
			String pwd = excel.getStringData(0, 0, 2);
			String ph = excel.getNumericData(0, 0, 3);
			
			logger = report.createTest("Login to FlipKart");
			
			//LoginPage lp = PageFactory.initElements(driver, LoginPage.class);		
			LoginPage lp = new LoginPage(driver);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			logger.info("Starting Application");
			
			lp.enterCredentials(un,pwd);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			lp.enterPhNumaClickOnContinue(ph,pwd);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			Helper.captureScreenshot(driver);		
			
			logger.pass("logged in successfully");
	}

}
