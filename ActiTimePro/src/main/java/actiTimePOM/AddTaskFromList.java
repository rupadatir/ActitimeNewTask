package actiTimePOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddTaskFromList
{

	@FindBy (xpath="//span[text()='Add Tasks from the List']")
	private WebElement addTaskFromList;
	
	@FindBy (xpath="(//div[@class='customerProjectSelector activeProjects']//td[2])[1]")
	private WebElement selectCustomerOrProjectFromDropdown;
	
		
	public AddTaskFromList(WebDriver driver10)
	{
		PageFactory.initElements(driver10, this);
	}
	 public void clickAddTaskPanel()
	 {
		 addTaskFromList.click();
	 }
	
	 public void selectTaskFromDropdown()
	 {
		 selectCustomerOrProjectFromDropdown.click();
	 }
	 
	 
}
