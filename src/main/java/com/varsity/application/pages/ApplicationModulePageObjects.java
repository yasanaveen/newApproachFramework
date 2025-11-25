package com.varsity.application.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.varsity.application.utils.WaitUtill;

public class ApplicationModulePageObjects {

	private WebDriver driver;
	private WaitUtill waitUtill;

	public ApplicationModulePageObjects(WebDriver driver) {
		this.driver = driver;
		waitUtill = new WaitUtill(driver);
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "(//*[@class='SideBar_sidebar__F4ct3']//li)[3]")
	List<WebElement> sideBarOptions;

	@FindBy(xpath = "//*[@class='ApplicationNavLinks_all_nav_tabs__+HYGr']//li[2]")
	WebElement distributionTab;

	@FindBy(xpath = "(//*[@type='button'])[2]")
	WebElement dpdownBtn;

	@FindBy(xpath = "//*[contains(@class,'Searchbox_input')]")
	WebElement dpdwnSearchinput;

	@FindBy(xpath = "//*[text()='HYDERABAD']")
	WebElement selectCity;

	@FindBy(xpath = "(//*[@type='button'])[3]")
	WebElement zoneDropdownBtn;

	@FindBy(xpath = "(//*[contains(@class,'Searchbox')])[3]")
	WebElement zoneDpdwnSearchinput;

	@FindBy(xpath = "//*[text()='MADHAPUR']")
	WebElement selectZone;

	@FindBy(xpath = "(//*[@type='button'])[4]")
	WebElement branchDropdown;

	@FindBy(xpath = "//*[text()='NEXGEN HYD MADHAPUR CO IPL-2 BR.']")
	WebElement selectBranch;

	@FindBy(xpath = "(//*[@type='button'])[5]")
	WebElement issuedToDropdown;

	@FindBy(xpath = "//*[text()='Shiva Dev']")
	WebElement selectIssuedTo;

	@FindBy(id = "applicationNoFrom")
	WebElement applicationNumberfromField;

	@FindBy(id = "range")
	WebElement rangeField;
	
	@FindBy(xpath = "//*[@value='2025-11-25']")
	WebElement dateField;

	@FindBy(xpath = "//*[@id='mobileNumber']")
	WebElement mobileNumberField;

	public @FindBy(xpath = "//*[text()='Insert']")
	WebElement insertButton;

	public void clicksidebaroption(String optionName) {

		for (WebElement option : sideBarOptions) {
			waitUtill.waitForVisibility(option);
			String text = option.getText();
			if (text.equalsIgnoreCase(optionName)) {
				option.click();
				System.out.println("Clicked on sidebar option: " + optionName);
				return;
			}
		}

	}
	
	public String getPageHTML() {
	    return driver.getPageSource();
	}


	public void clickDistributionTab() {
		waitUtill.waitForVisibility(distributionTab).click();
	}

	public void citySelection(String cityName) throws InterruptedException {
		waitUtill.waitForVisibility(dpdownBtn).click();
		waitUtill.waitForVisibility(dpdwnSearchinput).sendKeys(cityName);
		Thread.sleep(2000);
		waitUtill.waitForVisibility(selectCity).click();
	}

	public void zoneSelection(String zoneName) throws InterruptedException {
		waitUtill.waitForVisibility(zoneDropdownBtn).click();
		waitUtill.waitForVisibility(zoneDpdwnSearchinput).sendKeys(zoneName);
		Thread.sleep(1000);
		waitUtill.waitForVisibility(selectZone).click();
	}

	public void branchSelection() throws InterruptedException {
		waitUtill.waitForVisibility(branchDropdown).click();
		// Thread.sleep(2000);
		waitUtill.waitForVisibility(selectBranch).click();
	}

	public void issuedToSelection() throws InterruptedException {
		waitUtill.waitForVisibility(issuedToDropdown).click();
		// Thread.sleep(2000);
		waitUtill.waitForVisibility(selectIssuedTo).click();
	}

	public void enterApplicationNumberFrom(String applicationNumber) {
		waitUtill.waitForVisibility(applicationNumberfromField).clear();
		applicationNumberfromField.sendKeys(applicationNumber);
	}

	public void enterRange(String range) {
		waitUtill.waitForVisibility(rangeField).clear();
		rangeField.sendKeys(range);
	}
	
	public String getDateFieldValue() {
	    waitUtill.waitForAttributeNotEmpty(dateField, "value");
	    return dateField.getAttribute("value").trim();
	}

	public String getMobileNumber() {
		waitUtill.waitForAttributeNotEmpty(mobileNumberField, "value");
		return mobileNumberField.getAttribute("value").trim();
	}

	public void clickInsertButton() {
		waitUtill.waitForVisibility(insertButton).click();
		
	}

}
