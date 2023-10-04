package Saucedemo.ExcelrAutomation_Project3;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BackToHomePageScenario {
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
	public void backToHome() {
		obj.products(0);
		obj.addToCart();
		obj.cart();
		obj.checkout();
		obj.firstNameInfo("Random");
		obj.lastNameInfo("Name");
		obj.postalCodeInfo("789456");
		obj.continueButton();
		obj.finishButton();
		obj.backHome();
		String expectedUrl = "https://www.saucedemo.com/inventory.html";
		String actualUrl = driver.getCurrentUrl();
		softAssertion.assertEquals(actualUrl, expectedUrl);
	}
}
