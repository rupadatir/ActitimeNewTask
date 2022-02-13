package actitimeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import actiTimePOM.CreateNewTask;

public class TestClass3 {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Rupali\\Softwares\\chromedriver_win32 97.0\\chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get("http://localhost/login.do");
	
		//CreateNewTask POM class object
	
		CreateNewTask createNewTask= new CreateNewTask(driver);
		
		createNewTask.clickCreateNewTaskPanel();
		createNewTask.clickSelectCustomerFromDropdown();
		createNewTask.selectNewCustomerOption();
		createNewTask.sendNewCustomerName("Chinu");
		createNewTask.sendProjectName("GooglePay");
		createNewTask.sendTask1("Gas Booking");
		createNewTask.sendTask2("RideBook");
		createNewTask.sendTask3("MakeMyTrip");
		createNewTask.clickCreateTaskButton();
		createNewTask.clickSaveChangesButton();
//		createNewTask.selectedDeadLineForTask1();
		
	}

}
