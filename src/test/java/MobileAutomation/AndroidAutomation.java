package MobileAutomation;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import java.net.URL;
import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;		
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;		
import org.testng.annotations.Test;	
import org.testng.annotations.BeforeTest;	
import org.testng.annotations.AfterTest;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;


public class AndroidAutomation {
	private WebDriver driver;	
	DesiredCapabilities capabilities = new DesiredCapabilities();
	@BeforeTest
	public void beforeTest() {	
		
		capabilities.setCapability("platformVersion", "6.0.1"); 
		capabilities.setCapability("udid", "5203e65cee0d638d");
		capabilities.setCapability("deviceName","Galaxy J7");
		capabilities.setCapability("platformName","Android");
	    capabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");
	    capabilities.setCapability("appActivity","com.sec.android.app.popupcalculator.Calculator");
	}
	@Test				
	public void testEasy() {	
		 try {
			 driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			 driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_08")).click();
			 String FILE_NAME = "/DataFiles/DataFile.xlsx";
			 FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
	         Workbook workbook = new XSSFWorkbook(excelFile);
	         Sheet datatypeSheet = workbook.getSheetAt(0);
	         for(int i=0;i<datatypeSheet.getLastRowNum();i++)
	         {
	        	 Row row = datatypeSheet.getRow(i);
	        	 String temp1 = row.getCell(0).getStringCellValue();
	        	 System.out.println(temp1);
        	  
	         }
        	 }catch(Exception e)
        	 {
        		 e.printStackTrace();
        	 }		
	}	
			
	@AfterTest
	public void afterTest() {
		driver.quit();			
	}		
}
