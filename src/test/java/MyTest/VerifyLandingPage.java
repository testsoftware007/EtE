package MyTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.AssertJUnit;
import java.io.IOException;


import org.testng.annotations.BeforeMethod;
import PageObject.landingPage;
import resource.Util;

public class VerifyLandingPage extends Util {
	public WebDriver driver;
 Logger log = LogManager.getLogger(VerifyLandingPage.class.getName());
	
	@Test
	public void verifyHomePage() throws IOException
	{
	
	
	landingPage l = new landingPage(driver);
	//joinNewsLetter(l);
	System.out.println(driver);
	AssertJUnit.assertTrue(l.linktext().isDisplayed());
	
	
	}
	
	@BeforeMethod
	public void clearCookies() throws IOException
	{
		driver = openUrl();
		driver.manage().deleteAllCookies();
	}
	

	@AfterMethod
	public void tearDown1()
	{
		tearDown();
	}
	
	

}
