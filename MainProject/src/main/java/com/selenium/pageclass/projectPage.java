package com.selenium.pageclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.selenium.baseclass.baseClass;

public class projectPage extends baseClass {
	
	public ExtentTest logger;
	Actions action = new Actions(driver);
	
	public projectPage(WebDriver driver) {
		projectPage.driver = driver;
		
	}
	
	public void hoverOnExecuteMenu() {
		logger = report.createTest("Verify ProjectPage WebElements");
		logger.log(Status.INFO, "Hovering on Execute menu");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement execute = baseClass.getElement("execute_Xpath");
		//WebElement execute = driver.findElement(By.xpath("//*[@id='LOCK_Execute']"));
		action.moveToElement(execute).build().perform();
		logger.log(Status.PASS, "Execute menu expanded");
	}
	
	public void clicksOnEpics() {
		WebElement epics = baseClass.getElement("epic_Xpath");
		epics.click();
		//driver.findElement(By.xpath("//*[@id='LOCK_Epics']")).click();
	}
	
	public epicModulePage gotoEpicModulePage() {
		return  PageFactory.initElements(driver, epicModulePage.class);

	}
	
}
