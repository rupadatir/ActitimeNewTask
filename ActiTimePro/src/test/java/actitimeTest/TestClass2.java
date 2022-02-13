package actitimeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import actiTimePOM.ActitimeHeaderSection;

public class TestClass2

{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Rupali\\Softwares\\chromedriver_win32 97.0\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get("http://localhost/login.do");
	
		
		//ActitimeHeaderSection POM class object
		
		ActitimeHeaderSection actitimeHeaderSection =  new ActitimeHeaderSection(driver);
	
		actitimeHeaderSection.openTasksPage();
		
		actitimeHeaderSection.OpenReportPage();
		
		actitimeHeaderSection.openUsersPage();
		
		actitimeHeaderSection.openWorkSchedule();
		
		actitimeHeaderSection.logOutActiTime();
	}

}
