package MyTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.HomePage;
import PageObject.landingPage;
import resource.Util;

public class VerifyHomePage extends Util  {
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(VerifyHomePage.class.getName());
	@Test(dataProvider = "getData")
	public void verifyHomePageTitle(String username, String password) throws IOException, InterruptedException, SQLException
	{
	  
		log.info("Driver is intialized and navigate to landing page");
		landingPage l = new landingPage(driver);
	//	joinNewsLetter(l);
		log.info("Login to the application");
		login(username, password,l);
		log.info("Login to the application");
		driver.getTitle();
		HomePage h = new HomePage(driver);
		AssertJUnit.assertTrue(h.usericon().isDisplayed());
		h.usericon().click();
		h.logout().click();
	}
	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		
		sheet = excelRead("Sheet1");
		int number = sheet.getLastRowNum();
		System.out.println(number);
		Object[][] data = new Object[number][2];
		for(int i=0; i<number; i++)
		{
			data[i][0]= sheet.getRow(i+1).getCell(0).getStringCellValue();
			System.out.println(data[i][0]);
			data[i][1]= sheet.getRow(i+1).getCell(1).getStringCellValue();
			System.out.println(data[i][1]);
		}		
		/*
		 * data[0][0] = excelRead(null, 0) data[0][1] = "Gaurav@007r"; data[1][0] =
		 * "d.saini012@gmail.com"; data[1][1] = "Gaurav@007r";
		 */
		System.out.println("Hello");
		return data;
	}
	

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	@BeforeMethod
	public void clearCookies() throws IOException
	{
		driver = openUrl();
		driver.manage().deleteAllCookies();
	}

}
