package com.varsity.application.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.varsity.application.base.BaseClass;
import com.varsity.application.pages.ApplicationModulePageObjects;
import com.varsity.application.pages.LoginPageObjects;



public class TC_0002ApplicationModuleTestClass extends BaseClass {

	@Test
	public void homePageTest() throws InterruptedException {

		LoginPageObjects loginPage = new LoginPageObjects(driver);
		loginPage.setuserNameAndPassword(p.getProperty("username"), p.getProperty("password"));

		ApplicationModulePageObjects applicationModule = new ApplicationModulePageObjects(driver);

		applicationModule.clicksidebaroption("Application");
		log.info("Navigated to Application Module");
		Thread.sleep(2000);
		applicationModule.clickDistributionTab();
		log.info("Navigated to Distribution Tab");
		Thread.sleep(4000);
		applicationModule.citySelection("Hyderabad");
		log.info("City selected as Hyderabad");
		Thread.sleep(4000);
		applicationModule.zoneSelection("Madhapur");
		log.info("Zone selected as Madhapur");
		Thread.sleep(4000);
		applicationModule.branchSelection();
		log.info("Branch selected");
		Thread.sleep(4000);
		applicationModule.issuedToSelection();
		log.info("Issued To selected as Employee");
		Thread.sleep(4000);
		
		
//		String expected= applicationModule.getAvailableApplicationFrom();
//		Assert.assertFalse(expected.isEmpty(), "Value is empty!");
//		log.info("Available Application From value is matching");

		applicationModule.enterApplicationNumberFrom("10");
		applicationModule.enterRange("10");
		log.info("Entered Application Number From and Range");
		
		
		String date=applicationModule.getDateFieldValue();
		Assert.assertFalse(date.isEmpty(), "Date field value is empty");
		System.out.println("Date field value is matching");
		log.info("Date field value is matching");
		
		
		
		String actualMobileNumber = applicationModule.getMobileNumber();
		Assert.assertFalse(actualMobileNumber.isEmpty(), "Mobile number field is empty");
		System.out.println("Mobile number field value is matching");
		log.info("Mobile number field value is matching");

		pageScrollDown();

		Thread.sleep(4000);
		Assert.assertTrue(applicationModule.insertButton.isDisplayed(), "Insert button is not  displayed");
		System.out.println("Insert button is displayed");
		applicationModule.clickInsertButton();
		log.info("Clicked on Insert button");
		
		boolean errorMsge=driver.findElement(By.xpath("//*[text()='An error occurred during form submission.']")).isDisplayed();
		Assert.assertTrue(errorMsge, "Error message is not displayed");
		System.out.println("error msge occured");
		log.info("Error message is displayed as expected");
		

	}

}
