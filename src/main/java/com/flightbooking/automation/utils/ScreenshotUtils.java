package com.flightbooking.automation.utils;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

    public static String captureScreenshot(WebDriver driver, String testName) {

        TakesScreenshot ts = (TakesScreenshot) driver;

        File source = ts.getScreenshotAs(OutputType.FILE);
        String relativePath = "screenshots/"+testName+"_"+System.currentTimeMillis()+".png";
        
        String fullPath =  System.getProperty("user.dir")+"/test-output/"+relativePath;

        try {
        	File folder = new File(System.getProperty("user.dir")+"/test-output/screenshots");
        	if(!folder.exists()) {
        		folder.mkdirs();
        	}
            
            Files.copy(source.toPath(), Paths.get(fullPath),StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return relativePath;
    }
}