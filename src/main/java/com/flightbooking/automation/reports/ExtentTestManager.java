package com.flightbooking.automation.reports;

import com.aventstack.extentreports.ExtentTest;
//Manages Test Entries inside the report
public class ExtentTestManager {
//Maintain Thread safety during parallel test Execution
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public static void setTest(ExtentTest extentTest) {

        test.set(extentTest);
    }

    public static ExtentTest getTest() {

        return test.get();
    }
}