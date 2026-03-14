package com.flightbooking.automation.tests;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.flightbooking.automation.base.BaseTest;
import com.flightbooking.automation.listeners.TestListener;
import com.flightbooking.automation.pages.*;
import com.flightbooking.automation.utils.*;



@Listeners(TestListener.class)

public class FlightBookingTest extends BaseTest {

//    @DataProvider(name = "flightData")
//    public Object[][] flightData() {
//
//        return new Object[][]{
//
//                {"Boston","London",
//                        "Sachin","Gautam Nagar",
//                        "Bhopal","Madhya Pradesh","462023",
//                        "1234567890123456","10","2028","Sachin Dhuriya"},
//
//                {"Paris","Rome",
//                        "Amit","Indrapuri Sector-C",
//                        "Bhopal","Madhya Pradesh","462021",
//                        "9876543210123456","09","2029","Amit Kumar"}
//
//        };
//    }
    @DataProvider(name="excelData")
	public Object[][] getExcelData()throws Exception
	{
		return ExcelUtils.getExcelData("C:\\Users\\sachin\\eclipse-workspace\\Flight_Booking\\src\\test\\resources\\testData.xlsx","testData");
	}
    @Test(dataProvider = "excelData",
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

        TravelTheWorldPage travel = new TravelTheWorldPage();

        travel.selectDepartureCity(fromCity);
        travel.selectDestinationCity(toCity);
        travel.clickFindFlights();

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