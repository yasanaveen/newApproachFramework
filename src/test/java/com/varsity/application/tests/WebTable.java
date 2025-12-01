package com.varsity.application.tests;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://192.168.20.19:8081/");
		driver.manage().window().maximize();

		driver.findElement(By.id("emailId")).sendKeys("rahulpatel@test.com");
		driver.findElement(By.id("password")).sendKeys("d3f53133473ad17dd57ae126b281de78");
		driver.findElement(By.xpath("//*[text()='Login']")).click();

		driver.findElement(By.xpath("(//*[@class='SideBar_sidebar__F4ct3']//li)[3]")).click();
		driver.findElement(By.xpath("//*[text()='Distribute']")).click();

		int rows = driver.findElements(By.xpath("//*[contains(@class,'TableWidget_table_wrapper')]//tr")).size();
		System.out.println("Number of columns: " + rows);

		int cols = driver.findElements(By.xpath("//*[contains(@class,'TableWidget_table_wrapper')]//th")).size();
		System.out.println("Number of columns: " + cols);

		String tableData = driver
				.findElement(By.xpath("//*[contains(@class,'TableWidget_table_wrapper')]//tr[1]//td[3]")).getText();

		for (int r = 2; r <= rows; r++) {
			for (int c = 1; c <= cols; c++) {
				String data = driver
						.findElement(By.xpath(
								"//*[contains(@class,'TableWidget_table_wrapper')]//tr[" + r + "]//td[" + c + "]"))
						.getText();
				System.out.print(data + " | ");
			}
			System.out.println();
		}

	}
}
