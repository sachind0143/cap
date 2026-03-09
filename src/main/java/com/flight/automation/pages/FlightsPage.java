package com.flight.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightsPage extends BasePage {

    @FindBy(xpath = "//table")
    WebElement flightsTable;

    @FindBy(xpath = "(//input[@type='submit'])[1]")
    WebElement chooseFlight;

    public boolean verifyFlightsDisplayed() {

        return isDisplayed(flightsTable);
    }

    public void chooseFirstFlight() {

        click(chooseFlight);
    }
}