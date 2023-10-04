package Saucedemo.ExcelrAutomation_Project3;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckoutScenario3 {
	WebDriver driver;
	pageObject obj;

	@BeforeTest
	public void logging_in() {
		pageObject.setup();
		driver = pageObject.getDriver();
		obj = new pageObject(driver);
		obj.login();
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}
	
	@Test
	public void overviewPage() {
		obj.products(0);
		obj.addToCart();
		obj.cart();
		obj.checkout();
		obj.firstNameInfo("Random");
		obj.lastNameInfo("Name");
		obj.postalCodeInfo("789456");
		obj.continueButton();
		obj.finishButton();
	}
}
