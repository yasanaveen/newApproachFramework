package com.varsity.application.tests;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.varsity.application.base.BaseClass;
import com.varsity.application.pages.AnalyticsScreen;
import com.varsity.application.pages.ApplicationModulePageObjects;
import com.varsity.application.pages.LoginPageObjects;

public class TC_0003AnalyticsTestCase extends BaseClass {

	@Test
	public void verifyMetricCards() throws InterruptedException {

		LoginPageObjects login = new LoginPageObjects(driver);
		login.setuserNameAndPassword(p.getProperty("username"), p.getProperty("password"));

		ApplicationModulePageObjects applicationModule = new ApplicationModulePageObjects(driver);

		applicationModule.clicksidebaroption("Application");
		Thread.sleep(2000);

		AnalyticsScreen analytics = new AnalyticsScreen(driver);

		analytics.verifyApplicationModuleText();
		log.info("application module text verified");
		Thread.sleep(3000);
		analytics.applicationSearchbar("123");

//		List<WebElement> cards = analytics.getMetricCards();
//		System.out.println("----------------------------------------");
//		System.out.println(String.format("%-10s %-50s", "Card No", "Metric Card Text"));
//		System.out.println("------------------------------------------");
//
//		for (int i = 0; i < cards.size(); i++) {
//			String cardText = cards.get(i).getText().trim();
//
//			System.out.println(String.format("%-10s %-50s", "Card " + (i + 1), cardText));
//			System.out.println("\n---------------------------\n");
//		}
		
		List<WebElement> cards = analytics.getMetricCards();

		System.out.println("--------------------------------------------------------------");
		System.out.println(String.format("%-10s %-25s %-10s %-10s", 
		        "Card No", "Metric Name", "Value", "Change"));
		System.out.println("--------------------------------------------------------------");

		for (int i = 0; i < cards.size(); i++) {
		    String cardText = cards.get(i).getText().trim();
		    String[] parts = cardText.split("\\s+");

		    String metricName = "";
		    String value = "";
		    String change = "";

		    if (parts.length >= 3) {
		        // Last 2 items are value and change
		        value = parts[parts.length - 2];
		        change = parts[parts.length - 1];

		        // Metric name = everything except last 2
		        metricName = cardText.substring(0,
		                cardText.lastIndexOf(value)).trim();
		    } else {
		        // If not matching expected structure
		        metricName = cardText;
		    }

		    System.out.println(String.format("%-10s %-25s %-10s %-10s",
		            "Card " + (i + 1), metricName, value, change));

		    System.out.println("\n--------------------------------------------------------------\n");
		}
		log.info("Metric cards details printed successfully");

		Thread.sleep(3000);
		analytics.getZoneRateCards();
		log.info("Zone rate card details printed successfully");
		Thread.sleep(4000);
		analytics.clkSearchBar();
		log.info("Clicked on search bar");
		analytics.campusClick();
		log.info("Clicked on campus option");

		String actual = analytics.getDropRateCard();
		Assert.assertEquals(actual, "30%", "Drop rate percentage mismatch!");
		System.out.println("Drop rate percentage verified successfully: " + actual);
		log.info("Drop rate percentage verified successfully: " + actual);

	}

}
