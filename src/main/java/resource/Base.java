package resource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	
	public WebDriver driver;
	static Properties p;
	
	public WebDriver intializeBrowser() throws IOException
	{	
		//Get the browser from maven command
		//String browsername = System.getProperty("browser");
		String browsername= readPropertyData().getProperty("Browser");
		if (browsername.equalsIgnoreCase("Chrome")) {
			//To run the test cases in headless mode
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} else if (browsername.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		} else if (browsername.equalsIgnoreCase("IE")) {
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public static Properties readPropertyData() throws IOException
	{
		String path = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(path+"\\src\\main\\java\\resource\\Data.properties");
		 p = new Properties();
		p.load(fis);
		return p;
		
	}

}
