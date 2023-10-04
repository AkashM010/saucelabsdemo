package Saucedemo.ExcelrAutomation_Project3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MenuScenario {
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
	public void menuOption() throws Exception {
		obj.login();
		WebElement menuEle = obj.menuElement;
		softAssertion.assertEquals(menuEle.isDisplayed(), true);
		obj.menuButton();
		WebElement allItemsEle = obj.allItems();
		softAssertion.assertEquals(allItemsEle.isDisplayed(), true);
		WebElement logoutEle = obj.logoutElement;
		softAssertion.assertEquals(logoutEle.isDisplayed(), true);
		WebElement aboutEle = obj.about();
		softAssertion.assertEquals(aboutEle.isDisplayed(), true);
		WebElement resetEle = obj.resetAppState();
		softAssertion.assertEquals(resetEle.isDisplayed(), true);
		Thread.sleep(2000);
		aboutEle.click();
		String actualAboutPageTitle = driver.getTitle();
		String expectedAboutpageTitle = "Sauce Labs: Cross Browser Testing, Selenium Testing & Mobile Testing";
		softAssertion.assertEquals(actualAboutPageTitle, expectedAboutpageTitle);
	}
}
