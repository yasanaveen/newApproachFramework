package com.varsity.application.tests;

import org.testng.annotations.Test;

import com.varsity.application.base.BaseClass;
import com.varsity.application.pages.ApplicationModulePageObjects;
import com.varsity.application.pages.LoginPageObjects;
import com.varsity.application.pages.PreviousYearGraphObjects;

public class TC_0005PreviousYearGraphTest extends BaseClass {

	@Test
	public void previousYearGraphTest() throws InterruptedException {

		// Login to the application
		LoginPageObjects login = new LoginPageObjects(driver);
		login.setuserNameAndPassword(p.getProperty("username"), p.getProperty("password"));

		// Navigate to Application Module
		ApplicationModulePageObjects applicationModule = new ApplicationModulePageObjects(driver);
		applicationModule.clicksidebaroption("Application");
		Thread.sleep(2000);

		// Click on Previous Year Graph
		PreviousYearGraphObjects previousYearGraph = new PreviousYearGraphObjects(driver);
		previousYearGraph.clickPreviousYearGraph();
		log.info("Clicked on Previous Year Graph");
		previousYearGraph.clickPreviousYearGraphChanakya();
		log.info("Clicked on Previous Year Graph Chanakya");
		previousYearGraph.verifyIssued710Text();
		log.info("Verified Issued 7/10 Text");
		previousYearGraph.verifyZonalAccountantGraphImage();
		log.info("Verified Zonal Accountant Graph Image");

	}

}
