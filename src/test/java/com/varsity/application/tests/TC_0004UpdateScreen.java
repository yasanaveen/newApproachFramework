package com.varsity.application.tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import com.varsity.application.base.BaseClass;
import com.varsity.application.pages.ApplicationModulePageObjects;
import com.varsity.application.pages.LoginPageObjects;
import com.varsity.application.pages.UpdatePageObjects;

public class TC_0004UpdateScreen extends BaseClass {

	@Test
	public void updateButton() throws InterruptedException {

		LoginPageObjects login = new LoginPageObjects(driver);
		login.setuserNameAndPassword(p.getProperty("username"), p.getProperty("password"));

		ApplicationModulePageObjects applicationModule = new ApplicationModulePageObjects(driver);
		applicationModule.clicksidebaroption("Application");
		applicationModule.clickDistributionTab();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500)");

		UpdatePageObjects updatePage = new UpdatePageObjects(driver);
		updatePage.clickUpdateButton();
		log.info("Clicked on Update Button");
		updatePage.getUpdateDistributionToDGMText();
		log.info("Verified Update Distribution to DGM Text");
		Thread.sleep(2000);
		updatePage.clickCloseIcon();
		log.info("Clicked on Close Icon");

	}

}
