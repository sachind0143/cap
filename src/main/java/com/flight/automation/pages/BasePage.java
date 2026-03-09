package com.flight.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.flight.automation.base.DriverManager;
import com.flight.automation.utils.WaitUtils;
import com.flight.automation.utils.LoggerUtils;
public class BasePage {

    public BasePage() {

        PageFactory.initElements(
                DriverManager.getDriver(), this);
    }

    protected void click(WebElement element) {

        WaitUtils.waitForClickable(element);

        LoggerUtils.info("Clicking button");

        element.click();
    }

    protected void type(WebElement element, String text) {

        WaitUtils.waitForVisibility(element);

        LoggerUtils.info("Typing text: "+text);

        element.clear();
        element.sendKeys(text);
    }

    protected String getText(WebElement element) {

        WaitUtils.waitForVisibility(element);

        LoggerUtils.info("Getting text from element");

        return element.getText();
    }

    protected boolean isDisplayed(WebElement element) {

        WaitUtils.waitForVisibility(element);

        return element.isDisplayed();
    }
}