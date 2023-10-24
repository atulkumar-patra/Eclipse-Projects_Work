package com.pageclass.displaybookshelves;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.baseclass.displaybookshelves.baseClass;

public class bookshelvesPage1 extends baseClass {
	
	//public static WebDriver driver;
	Actions action = new Actions(driver);
	WebDriverWait wait = new WebDriverWait(driver, 300);

	public bookshelvesPage1(WebDriver driver) {
		bookshelvesPage1.driver = driver;

	}

	public void setCategory() throws InterruptedException {
		Thread.sleep(2000);
		WebElement category = baseClass.getElement("category_Xpath");
		action.moveToElement(category).build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("bookshelve_Xpath"))));
		baseClass.getElement("bookshelve_Xpath").click();
	}
	
	public void selectPrice() {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		WebElement price = baseClass.getElement("price_Xpath");
		action.moveToElement(price).build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("upper_Xpath"))));
		WebElement upper = baseClass.getElement("upper_Xpath");
		int uwidth = upper.getSize().width;
		Actions action = new Actions(driver);
		action.dragAndDropBy(upper, (int) (-uwidth * (12.2)), 0);
		action.build().perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void setStorageType() {
		WebElement storageType = baseClass.getElement("storageType_Xpath");
		action.moveToElement(storageType).build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("typeOpen_Xpath"))));
		WebElement typeOpen = baseClass.getElement("typeOpen_Xpath");
		typeOpen.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
	
	public void clickOutOfStock() {
		WebElement outofstockCheckbox = baseClass.getElement("outOfStock_Xpath");
		outofstockCheckbox.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
	
	public void getBookDetails() {
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<WebElement> productName = driver.findElements(By.xpath(prop.getProperty("productName_Xpath")));
		List<WebElement> productPrice = driver.findElements(By.xpath(prop.getProperty("productPrice_Xpath")));

		System.out.println("***************************************************************************************");
		System.out.println("Displaying Bookshelves and it's Price:    ");
		
		//Iterate through Name & Price list
		Iterator<WebElement> nameIterator = productName.iterator();
		Iterator<WebElement> priceIterator = productPrice.iterator();
		
		//Displaying first 3 product details
		int count=0;
		while(nameIterator.hasNext() && priceIterator.hasNext() && count<3){
			System.out.println("Product Name: " + nameIterator.next().getText());
			System.out.println("Price : " +priceIterator.next().getText());
			count++;
		}
	}
	
}
