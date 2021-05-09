package resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import PageObject.landingPage;

public class Util extends Base {
		
	public WebDriver driver;
	FileInputStream fis;
	public XSSFSheet sheet;
	public XSSFWorkbook ws;
	public ExtentReports extent;
	
		public void login(String username, String password, landingPage l) throws IOException, InterruptedException
		{
			
			l.loginlink().click();
			l.email().sendKeys(username);
			l.password().sendKeys(password);
			Thread.sleep(2);
			l.loginbtn().click();
		}
		
	
		public WebDriver openUrl() throws IOException
		{
			driver=intializeBrowser();
			driver.get(readPropertyData().getProperty("Appurl"));
			return driver;
		}
		
		public void tearDown()
		{
			System.out.println();
			driver.quit();
		}
		
		
		  public void joinNewsLetter(landingPage l)
		  { 
		  if(l.popup().isDisplayed())
		    l.popup().click();
		  
		  }
		  
		  
		  public XSSFSheet excelRead(String sheetname) throws IOException
		  {
			  String path = System.getProperty("user.dir");
			   fis = new FileInputStream(path+"\\ExcelDataInput.xlsx");
			   ws = new XSSFWorkbook(fis);
			  sheet = ws.getSheet(sheetname);
			  return sheet;
			 
		  }
		  public String getScreenshot(String method, WebDriver driver) throws IOException
		  {
			 
			 String path = System.getProperty("user.dir")+"//test-output//Screenshot//"+method+".png";
			  TakesScreenshot ts = (TakesScreenshot) driver;
			  File src = ts.getScreenshotAs(OutputType.FILE);
			  FileUtils.copyFile(src, new File(path));
			  return path;
			  
		  }
		  
		  public ExtentReports getReportObject() {

				String path = System.getProperty("user.dir") + "\\reports\\index.html";
				ExtentSparkReporter reporter = new ExtentSparkReporter(path);
				reporter.config().setReportName("Web Automation Results");
				reporter.config().setDocumentTitle("Test Results");

				extent = new ExtentReports();
				extent.attachReporter(reporter);
				extent.setSystemInfo("Tester", "Rahul Shetty");
				return extent;

			}
		 
		// TODO Auto-generated method stub

	}


