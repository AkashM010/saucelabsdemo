package Saucedemo.ExcelrAutomation_Project3;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AddToCartScenario2 {
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
	public void addingTwoProducts() throws Exception {
		for (int i = 0; i < 6; i++) {			// Adding all elements available in cart
			obj.addToCart().click();
		}
		obj.cart();
		int size = obj.cartProductElement.size();
		if (size == 6) {
			flag = true;
		}
		softAssertion.assertEquals(flag, true);		//Verifiyng all items are added or not to cart
		for (int i = 0; i < 6; i++) {
			obj.remove();							//Removing all Products added to cart
			Thread.sleep(2000);
		}
		obj.continueShopping();						//Returning back to home page
	}

}
