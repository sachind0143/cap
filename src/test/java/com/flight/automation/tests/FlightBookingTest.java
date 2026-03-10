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
                        "Sachin","Gautam Nagar",
                        "Bhopal","Madhya Pradesh","462023",
                        "1234567890123456","10","2028","Sachin Dhuriya"},

                {"Paris","Rome",
                        "Amit","Indrapuri Sector-C",
                        "Bhopal","Madhya Pradesh","462021",
                        "9876543210123456","09","2029","Amit Kumar"}

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
                               String card,
                               String ccMonth,
                               String ccYear,
                               String nameOnCard
                               ) {

        TravelTheWorldPage home = new TravelTheWorldPage();

        home.selectDepartureCity(fromCity);
        home.selectDestinationCity(toCity);
        home.clickFindFlights();

        FlightsPage flights = new FlightsPage();

        Assert.assertTrue(flights.verifyFlightsDisplayed());

        flights.chooseFirstFlight();

        PurchasePage purchase = new PurchasePage();

        purchase.enterPassengerDetails(name,address,city,state,zip);
        purchase.enterPaymentDetails(card,nameOnCard,ccMonth,ccYear);
        purchase.clickPurchaseFlight();

        ConfirmationPage confirmation = new ConfirmationPage();

        String message =
                confirmation.getConfirmationMessage();

        Assert.assertTrue(message.contains("Thank you"));
    }
}