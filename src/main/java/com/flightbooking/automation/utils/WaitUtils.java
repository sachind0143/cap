package com.flightbooking.automation.utils;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flightbooking.automation.Constants.TestConstants;
import com.flightbooking.automation.base.DriverManager;

public class WaitUtils {

    private static WebDriverWait wait =
            new WebDriverWait(
                    DriverManager.getDriver(),
                    Duration.ofSeconds(TestConstants.EXPLICIT_WAIT));

    public static void waitForVisibility(WebElement element) {

        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForClickable(WebElement element) {

        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}