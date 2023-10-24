package com.selenium.testclass;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.selenium.baseclass.baseClass;
import com.selenium.pageclass.epicModulePage;
import com.selenium.pageclass.homePage;
import com.selenium.pageclass.projectPage;

public class validateEpicModule extends baseClass{

	homePage homepage = new homePage(driver);
	projectPage projectpage;
	epicModulePage epicmodulepage;
	
	@BeforeClass
	public void initializeSetup() throws IOException, InterruptedException {
		Properties prop = baseClass.setProperties();
		String browser = prop.getProperty("browser");
		invokeBrowser(browser);
		driver.get(prop.getProperty("URL"));
		Thread.sleep(60000);
		
	}
	
	@Test(priority = 1)
	public void home_Page() {
		
		homepage.hoverOnMenu();
		homepage.clicksOnProject();
		projectpage = homepage.gotoProjectPage();
		
	}
	
	@Test(priority = 2)
	public void project_Page() {
		
		projectpage.hoverOnExecuteMenu();
		projectpage.clicksOnEpics();
		epicmodulepage = projectpage.gotoEpicModulePage();
	}
	
	@Test(priority = 3)
	public void epic_Page_valid() throws InterruptedException, IOException {
		
		String Name = baseClass.readExcelData()[0];
		String Date = baseClass.readExcelData()[1];
		String Description = baseClass.readExcelData()[2];
		String Priority = baseClass.readExcelData()[3];
		String Size = baseClass.readExcelData()[4];
		
		epicmodulepage.addEpic();
		epicmodulepage.detailsFrame();
		epicmodulepage.validDetails(Name, Date, Description, Priority, Size);
		epicmodulepage.save();
		epicmodulepage.fetchId();

	}
	
	@Test(priority = 4)
	public void epic_Page_invalid() throws InterruptedException, IOException {
		
		epicmodulepage.invalidName();
		epicmodulepage.invalidDate();
		epicmodulepage.save();
		epicmodulepage.handleAlert();
		Thread.sleep(2000);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
