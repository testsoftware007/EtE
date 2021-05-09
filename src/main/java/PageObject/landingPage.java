package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class landingPage {
	
	WebDriver driver;
	
	public landingPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@class='theme-btn']")
	private WebElement linktext;
	
	@FindBy(xpath="//a[@class='theme-btn']")
	private WebElement loginlink;
	
	@FindBy(xpath="//button[text()='NO THANKS']")
	private WebElement popup;
	
	@FindBy(id="user_email")
	private WebElement email;
	
	@FindBy(id="user_password")
	private WebElement password;
	
	@FindBy(xpath="//input[@value='Log In']")
	private WebElement loginbtn;
	
	private By signuplink = By.xpath("//span[text()='Login']");
	
	@FindBy(xpath="//input[@value='Sign Up']")
	private WebElement signupbtn;
	
	
	public WebElement loginlink()
	{
		return loginlink;
	}
	
	public WebElement popup()
	{
		return popup;
	}
	
	public WebElement email()
	{
		return email;
	}
	
	public WebElement password()
	{
		return password;
	}
	
	public WebElement loginbtn()
	{
		return loginbtn;
	}
	
	public WebElement signuplink()
	{
		return driver.findElement(signuplink);
	}
	public WebElement signupbtn()
	{
		return signupbtn;
	}
	
	public WebElement linktext()
	{
		return linktext;
	}
	
	
	

}
