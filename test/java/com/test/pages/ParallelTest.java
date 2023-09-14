package com.test.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.wrappers.GenericWrappers;

public class ParallelTest extends GenericWrappers {

	private static final Logger logger;
	static {
		try {
			logger = LogManager.getLogger();
		} catch (Exception e) {
			// Handle the underlying exception that caused the initialization error
			System.err.println("Error initializing logger: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException("Failed to initialize logger");
		}
	}

	@BeforeTest
	public ParallelTest MasterDataPage() {

		sleep(3000);
		WebElement MasterDataCard = driver
				.findElement(By.xpath("//img[contains(@class, 'mx-image mx-name-staticImage3')]"));
		explicitWait(MasterDataCard);
		MasterDataCard.click();
		logger.info("Master data card is clicked");

		sleep(3500);
		WebElement searchBox = driver.findElement(By.id("mxui_widget_ControlBarButton_0"));
		explicitWait(searchBox);
		searchBox.click();
		sleep(1800);

		logger.info("Search button is clicked");
		
		return this;
	}
	
	@Test
	public ParallelTest ShipmentCompletedStatus() {
		
		sleep(3500);
		WebElement shipIDParentXpath = driver
				.findElement(By.xpath("//div[@class='mx-grid-search-input mx-name-searchField4']"));

		WebElement shipID = shipIDParentXpath.findElement(By.xpath("//input[@type='text']"));
		explicitWait(shipID);
		shipID.sendKeys("21113553");
		logger.info("Shipment ID: 21113553 is entered");

		WebElement mainSearchBtn = driver.findElement(By.id("mxui_widget_Button_0"));
		explicitWait(mainSearchBtn);
		mainSearchBtn.click();
		logger.info("Shipment ID is searched");

		sleep(1500);
		String status = driver.findElement(By.xpath(
				"//tr[@class='mx-name-index-0']//div[@class='mx-datagrid-data-wrapper'][normalize-space()='Yes']"))
				.getText();
		sleep(1500);

		System.out.println(status);
		if (status.equals("Yes")) {
			System.out.println("The shipment 21113553 is completed");
			logger.info("Shipment ID: 21113553 is completed");
		} else {
			System.out.println("The shipment 21113553 is not completed yet");
			logger.info("Shipment ID: 21113553 is not completed");
		}

		return this;
	}

	@Test
	public ParallelTest completedDateCalender() {

		sleep(1800);
		WebElement CompletedDatePicker = driver.findElement(
				By.xpath("//div[@id='mxui_widget_SearchInput_8']//button[@aria-label='Show date picker']"));
		CompletedDatePicker.click();
		sleep(1800);
		datePickerWidget();

		return this;
	}

	@Test
	public ParallelTest createdDateCalender() {

		sleep(1800);
		WebElement CreatedDatePicker = driver.findElement(
				By.xpath("//div[@id='mxui_widget_SearchInput_7']//button[@aria-label='Show date picker']"));
		CreatedDatePicker.click();
		sleep(1800);
		datePickerWidget();

		driver.findElement(By.xpath("//a[@role='button']")).click();
		return this;
	}

}
