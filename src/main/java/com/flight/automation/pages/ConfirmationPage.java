package com.flight.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.flight.automation.utils.LoggerUtils;

public class ConfirmationPage extends BasePage {

    @FindBy(tagName = "h1")
    WebElement confirmationMessage;

    public String getConfirmationMessage() {

        LoggerUtils.info("Fetching booking confirmation message");

        return getText(confirmationMessage);
    }

    public boolean verifyBookingSuccess() {

        LoggerUtils.info("Verifying booking confirmation");

        return isDisplayed(confirmationMessage);
    }
}