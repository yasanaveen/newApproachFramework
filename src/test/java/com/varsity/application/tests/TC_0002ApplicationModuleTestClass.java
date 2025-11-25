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
		Thread.sleep(2000);
		applicationModule.clickDistributionTab();
		Thread.sleep(4000);
		applicationModule.citySelection("Hyderabad");
		Thread.sleep(4000);
		applicationModule.zoneSelection("Madhapur");
		Thread.sleep(4000);
		applicationModule.branchSelection();
		Thread.sleep(4000);
		applicationModule.issuedToSelection();
		Thread.sleep(4000);

		applicationModule.enterApplicationNumberFrom("10");
		applicationModule.enterRange("10");
		
		String expectedDate = "2025-11-25";
		String actualDate = applicationModule.getDateFieldValue();
		Assert.assertEquals(actualDate, expectedDate, "Date field value is not matching");
		System.out.println("Date field value is matching");
		
		

		String expectedMobileNumber = "900000000176";
		String actualMobileNumber = applicationModule.getMobileNumber();
		Assert.assertEquals(actualMobileNumber, expectedMobileNumber, "Mobile number is not matching");

		//applicationModule.validateMobileNumberField(expectedMobileNumber);

		pageScrollDown();

		Thread.sleep(4000);
		Assert.assertTrue(applicationModule.insertButton.isDisplayed(), "Insert button is not  displayed");
		System.out.println("Insert button is displayed");
		applicationModule.clickInsertButton();
		
		boolean errorMsge=driver.findElement(By.xpath("//*[text()='An error occurred during form submission.']")).isDisplayed();
		Assert.assertTrue(errorMsge, "Error message is not displayed");
		System.out.println("error msge occured");
		

	}

}
