package Saucedemo.ExcelrAutomation_Project3;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LogOutScenatio {
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
	public void logOut() {
		obj.login();
		obj.impliitSync();
		obj.menuButton();
		obj.logout();
		String loginPageUrl = "https://www.saucedemo.com/";
		String actualUrl = driver.getCurrentUrl();
		softAssertion.assertEquals(actualUrl, loginPageUrl);
	}
}
