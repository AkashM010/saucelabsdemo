package Saucedemo.ExcelrAutomation_Project3;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class loginScenario {

	WebDriver driver;
	pageObject obj;
	SoftAssert softAssertion = new SoftAssert();
	String pwd = "secret_sauce";

	@BeforeMethod
	public void setUp() {
		pageObject.setup();
		driver = pageObject.getDriver();
		obj = new pageObject(driver);
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@DataProvider(name = "TestData1")
	public Object[] excel1() throws IOException {
		FileInputStream f = new FileInputStream(
				"C:\\Users\\Akash\\OneDrive\\Desktop\\Study\\Project\\Automation Testing Project\\Project 3\\project3Data.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(f);
		XSSFSheet s = wb.getSheet("Sheet1");

		int rowCount = s.getPhysicalNumberOfRows();
		Object[] data = new Object[rowCount - 1];
		XSSFRow row;

		for (int i = 1; i < rowCount; i++) {
			row = s.getRow(i);
			XSSFCell cell = row.getCell(0); // Assuming you want the first cell in each row
			if (cell != null) {
				data[i - 1] = cell.toString();
			}

		}
		wb.close();
		return data;
	}
	
	@DataProvider(name = "TestData2")
	public Object[][] excel2() throws IOException {
		FileInputStream f = new FileInputStream(
				"C:\\Users\\Akash\\OneDrive\\Desktop\\Study\\Project\\Automation Testing Project\\Project 3\\project3Data.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(f);
		XSSFSheet s = wb.getSheet("Sheet2");
		
		int rowCount = s.getPhysicalNumberOfRows();
		int colCount = s.getRow(0).getLastCellNum();
		Object[][] data = new Object[rowCount - 1][colCount];
		XSSFRow row;
		
		for (int i = 1; i < rowCount; i++) {
			row = s.getRow(i);
			for(int j=0; j<colCount; j++) {
				data[i-1][j] = row.getCell(j).toString();
			}
		}
		wb.close();
		return data;
	}

	@Test(dataProvider = "TestData1")
	public void correctLoginCredentials(String user) throws Exception {
		obj.username(user);
		obj.password(pwd);
		obj.loginButton();
	}
	
	@Test(dataProvider = "TestData2")
	public void incorrectLoginCredentials(String user, String pwd2) {
		obj.username(user);
		obj.password(pwd2);
		obj.loginButton();
		boolean message = obj.errorMessage();
		softAssertion.assertEquals(message, true);
	}
}
