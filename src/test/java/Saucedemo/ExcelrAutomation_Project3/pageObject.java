package Saucedemo.ExcelrAutomation_Project3;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class pageObject {
	static WebDriver driver;
	String data;
	String pwd = "secret_sauce";

	public static void setup() {					//Seting Up the drivers and launching the Website
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		launchApp();
		driver.manage().window().maximize();
	}
	
	public static WebDriver getDriver() {			//INitializing the drivers
		return driver;
	}
	
	public pageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public static void launchApp() {
		driver.get("https://www.saucedemo.com/");
	}
	
	public void impliitSync() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void excelSheet() throws IOException {		//DataProvider for login method
		FileInputStream f = new FileInputStream(
				"C:\\Users\\Akash\\OneDrive\\Desktop\\Study\\Project\\Automation Testing Project\\Project 3\\project3Data.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(f);
		XSSFSheet s = wb.getSheet("Sheet3");

		XSSFRow row = s.getRow(1);
		XSSFCell cell = row.getCell(0);
		if(cell != null) {

			data = cell.toString();
		}
		wb.close();
	}
	
	public void login() {
		username("standard_user");
		password(pwd);
		loginButton();
	}
	
	@FindBy(id = "user-name")
	WebElement usernameElement;
	
	public void username(String username) {
		usernameElement.sendKeys(username);
	}
	
	@FindBy(id = "password")
	WebElement passwordElement;
	
	public void password(String password) {
		passwordElement.sendKeys(password);
	}
	
	@FindBy(id = "login-button")
	WebElement loginbtnElement;
	
	public void loginButton() {
		loginbtnElement.click();
	}
	
	@FindBy(xpath = "//h3[@data-test='error']")
	WebElement errormsgElement;
	
	public boolean errorMessage() {					//Login Error Message
		return errormsgElement.isDisplayed();
	}
	
	@FindBy(xpath = "//button[contains(text(),'Open Menu')]")
	WebElement menuElement;
	
	public void menuButton() {
		menuElement.click();
	}
	
	@FindBy(xpath = "//*[text()='Logout']")
	WebElement logoutElement;
	
	public void logout() {
		logoutElement.click();
	}
	
	@FindBy(xpath = "//a[contains(text(),'All Items')]")
	WebElement allItemsElement;
	
	public WebElement allItems() {
		return allItemsElement;
	}
	
	@FindBy(xpath = "//a[contains(text(),'About')]")
	WebElement aboutElement;
	
	public WebElement about() {
		return aboutElement;
	}
	
	@FindBy(xpath = "//a[contains(text(),'Reset App State')]")
	WebElement resetElement;
	
	public WebElement resetAppState() {
		return resetElement;
	}
	
	
	@FindBy(xpath = "//*[text()='Add to cart']")
	WebElement addToCartElements;
	
	public WebElement addToCart() {				//Adds product to cart
		return addToCartElements;
	}
	
	@FindBy(xpath = "//*[text()='Remove']")
	WebElement removeElement;
	
	public void remove() {						//Remove element from cart
		removeElement.click();
	}
	
	@FindBy(xpath = "//*[@class='inventory_item_name']")
	List<WebElement> productsElement;
	
	public WebElement products(int n) {		//selects the products
		return productsElement.get(n);
	}
	
	@FindBy(xpath = "//*[@class='shopping_cart_link']")
	WebElement cartElement;
	
	public void cart() {		//selects the cart option
		cartElement.click();
	}
	
	@FindBy(xpath = "//*[@class='cart_list']")
	List<WebElement> cartProductElement;
	
	public WebElement cartProducts(int n) {		//selects all products in cart
		return cartProductElement.get(n);
	}
	
	@FindBy(xpath = "//*[@id='continue-shopping']")
	WebElement continueShoppingElement;
	
	public void continueShopping() {
		continueShoppingElement.click();
	}
	
	@FindBy(xpath = "//*[@class='removed_cart_item']")
	WebElement removedItemElement;
	
	public boolean removedItem() {
		return removedItemElement.isDisplayed();
	}
	

	@FindBy(id = "checkout")
	WebElement checkoutElement;
	
	public void checkout() {
		checkoutElement.click();
	}
	
	@FindBy(xpath = "//span[text()='Checkout: Your Information']")
	WebElement yourInfoPageElement;
	
	public boolean checkoutYourInfoPage() {
		return yourInfoPageElement.isDisplayed();
	}
	

	@FindBy(id = "first-name")
	WebElement firstNameInfoElement;
	
	public void firstNameInfo(String firstname) {
		firstNameInfoElement.sendKeys(firstname);
	}
	
	@FindBy(id = "last-name")
	WebElement lastNameInfoElement;
	
	public void lastNameInfo(String lastname) {
		lastNameInfoElement.sendKeys("lastname");
	}
	
	@FindBy(id = "postal-code")
	WebElement postalCodeInfoElement;
	
	public void postalCodeInfo(String code) {
		postalCodeInfoElement.sendKeys(code);
	}
	
	@FindBy(id = "continue")
	WebElement continueElement;
	
	public void continueButton() {
		continueElement.click();
	}
	
	@FindBy(xpath = "//span[text()='Checkout: Overview']")
	WebElement overviewPageElement;
	
	public boolean checkoutOverviewPage() {
		return overviewPageElement.isDisplayed();
	}
	
	@FindBy(id = "cancel")
	WebElement cancelElement;
	
	public void cancelButton() {
		cancelElement.click();
	}
	
	@FindBy(id = "finish")
	WebElement finishlElement;
	
	public void finishButton() {
		finishlElement.click();
	}
	
	@FindBy(xpath = "//*[@class='complete-header']")
	WebElement checkoutCompletionElement;
	
	public WebElement checkoutConfirm() {
		return checkoutCompletionElement;
	}
	
	@FindBy(xpath = "//*[text()='Back Home']")
	WebElement bachHomeElement;
	
	public WebElement backHome() {
		return bachHomeElement;
	}
}
