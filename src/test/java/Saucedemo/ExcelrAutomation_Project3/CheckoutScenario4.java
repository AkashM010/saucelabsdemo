package Saucedemo.ExcelrAutomation_Project3;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CheckoutScenario4 {
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
	public void checkoutFinalPage() {
		obj.products(0);
		obj.addToCart();
		obj.cart();
		obj.checkout();
		obj.firstNameInfo("Random");
		obj.lastNameInfo("Name");
		obj.postalCodeInfo("789456");
		obj.continueButton();
		obj.finishButton();
		String message = "Thank you for your order!";
		softAssertion.assertEquals(obj.checkoutConfirm().getText(), message);
	}
}
