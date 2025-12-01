package com.varsity.application.tests;

import java.io.IOException;
import org.testng.annotations.Test;
import com.varsity.application.base.BaseClass;
import com.varsity.application.pages.LoginPageObjects;



public class TC_0001LoginPageTest extends BaseClass {

	@Test
	public void loginPageTest() throws IOException {

		LoginPageObjects loginPage = new LoginPageObjects(driver);
		//loginPage.urlValidation();
		
		loginPage.setuserNameAndPassword(p.getProperty("username"), p.getProperty("password"));
		log.info("Provided user name and password");
		log.info("Login Successful");
		loginPage.logout();
		log.info("Logout Successful");

	}

}
