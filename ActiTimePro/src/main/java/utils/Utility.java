package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility 
{
	               	                
	public static String fetchDataFromExcelSheet(String sheet,int row,int col) throws EncryptedDocumentException, IOException
	{
		
		String path = "C:\\Users\\sai\\Desktop\\Book1.xlsx";
		FileInputStream file = new FileInputStream(path);
		String value = WorkbookFactory.create(file).getSheet("actiTime").getRow(row).getCell(col).getStringCellValue();
		String  data=value;
		return data;
	
		//try
		//{
//			String value = WorkbookFactory.create(file).getSheet("actiTime").getRow(row).getCell(col).getStringCellValue();
//			String data =value;
		//}
		//
		//catch(IllegalStateException e)
		//{
//			double Num = WorkbookFactory.create(file).getSheet("actiTime").getRow(row).getCell(col).getNumericCellValue();
		//	
//			String s1=String.valueOf(Num);
		//	
//			String data=s1;
		//	
		//}
		//	
		//catch(NullPointerException e1)
		//{
//			System.out.println("Given cell does not contain data");
		//}
		//
		//
		//return data;
		//		
	}
	
	public static void takeScreenShot(WebDriver driver,int testID) throws IOException
	{
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MM yyyy HH mm ss");  
		LocalDateTime now = LocalDateTime.now(); 
		String DT=dtf.format(now);
	
		
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest =new File("E:\\AutomationSnaps\\ " + " TestID " + DT);
		FileHandler.copy(src, dest);	
		
	}
}









