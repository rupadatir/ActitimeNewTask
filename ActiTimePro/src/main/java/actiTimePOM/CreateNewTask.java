package actiTimePOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateNewTask 
{	
	private WebDriver driver;
	
	private WebDriverWait wait;

	private Actions act;

	@FindBy (xpath="//a[@onclick='openAddNewTasksPopup(); return false;']")
	private WebElement createNewTask;
	
	
	@FindBy (xpath="//button[@id='ext-gen19']")
	private WebElement selectCustomer;
	
	@FindBy (xpath= "//a[text()='- New Customer -']")
	private WebElement newCustomer;
	
	@FindBy (xpath="//input[@placeholder='Enter Customer Name']")
	private WebElement enterCustomerName ;
	
	@FindBy (xpath="//input[@placeholder='Enter Project Name']")
	private WebElement enterProjectName ;
	
	@FindBy (xpath="(//input[@placeholder='Enter task name'])[1]")
	private WebElement enterTask1;
	
	@FindBy (xpath="(//input[@placeholder='Enter task name'])[2]")
	private WebElement enterTask2 ;
	
	@FindBy (xpath="(//input[@placeholder='Enter task name'])[3]")
	private WebElement enterTask3;
	
	@FindBy (xpath = "//span[text()='Create Tasks']")
	private WebElement createTaskButton;
	
	@FindBy (xpath = "//table//td//input[@id='SubmitTTButton']")
	private WebElement saveChangesButton;
	

	
	
	public CreateNewTask(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver= driver;
		wait=new WebDriverWait(driver,5);
		act= new Actions(driver);
	}
	
	public void clickCreateNewTaskPanel()
	{	wait.until(ExpectedConditions.visibilityOf(createNewTask));
		createNewTask.click();
	}
	
	public void clickSelectCustomerFromDropdown()
	{	
		act.moveToElement(selectCustomer).click().build().perform();
	}
	
	public void selectNewCustomerOption()
	{	
		wait.until(ExpectedConditions.visibilityOf(newCustomer));
		act.moveToElement(newCustomer).click().build().perform();
	}
	
	public void sendNewCustomerName(String name)
	{
		enterCustomerName.sendKeys(name);
	}
	
	public void sendProjectName(String project)
	{
		enterProjectName.sendKeys(project);
	}
	public void sendTask1(String task1)
	{
		enterTask1.sendKeys(task1);
	}
	
	public void sendTask2(String task2)
	{
		enterTask2.sendKeys(task2);
	}
	
	public void sendTask3(String task3)
	{
		enterTask3.sendKeys(task3);
	}
	
	public void clickCreateTaskButton()
	{
		createTaskButton.click();
	}
	
	
	public void clickSaveChangesButton()
	{	
//		wait.until(ExpectedConditions.visibilityOf(saveChangesButton));
		saveChangesButton.click();
	}

	
	
	
//	@FindBy (xpath = "(//button[text()='set deadline'])[1] ")
//	private WebElement setDeadLineForTask1;
//
//	@FindBy (xpath = "(//table//tr//td//span[text()='25'])[2]")
//	private WebElement selectedDeadLineForTask1;
//	
//	
//	@FindBy (xpath = "((//button[text()='set deadline'])[2]")
//	private WebElement setDeadLineForTask2;
	
//	@FindBy (xpath = "")
//	private WebElement selectedDeadLineForTask2;
//	
//	@FindBy (xpath = "(//button[text()='set deadline'])[3]")
//	private WebElement setDeadLineForTask3;
	
//	@FindBy (xpath = "")
//	private WebElement selectedDeadLineForTask3;
		
	
	
	
	
//	public void setDeadLine1()
//	{		
//			setDeadLineForTask1.click();
//	} 
//	 
//	public void selectedDeadLineForTask1()
//	{
//		act.moveToElement(setDeadLineForTask1).click().build().perform();
//	}
//	 public void setDeadLine2()
//	{
//		setDeadLineForTask2.click();
//	}
//	
//	public void setDeadLine3()
//	{
//		setDeadLineForTask3.click();
//	}
	
}



