package com.pageclass.displaybookshelves;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import com.aventstack.extentreports.ExtentTest;
import com.baseclass.displaybookshelves.baseClass;

public class homePage extends baseClass{
	
	public WebElement popup;
	public WebElement searchBox;
	public WebElement searchBtn;
	public static Properties prop;
	
	public homePage(WebDriver driver) {
		
	}

	public void closePopup() throws InterruptedException {
		Thread.sleep(8000);
		popup = baseClass.getElement("popup_Xpath");
		popup.click();
		
	}

	public void searchBox(String input) throws InterruptedException {
		Thread.sleep(2000);
		searchBox = baseClass.getElement("searchBox_Id");
		searchBox.sendKeys(input);
		
	}
	
	public bookshelvesPage1 gotoBookshelves() {
		searchBtn = baseClass.getElement("searchBtn_Xpath");
		searchBtn.click();
		return  PageFactory.initElements(driver, bookshelvesPage1.class);
	}
	
}
