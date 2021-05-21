package com.flipKart.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FlipKartLoginWithOutFW {
	
	@Test
	public void login() {
		   
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Devraj\\eclipse-workspace\\Selenium_FW\\Drivers\\chromedriver.exe");    
        WebDriver driver=new ChromeDriver();  

        driver.navigate().to("https://www.flipkart.com");  
        driver.manage().window().maximize();  
          
        driver.quit();
	}

}
