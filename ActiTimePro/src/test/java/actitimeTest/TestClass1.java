package actitimeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import actiTimePOM.ActiTimeTasks;
import actiTimePOM.ActitimeHeaderSection;
import actiTimePOM.CreateNewTask;
import actiTimePOM.LoginPage;

public class TestClass1 {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Rupali\\Softwares\\chromedriver_win32 97.0\\chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get("http://localhost/login.do");
		
		//LoginPage POM class object
		LoginPage loginPage=new LoginPage(driver);   
		
		loginPage.sendUsername("admin");
		loginPage.sendPassword("manager");
		loginPage.keepMeLoginCheckbox();
		loginPage.clickLoginButton();
		
		//TasksPage POM class object
		
		ActiTimeTasks actiTimeTasks=new ActiTimeTasks(driver);
		
		actiTimeTasks.openTasksPage();
		
		actiTimeTasks.editTaskDeadLine();
		
		actiTimeTasks.setTaskDeadLine("May 5,2022");
		
		actiTimeTasks.saveTaskDeadLine();
		
	
		
//		//ActitimeHeaderSection POM class object
//		
//		ActitimeHeaderSection actitimeHeaderSection =  new ActitimeHeaderSection(driver);
//	
//		actitimeHeaderSection.openTasksPage();
//		actitimeHeaderSection.OpenReportPage();
//		actitimeHeaderSection.openUsersPage();
//		actitimeHeaderSection.openWorkSchedule();
//		actitimeHeaderSection.logOutActiTime();
//		
//		//CreateNewTask POM class object
//	
//		CreateNewTask createNewTask= new CreateNewTask(driver);
//		
//		createNewTask.clickCreateNewTaskPanel();
//		createNewTask.clickSelectCustomerFromDropdown();
//		createNewTask.selectNewCustomerOption();
//		createNewTask.sendNewCustomerName();
//		createNewTask.sendProjectName();
//		createNewTask.sendTask1();
//		createNewTask.sendTask2();
//		createNewTask.sendTask3();
//		createNewTask.clickCreateTaskButton();
////		createNewTask.selectedDeadLineForTask1();
//		createNewTask.clickSaveChangesButton();

		
		
	}
}
		
		