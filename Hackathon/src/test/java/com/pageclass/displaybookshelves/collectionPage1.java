package com.pageclass.displaybookshelves;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import com.aventstack.extentreports.ExtentTest;
import com.baseclass.displaybookshelves.baseClass;

public class collectionPage1 extends baseClass {

	public collectionPage1(WebDriver driver) {
		baseClass.driver = driver;

	}
	
	//scroll to top
	public void scrollingUp() {
		System.out.println("***************************************************************************************");
		System.out.println("Displaying Sub-Menu Under NewArrival List:    ");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-300)");
	}
	
	//Click on collection
	public void collection() throws InterruptedException {
		Thread.sleep(1000);
		baseClass.getElement("collection_Xpath").click();
	}
	
	//SubMenu items under NewArrival List
	public void subMenuList() throws InterruptedException {
		Thread.sleep(1000);
		baseClass.getElement("newArrivals_Xpath").click();
		List<WebElement> subMenu = driver.findElements(By.xpath(prop.getProperty("subMenuItems_Xpath")));
		Iterator<WebElement> subMenuIterator = subMenu.iterator();
		
		while(subMenuIterator.hasNext()){
			System.out.println("Sub-Menu: " + subMenuIterator.next().getText());
		}
	}
}
