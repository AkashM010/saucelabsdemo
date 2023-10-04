package Saucedemo.ExcelrAutomation_Project3;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CheckoutScenario2 {
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

	@Test(priority = 1)
	public void yourInfoPage() {
		obj.products(0);
		obj.addToCart();
		obj.cart();
		obj.checkout();
		boolean actual = obj.checkoutYourInfoPage();
		softAssertion.assertEquals(actual, true); // Verify Checkout: Your Information Page is displayed or not
	}

	@Test(priority = 2)
	public void yourInfoDetails() throws Exception { // Entering details in Checkout: Your Information Page
		obj.firstNameInfo("Random");
		obj.lastNameInfo("Name");
		obj.postalCodeInfo("789456");
		obj.continueButton();
	}

	@Test(priority = 3)
	public void overview() throws Exception {
		boolean actual = obj.checkoutOverviewPage();
		softAssertion.assertEquals(actual, true);
		obj.cancelButton();
	}
}
