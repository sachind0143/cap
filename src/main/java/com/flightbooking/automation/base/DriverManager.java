package com.flightbooking.automation.base;

import org.openqa.selenium.WebDriver;
//Manages the driver life cycle using ThreadLocal(Thread Safety)
public class DriverManager {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(WebDriver driverInstance) {
        driver.set(driverInstance);
    }

    public static void quitDriver() {
        driver.get().quit();
        driver.remove();
    }
}