package Saucedemo.ExcelrAutomation_Project3;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageScenario {
	WebDriver driver;
	pageObject obj;
	SoftAssert softAssertion = new SoftAssert();
	
	@BeforeTest
	public void setUp() {
		pageObject.setup();
		driver = pageObject.getDriver();
		obj = new pageObject(driver);
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	
	@Test
	public void homepage() {
		String expectedUrl = "https://www.saucedemo.com/inventory.html";
		String actualUrl = driver.getCurrentUrl();
		softAssertion.assertEquals(actualUrl, expectedUrl);
	}
}
