
//Login to Actitime,create New Task,setDeadline -Successful run-with Assertion

package actitimeTest;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import actiTimePOM.ActiTimeTasks;
import actiTimePOM.ActitimeHeaderSection;
import actiTimePOM.CreateNewTask;
import actiTimePOM.LoginPage;
import base.Browser;

import utils.Utility;

public class AllinOneActiTimeTestNG extends Browser
{
	private WebDriver driver;
	private ActitimeHeaderSection actitimeHeaderSection ;
	private CreateNewTask createNewTask;
	private LoginPage loginPage;
	private ActiTimeTasks actiTimeTasks;
	private int testID;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	
	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String data)
	{
		reporter = new ExtentHtmlReporter("test-output"+File.separator+
				"ExtendReport"+File.separator+"extendReport.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		
		System.out.println("Browser Launch Succesfully");
		
		if(data.equalsIgnoreCase("chrome"))
		{ 
			 
			 driver=launchChromeBrowser();
		}
		
		if(data.equalsIgnoreCase("edge"))
		{ 
			 
			 driver=launchEdgeBrowser();
		}
			
	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
		
	
	@BeforeClass
	public void objectOfPOMClasses()
	{
		loginPage=new LoginPage(driver); 
	    createNewTask= new CreateNewTask(driver);
		actitimeHeaderSection=new ActitimeHeaderSection(driver); 
		actiTimeTasks=new ActiTimeTasks(driver);
	}
	
	@BeforeMethod
	public void loginToApplication() throws EncryptedDocumentException, IOException 
	{
		driver.get("http://localhost/login.do");
		
		LoginPage loginPage=new LoginPage(driver);  
		
		String userName=Utility.fetchDataFromExcelSheet("actiTime", 1, 0);
		System.out.println(userName);
		
		loginPage.sendUsername(userName);
		
		String password=Utility.fetchDataFromExcelSheet("actiTime", 1, 1);
		System.out.println(password);
		
		loginPage.sendPassword(password);
		
		
		loginPage.keepMeLoginCheckbox();
		
		loginPage.clickLoginButton();
	}
	
	
	
	@Test (priority=1)
	public void enterTimeTrackPage()
	{	
		testID=101;
				
		actitimeHeaderSection.openTasksPage();
		
		String url=driver.getCurrentUrl();
		String expectUrl="http://localhost/tasks/otasklist.do";
		
		String tital=driver.getTitle();
		String expectedTitle="actiTIME - Open Tasks";
		
		Assert.assertEquals(tital, expectedTitle,"Title is not matching");
		Assert.assertEquals(url, expectUrl,"Url does not match");
		
				
		actiTimeTasks.openTasksPage();
		
		actiTimeTasks.editTaskDeadLine();
		
		actiTimeTasks.setTaskDeadLine("Aug 30,2022");
		
		actiTimeTasks.saveTaskDeadLine();
			
	}
	
	@Test                    // (enabled=false)
	public void createNewTask()
	{
		testID=201;
		CreateNewTask createNewTask= new CreateNewTask(driver);
		
		String url=driver.getCurrentUrl();
		String expectUrl="http://localhost/user/submit_tt.do";
	
		String tital=driver.getTitle();
		String expectedTitle="actiTIME - Enter Time-Track";
				
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertEquals(url, expectUrl);
		softAssert.assertEquals(tital, expectedTitle);
		softAssert.assertAll();
		
		
		createNewTask.clickCreateNewTaskPanel();
		createNewTask.clickSelectCustomerFromDropdown();
		createNewTask.selectNewCustomerOption();
		createNewTask.sendNewCustomerName("Swati");
		createNewTask.sendProjectName("Studies");
		createNewTask.sendTask1("Firewire");
		createNewTask.sendTask2("PasteControl");
		createNewTask.sendTask3("DoorToDoor");
		createNewTask.clickCreateTaskButton();
		createNewTask.clickSaveChangesButton();
	}
	
	@Test (enabled=false)
	public void setDeadlineforOpenTask()
	{
		testID=301;

		actiTimeTasks.openTasksPage();
		
		actiTimeTasks.editTaskDeadLine();
		
		actiTimeTasks.setTaskDeadLine("Jun 20,2022");
		
		actiTimeTasks.saveTaskDeadLine();
	}
	
	
	@AfterMethod
	public void logoutFromApplication(ITestResult res) throws IOException
	{			
		if(ITestResult.FAILURE==res.getStatus())
		{
			Utility.takeScreenShot(driver, testID);
		}
		
		actitimeHeaderSection.logOutActiTime();
	}
	
	
		@AfterClass
	public void closeObjectsOfPOMClassses()
	{
		loginPage=null; 
	    createNewTask= null;
		actitimeHeaderSection=null; 
		actiTimeTasks=null;
	}	
	
	@AfterTest
	public void quitBrowser()
	{
		driver.quit();
		driver=null;
		System.gc();
	}	
}
