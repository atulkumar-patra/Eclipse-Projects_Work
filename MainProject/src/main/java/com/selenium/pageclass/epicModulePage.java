package com.selenium.pageclass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.selenium.baseclass.baseClass;

public class epicModulePage extends baseClass{
	
	public ExtentTest logger;
	public ExtentTest logger2;
	
	public epicModulePage(WebDriver driver) {
		epicModulePage.driver=driver;
	}
	
	public static String epicId;
	
	//click on plusIcon to add module
	public void addEpic() throws InterruptedException {
		logger = report.createTest("Creating Epic module with valid details");
		logger.log(Status.INFO, "Clicking add button");
		Thread.sleep(2000);
		WebElement plusIcon = baseClass.getElement("plusIcon_Id");
		plusIcon.click();
		logger.log(Status.PASS, "Clicked on add button");
		Thread.sleep(2000);
	}
	
	//switch to details frame
	public void detailsFrame() throws InterruptedException {
		driver.switchTo().frame("contentframe");
		Thread.sleep(2000);
	}
	
	//enter mandatory details
	public void mandatoryDetails(String name, String date) {
		WebElement nameTextbox = baseClass.getElement("nameTextbox_Id");
		nameTextbox.sendKeys(name);
		WebElement dateField = baseClass.getElement("dateField_Id");
		dateField.sendKeys(date);
	}
	
	//enter description
	public void addDescription(String description) {
		WebElement descriptionTextbox = baseClass.getElement("decriptionTextbox_Id");
		descriptionTextbox.sendKeys(description);
	}
	
	//select a priority
	public void selectPriority(String p) 
   	{
		WebElement priority = baseClass.getElement("priorityDropdown_Id");
    	Select priorityDropdown = new Select(priority);
   		priorityDropdown.selectByValue(p);

   	}
	
	//select a size
	public void selectSize(String s) {
		WebElement size = baseClass.getElement("sizeDropdown_Id");
   		Select sizeDropdown = new Select(size);
   		sizeDropdown.selectByVisibleText(s);
	}
	
	//click on save button
	public void save() throws InterruptedException {
		logger.log(Status.INFO, "Clicking on save button");
		WebElement save = baseClass.getElement("saveButton_Id");
		save.click();
		logger.log(Status.PASS, "Clicked on save button");
		Thread.sleep(3000);
	}
	
	//fetch & display module ID
	public String fetchId() throws InterruptedException, IOException {
		String validScreen = "EpicIdGenerated";
		takeScreenShot(validScreen);
		epicId = baseClass.getElement("epicId_Id").getText();
		System.out.println("Module ID: "+ epicId);
		logger.log(Status.PASS, "Module ID has been displayed");
		return epicId;
	}
	
	//handle alert
	public void handleAlert() throws InterruptedException, IOException {
		//String screenName = "AlertMessage";
		//takeScreenShot(screenName);
		logger2.log(Status.INFO, "Handling Alert");
		Alert alert = driver.switchTo().alert();
		logger2.log(Status.INFO, "Displaying alert message");
		System.out.println(alert.getText());
		logger2.log(Status.PASS, "Alert message displayed");
		alert.accept();
		logger2.log(Status.PASS, "Alert accepted");
		logger2.log(Status.FAIL, "Epic module with invalid details not created.");
	}
	
	//valid case
	public void validDetails(String name, String date, String desc, String p, String s) throws InterruptedException {
		logger.log(Status.INFO, "Entering valid details");
		System.out.println("For valid case:");
		mandatoryDetails(name, date);
		logger.log(Status.PASS, "Entered Name and Date");
		addDescription(desc);
		logger.log(Status.PASS, "Added a description");
		Thread.sleep(1000);
		selectPriority(p);
		logger.log(Status.PASS, "Selected a priority");
		Thread.sleep(1000);
		selectSize(s);
		logger.log(Status.PASS, "Selected a size");
	}
	
	//invalid case
	public void invalidName() throws InterruptedException {
		logger2 = report.createTest("Creating Epic module with invalid details");
		logger2.log(Status.INFO, "Entering invalid details");
		logger2.log(Status.INFO, "Clearing Name field");
		baseClass.getElement("nameTextbox_Id").clear();
		logger2.log(Status.PASS, "Name field has been cleared");
		Thread.sleep(2000);
	}
	
	public void invalidDate() throws InterruptedException {
		//System.out.println("Entering Invalid date:");
		logger2.log(Status.INFO, "Clearing Date field");
		baseClass.getElement("dateField_Id").clear();
		logger2.log(Status.PASS, "Date field has been cleared");
		logger2.log(Status.INFO, "Clicking on save button");
		Thread.sleep(2000);
	}

}
