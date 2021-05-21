package com.flipKart.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	                                  
	@FindBy(xpath = "//input[@class = '_2IX_2- VJZDxU']")
	private WebElement userName ;
	
	@FindBy(xpath = "//input[@class = '_2IX_2- _3mctLh VJZDxU']")
	private WebElement password ;
	
	@FindBy(xpath = "//button[@class = '_2KpZ6l _2HKlqd _3AWRsL']")
	private WebElement loginBtn ;
	
	@FindBy(xpath = "//input[@class = '_2IX_2- VJZDxU']")
	private WebElement PhNum ;
	
	@FindBy(xpath = "//button[@class = '_2KpZ6l _2HKlqd _3AWRsL']")
	private WebElement continueBtn ;
	
	@FindBy(xpath = "//button[@class = '_2IX_2- _3mctLh VJZDxU']")
	private WebElement  sec_pwd;
	
	public void enterCredentials(String un, String pwd) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		userName.sendKeys(un);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		password.sendKeys(pwd);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		loginBtn.click();
		}
	
	public void enterPhNumaClickOnContinue(String ph, String pwd) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		userName.sendKeys(ph);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		continueBtn.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		password.sendKeys(pwd);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		loginBtn.click();
		}
}
