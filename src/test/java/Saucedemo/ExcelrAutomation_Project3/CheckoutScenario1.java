package Saucedemo.ExcelrAutomation_Project3;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CheckoutScenario1 {
	WebDriver driver;
	pageObject obj;
	SoftAssert softAssertion = new SoftAssert();

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
	public void checkoutButton() throws Exception {
		obj.products(1).click();
		obj.addToCart().click();
		obj.cart();
		boolean actual = obj.checkoutElement.isDisplayed();
		softAssertion.assertEquals(actual, true);
		obj.checkout();
	}
}
