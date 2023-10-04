package Saucedemo.ExcelrAutomation_Project3;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CartScenario {
	WebDriver driver;
	pageObject obj;
	SoftAssert softAssertion = new SoftAssert();
	static boolean flag = false;

	@BeforeTest
	public void setUp() {
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
	public void cartOption() {
		obj.addToCart().click();
		obj.cart();
		int size = obj.cartProductElement.size();
		if (size==1) {
			flag = true;
		}
		softAssertion.assertEquals(flag, true);
		obj.remove();
		softAssertion.assertEquals(obj.removedItem(), true);
		obj.continueShopping();
		String expectedUrl = "https://www.saucedemo.com/inventory.html";
		String actualUrl = driver.getCurrentUrl();
		softAssertion.assertEquals(actualUrl, expectedUrl);
	}
}
