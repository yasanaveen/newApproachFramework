package com.varsity.application.pages;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.varsity.application.utils.WaitUtill;

public class AnalyticsScreen {

	private WebDriver driver;
	private WaitUtill waitUtil;

	public AnalyticsScreen(WebDriver driver) {
		this.driver = driver;
		waitUtil = new WaitUtill(driver);
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//*[text()=' Application Module']")
	WebElement applicationModuleText;

	@FindBy(xpath = "(//*[contains(@class,'ApplicationSearchBar_search_bar')])[1]//input")
	WebElement applicationSearchBar;

	@FindBy(xpath = "//*[contains(@class,'MetricCards_metric_cards_container')]//*[contains(@class,'MetricCards_metric_card__M51RU')]")
	List<WebElement> metricCards;

	@FindBy(xpath = "//*[contains(@class,'ZoneRateContainer_zones')]")
	WebElement zoneRateCards;

	@FindBy(xpath = "(//*[@class='ApplicationSearchBar_search_application_input__a4rjD'])[2]")
	WebElement searchBar;

	@FindBy(xpath = "//*[@class='SearchDropdown_tabs_dropdown__q8-rl  ']")
	WebElement clkCampus;

	@FindBy(xpath = "//*[text()='30']")
	WebElement percentageOfDropRate;

	public void verifyApplicationModuleText() {
		String actualText = applicationModuleText.getText().trim();
		String expectedText = "Application Module";
		assertEquals(actualText, expectedText, "Application Module text mismatch!");
		System.out.println("Application Module text verified successfully: " + actualText);
	}

	public void applicationSearchbar(String applicationNumber)  {
		waitUtil.waitForClickable(applicationSearchBar).sendKeys(applicationNumber);
		
	}

	public List<WebElement> getMetricCards() {
		return metricCards;
	}

	public void getZoneRateCards() {
		String zoneBars = zoneRateCards.getText();
		System.out.println("Zone Rate Cards: " + zoneBars);
	}

	public void clkSearchBar() {
		searchBar.click();
	}

	public void campusClick() {
		clkCampus.click();
	}

	public String getDropRateCard() {

		return percentageOfDropRate.getText().trim();

	}
}
