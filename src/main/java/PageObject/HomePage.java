package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
WebDriver driver;

public HomePage(WebDriver driver)
{
  this.driver= driver;
  PageFactory.initElements(driver, this);
}
	
	@FindBy(xpath="//img[@class='gravatar']")
	private WebElement usericon;
	
	@FindBy(xpath = "//li[@class='user-signout']")
	private WebElement logout;
	
	public WebElement usericon() 
	{
		return usericon;
	}
	
	public WebElement logout()
	{
		return logout;
	}
}
