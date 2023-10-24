package com.selenium.pageclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.selenium.baseclass.baseClass;

public class homePage extends baseClass{
	
	public ExtentTest logger;

	public homePage(WebDriver driver) {
		
	}
	
	public void hoverOnMenu() {
		logger = report.createTest("Verify HomePage WebElements");
		logger.log(Status.INFO, "Hovering on menu");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//WebElement menu = driver.findElement((By.xpath("//*[@id='navbar']/div[3]/div[1]/span")));
		WebElement menu = baseClass.getElement("menu_Xpath");
		Actions action = new Actions(driver);
		action.moveToElement(menu).build().perform();
		logger.log(Status.PASS, "Hover action succesfull");
	}
	
	public void clicksOnProject() {
		logger.log(Status.INFO, "Clicking on project");
		WebElement project = baseClass.getElement("project_Xpath");
		project.click();
		logger.log(Status.PASS, "Clicked on project");
		//driver.findElement(By.xpath("//*[@id='projectIcon']/ul/li[1]/a")).click();
	}
	
	public projectPage gotoProjectPage() {
		return  PageFactory.initElements(driver, projectPage.class);

	}
}
