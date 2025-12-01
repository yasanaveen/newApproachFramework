package com.varsity.application.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.varsity.application.utils.WaitUtill;

public class PreviousYearGraphObjects {

	private WebDriver driver;
	private WaitUtill waitUtill;

	public PreviousYearGraphObjects(WebDriver driver) {
		this.driver = driver;
		this.waitUtill = new WaitUtill(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[text()='Zonal Accountant (DGM Rollup) wise graph']")
	WebElement zonalAccountantGraphText;

	@FindBy(xpath = "(//*[contains(@class,'MuiAccordionSummary')])[1]")
	//@FindBy(xpath = "(//*[contains(@class, 'BarGraph_red_bar')]/@title)[2]")
	WebElement previousYearGraph;

	@FindBy(xpath = "//*[@title='Issued: 710']")
	WebElement issued710Text;

	@FindBy(xpath = "//figure[@class='AnalyticsWholeContainer_endIcon__646SC']//img")
	WebElement zonalAccountantGraphImage;

	@FindBy(id = "panel1-header")
	WebElement previousYearGrpahChanakya;

	public void clickPreviousYearGraph() throws InterruptedException {
		Thread.sleep(2000);
		previousYearGraph.click();
		Thread.sleep(2000);
		boolean text = zonalAccountantGraphText.isDisplayed();
		System.out.println("Zonal Accountant (DGM Rollup) wise graph is displayed: " + text);
	}

	public void clickPreviousYearGraphChanakya() throws InterruptedException {
		Thread.sleep(2000);
		previousYearGrpahChanakya.click();
		Thread.sleep(2000);
		boolean text = previousYearGrpahChanakya.isDisplayed();
		System.out.println("CHANAKYA BHAVAN IPCC wise graph: " + text);
	}

	public void verifyIssued710Text() {
		String Issued710 = issued710Text.getText().trim();
		System.out.println("Issued  Applications is displayed:Issued710");
		System.out.println("sold Applications is displayed: sold 0");
	}

	public void verifyZonalAccountantGraphImage() {
		boolean isDisplayed = zonalAccountantGraphImage.isDisplayed();
		System.out.println("Zonal Accountant (DGM Rollup) wise graph image is displayed: " + isDisplayed);
	}

}
