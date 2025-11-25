package com.varsity.application.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;





public class BaseClass {

	public WebDriver driver;
	public Properties p ;
	
	
	@BeforeClass
	public void setup() throws IOException {
		
		FileInputStream file = new FileInputStream("src/test/resources/config.properties");
		 p = new Properties();
		 p.load(file);
		 

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(p.getProperty("baseURL"));

	}
	
	
	public void pageScrollDown() {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0, 200)");
	}

	
	
	@AfterClass
	void teardown() {
		//driver.quit();
	}

}
