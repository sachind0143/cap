package com.flight.automation.tests;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.flight.automation.base.BaseTest;
import com.flight.automation.listeners.TestListener;
import com.flight.automation.pages.*;
import com.flight.automation.utils.RetryAnalyzer;



@Listeners(TestListener.class)

public class FlightBookingTest extends BaseTest {

    @DataProvider(name = "flightData")
    public Object[][] flightData() {

        return new Object[][]{

                {"Boston","London",
                        "Sachin","Street1",
                        "Delhi","Delhi","110001",
                        "1234567890123456"},

                {"Paris","Rome",
                        "Amit","Street2",
                        "Mumbai","Maharashtra","400001",
                        "9876543210123456"}

        };
    }

    @Test(dataProvider = "flightData",
            retryAnalyzer = RetryAnalyzer.class)

    public void bookFlightTest(String fromCity,
                               String toCity,
                               String name,
                               String address,
                               String city,
                               String state,
                               String zip,
                               String card) {

        TravelTheWorldPage home = new TravelTheWorldPage();

        home.selectDepartureCity(fromCity);
        home.selectDestinationCity(toCity);
        home.clickFindFlights();

        FlightsPage flights = new FlightsPage();

        Assert.assertTrue(flights.verifyFlightsDisplayed());

        flights.chooseFirstFlight();

        PurchasePage purchase = new PurchasePage();

        purchase.enterPassengerDetails(name,address,city,state,zip);
        purchase.enterPaymentDetails(card);
        purchase.clickPurchaseFlight();

        ConfirmationPage confirmation = new ConfirmationPage();

        String message =
                confirmation.getConfirmationMessage();

        Assert.assertTrue(message.contains("Thank you"));
    }
}