package com.flight.automation.utils;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

    public static String captureScreenshot(WebDriver driver, String testName) {

        TakesScreenshot ts = (TakesScreenshot) driver;

        File source = ts.getScreenshotAs(OutputType.FILE);

        String fileName = testName + "_" + System.currentTimeMillis() + ".png";

        String path = "test-output/screenshots/" + fileName;
        
        try {

            Files.createDirectories(Paths.get("test-output/screenshots"));

            Files.copy(source.toPath(), Paths.get(path));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }
}