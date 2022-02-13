package actiTimePOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActitimeHeaderSection
{	
	private WebDriverWait wait;
	
	private WebDriver driver;
	
	private Actions act;
	
	@FindBy (xpath="//div[text()='Tasks']")
	private WebElement tasksPage;
	
	@FindBy (xpath="//div[text()='Reports']")
	private WebElement reportPage;
	
	@FindBy (xpath="//div[text()='Users']")
	private WebElement usersPage;
	
	@FindBy (xpath="//div[text()='Work Schedule']")
	private WebElement workSchedulePage;
	
	@FindBy (xpath="//a[text()='Logout']")
	private WebElement logOutButton;
	
	public ActitimeHeaderSection(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void openTasksPage()
	{
		tasksPage.click();
	}
	
	public void OpenReportPage()
	{
		reportPage.click();
	}
	
	public void openUsersPage()
	{
		usersPage.click();
	}
	
	public void openWorkSchedule()
	{
		workSchedulePage.click();
	}
	
	public void logOutActiTime()
	{
		logOutButton.click();
	}
}
