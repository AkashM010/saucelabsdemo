package Saucedemo.ExcelrAutomation_Project3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AddToCartScenario1 {
	WebDriver driver;
	pageObject obj;
	SoftAssert softAssertion = new SoftAssert();

	@BeforeMethod
	public void logging_in() {
		pageObject.setup();
		driver = pageObject.getDriver();
		obj = new pageObject(driver);
		obj.login();
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@Test
	public void addTocart1() {
		obj.addToCart().click();
		obj.remove();
	}
	
	@Test
	public void addTocart2() throws Exception {
		obj.products(1).click();
		Thread.sleep(2000);
		WebElement element = obj.addToCart();
		element.click();
		obj.remove();
	}
}
