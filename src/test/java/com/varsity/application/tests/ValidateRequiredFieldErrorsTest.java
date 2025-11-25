package com.varsity.application.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.varsity.application.base.BaseClass;
import com.varsity.application.pages.ApplicationModulePageObjects;
import com.varsity.application.pages.LoginPageObjects;

public class ValidateRequiredFieldErrorsTest extends BaseClass {

	@Test
	public void validateRequiredFieldErrorsTest() {

		LoginPageObjects loginPage = new LoginPageObjects(driver);
		loginPage.setuserNameAndPassword(p.getProperty("username"), p.getProperty("password"));

		ApplicationModulePageObjects app = new ApplicationModulePageObjects(driver);

		
		app.clicksidebaroption("Application");
		app.clickDistributionTab();
		//pageScrollDown();
		
		// Click Insert without filling any fields
		app.clickInsertButton();

		// Get full page source
		String source = app.getPageHTML();

		//System.out.println(source); // (Optional) Debugging

		SoftAssert soft = new SoftAssert();

		soft.assertTrue(source.contains("City Name is required"), "City Name validation message NOT found!");

		soft.assertTrue(source.contains("Zone Name is required"), "Zone Name validation message NOT found!");

		soft.assertTrue(source.contains("Campus Name is required"), "Campus Name validation message NOT found!");

		soft.assertTrue(source.contains("Issued To is required"), "Issued To validation message NOT found!");

		soft.assertTrue(source.contains("Application No From is required"),
				"Application No From validation message NOT found!");

		soft.assertTrue(source.contains("Range is required"), "Range validation message NOT found!");

		soft.assertAll();

		System.out.println(" All required field error messages validated using page source.");
	}

}
