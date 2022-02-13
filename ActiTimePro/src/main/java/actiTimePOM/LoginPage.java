package actiTimePOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage
{	
	private WebDriver driver;
	
	private WebDriverWait wait;
	
	Actions act;
	
	@FindBy (xpath="//input[@id='username'] ")
	private WebElement userName;
	
	@FindBy (xpath="//input[@name='pwd']")
	private WebElement password;
	
	@FindBy (xpath="//input[@id='keepLoggedInCheckBox']")
	private WebElement keepMeLoginCheckbox;
	
	@FindBy (xpath="//a[@id='loginButton']")
	private WebElement loginButton;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
		act=new Actions(driver);
		wait=new WebDriverWait(driver,20);
	}
	
	public void sendUsername(String user)
	{
		userName.sendKeys(user);
	}
	
	public void sendPassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void keepMeLoginCheckbox()
	{
		keepMeLoginCheckbox.isSelected();
		keepMeLoginCheckbox.click();
	}
	
	public void clickLoginButton()
	{
		loginButton.click();
	}
}
