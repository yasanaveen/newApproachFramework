package com.varsity.application.base;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;



public class BaseClass {

	public WebDriver driver;
	public Properties p ;
	public static Logger log;
	
	
	@BeforeClass
	public void setup() throws IOException {
		
		FileInputStream file = new FileInputStream("src/test/resources/config.properties");
		 p = new Properties();
		 p.load(file);
		 
		 log = LogManager.getLogger(this.getClass());
		 

		driver = new ChromeDriver();
		log.info("Chrome Browser launched");
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(p.getProperty("baseURL"));
		log.info("Navigated to URL: " + p.getProperty("baseURL"));

	}
	
	public void pageScrollDown() {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("document.documentElement.scrollBy(0, 300);");
	}


	
	@AfterClass
	public void teardown() {
		driver.quit();
		log.info("Browser closed");
	}

}
