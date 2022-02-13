
//Create new Task on EnterTime track tab-successful run- seperate test-with Assertion 

package actitimeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
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

import actiTimePOM.ActitimeHeaderSection;
import actiTimePOM.CreateNewTask;
import actiTimePOM.LoginPage;
import base.Browser;
import utils.Utility;

public class CreateNewTaskTestNG extends Browser
{	
	
	private WebDriver driver;
	private ActitimeHeaderSection actitimeHeaderSection ;
	private CreateNewTask createNewTask;
	private LoginPage loginPage;
	private int TestID;
	
	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String data)
	{
		System.out.println("data");
		
		if(data.equalsIgnoreCase("chrome"))
		{ 
			 
			 driver=launchChromeBrowser();
		}
		
//		if(data.equalsIgnoreCase("edge"))
//		{ 
//			 
//			 driver=launchEdgeBrowser();
//		}
			
	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	@BeforeClass
	
	public void createObjectsOfPOMClass()
	{
		loginPage=new LoginPage(driver); 
	    createNewTask= new CreateNewTask(driver);
		actitimeHeaderSection=new ActitimeHeaderSection(driver); 
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
	
	
	@Test
	public void createNewTask()
	{	TestID=101;
		CreateNewTask createNewTask= new CreateNewTask(driver);
		
		String url=driver.getCurrentUrl();
		String expectUrl="http://localhost/user/submit_tt.do";
	
		String tital=driver.getTitle();
		String expectedTitle="actiTIME - Enter Time-Track";
				
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertEquals(url, expectUrl);
		softAssert.assertEquals(tital, expectedTitle);
		softAssert.assertAll();
		
//		Assert.assertEquals(url, expectUrl,"url does not match");
//		Assert.assertEquals(tital, expectedTitle,"title does not match");
		
		createNewTask.clickCreateNewTaskPanel();
		createNewTask.clickSelectCustomerFromDropdown();
		createNewTask.selectNewCustomerOption();
		createNewTask.sendNewCustomerName("Pradnya");
		createNewTask.sendProjectName("NetworkHandling");
		createNewTask.sendTask1("Support");
//		createNewTask.sendTask2("NSE");
//		createNewTask.sendTask3("BSE");
		createNewTask.clickCreateTaskButton();
		createNewTask.clickSaveChangesButton();
		
	}
	
	@AfterMethod
	public void logoutFromApplication(ITestResult res) throws IOException
	{			
		if(ITestResult.FAILURE==res.getStatus())
		{
			Utility.takeScreenShot(driver, TestID);
		}
		
		actitimeHeaderSection.logOutActiTime();
	}
	
	@AfterClass
	public void clearPOMClassObjects()
	{
		loginPage=null; 
	    createNewTask= null;
		actitimeHeaderSection=null; 
	}	
	
	@AfterTest
	public void quitBrowser()
	{
		driver.quit();
		driver=null;
		System.gc();
	}	
}
