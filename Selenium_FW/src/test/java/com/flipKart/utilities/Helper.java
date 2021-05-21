package com.flipKart.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.apache.commons.collections4.map.StaticBucketMap;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class Helper {

	public static String captureScreenshot(WebDriver driver) {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String ScreenShotPath = System.getProperty("user.dir")+"\\ScreenShots\\login"+Helper.getCurrentDateTime()+".png";
		
		try {
		FileHandler.copy(src, new File(ScreenShotPath));
		} catch (IOException e) {
			System.out.println("unable to capture screenShot"+e.getMessage());
		}	
		
		return ScreenShotPath;
	}
	
	public static String getCurrentDateTime() {
		DateFormat customFormat = new SimpleDateFormat("MM_DD_YYYY_HH_mm_ss");
		Date currentDate = new Date();
		
		return customFormat.format(currentDate);
	}
	
}

