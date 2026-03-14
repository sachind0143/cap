package com.flightbooking.automation.base;

import java.time.Duration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.flightbooking.automation.utils.ConfigReader;

public class BaseTest {

    @BeforeMethod
    public void setup() {

        String browser = ConfigReader.getProperty("browser");

        DriverManager.setDriver(DriverFactory.createDriver(browser));

        DriverManager.getDriver().manage().window().maximize();

        DriverManager.getDriver()
                .manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        DriverManager.getDriver()
                .get(ConfigReader.getProperty("url"));
    }

    @AfterMethod
    public void tearDown() {

        if (DriverManager.getDriver() != null) {

            DriverManager.quitDriver();
            
        }
    }
}