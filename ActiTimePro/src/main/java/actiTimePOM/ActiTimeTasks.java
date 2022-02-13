package actiTimePOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActiTimeTasks 
{
	private WebDriver driver;
	
	@FindBy (xpath="//div[text()='Tasks']")
	private WebElement taskpage;
	
	@FindBy (xpath="(//span[text()='N/A'])[1]")
	private WebElement editDeadLine;
	
	@FindBy (xpath="//input[@id='deadlinePopupText']")
	private WebElement setDeadLine;
	
	@FindBy (xpath="//input[@value=' Save ']")
	private WebElement saveDeadLine;
	
	public ActiTimeTasks(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	public void openTasksPage()
	{
		taskpage.click();
	}
	
	public void editTaskDeadLine()
	{
		editDeadLine.click();
	}
	
	public void setTaskDeadLine(String date)
	{
		setDeadLine.sendKeys(date);
	}
	
	public void saveTaskDeadLine()
	{
		saveDeadLine.click();
	}
}
