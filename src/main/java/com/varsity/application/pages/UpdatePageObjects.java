package com.varsity.application.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class UpdatePageObjects {

	WebDriver driver;

	public UpdatePageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//*[text()='Update']")
	WebElement btnUpdate;

	@FindBy(xpath = "//*[text()='Update Distribution to DGM']")
	WebElement updateDistributionToDGMText;
	
	@FindBy(xpath = "//*[contains(@class,'_xicon__w-H-u')]")
	WebElement closeIcon;

	public void clickUpdateButton() {
		btnUpdate.click();
		
	}
	
	public void getUpdateDistributionToDGMText() {
		String text= updateDistributionToDGMText.getText().trim();
		Assert.assertEquals(text, "Update Distribution to DGM", "Update Distribution to DGM text mismatch!");
		System.out.println("Update Distribution to DGM text verified successfully: " + text);
		
	}
	
	public void clickCloseIcon() {
		closeIcon.click();
		
	}
	

}
