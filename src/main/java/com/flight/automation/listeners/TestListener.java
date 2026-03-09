package com.flight.automation.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.flight.automation.base.DriverManager;
import com.flight.automation.reports.*;
import com.flight.automation.listeners.TestListener;
import com.flight.automation.utils.ScreenshotUtils;
import com.aventstack.extentreports.ExtentReports;

public class TestListener implements ITestListener {

    ExtentReports extent = ExtentManager.getInstance();

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTestManager.setTest(
                extent.createTest(result.getMethod().getMethodName())
        );
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        String screenshotPath =
                ScreenshotUtils.captureScreenshot(
                        DriverManager.getDriver(),
                        result.getMethod().getMethodName());

        ExtentTestManager.getTest().pass("Test Passed")
                .addScreenCaptureFromPath(screenshotPath);
    }

    @Override
    public void onTestFailure(ITestResult result) {

        ExtentTestManager.getTest().fail(result.getThrowable());

        String screenshotPath =
                ScreenshotUtils.captureScreenshot(
                        DriverManager.getDriver(),
                        result.getMethod().getMethodName()
                );

        try {

            ExtentTestManager.getTest()
                    .addScreenCaptureFromPath(screenshotPath);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
    @Override
    public void onFinish(ITestContext context) {

        extent.flush();
    }
}