package com.opencart;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class handleSlider {

	public static void main(String[] args) {
		//get driver
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//javascript executor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//get the URL
		//driver.get("https://www.urbanladder.com/");
		//by JsExecotor
		js.executeScript("window.location='https://www.urbanladder.com/'");
		
		//maximize
		driver.manage().window().maximize();

		//timeout
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		//navigate to storage
		WebElement storage = driver.findElement(By.xpath("//*[@id='topnav_wrapper']/ul/li[5]/span"));
		
		//use Action class to perform MouseHover
		Actions action = new Actions(driver);
		action.moveToElement(storage).build().perform();
		
		//wait until the bookshelves element appears 
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='topnav_wrapper']/ul/li[5]/div/div/ul/li[1]/ul/li[2]/a/span"))));
		
		//click on bookshelves 
		WebElement bookshelves = driver.findElement(By.xpath("//*[@id='topnav_wrapper']/ul/li[5]/div/div/ul/li[1]/ul/li[2]/a/span"));
		bookshelves.click();
		
//		//click on Exclude Out of Stock
//		WebElement stock = driver.findElement(By.xpath("//*[@id='filters_availability_In_Stock_Only']"));
//		stock.click();
//		
		
		//set the price to 15000/-
		//move the cursor on PRICE
		WebElement price = driver.findElement(By.xpath("//*[@id='filters-form']/div[1]/div/div/ul/li[1]/div[1]"));
		
		//Actions action = new Actions(driver);
		action.moveToElement(price).build().perform();
		

		//LOW end
		wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='filters-form']/div[1]/div/div/ul/li[1]/div[2]/div/div/ul/li[1]/div/div[2]/div[2]/div/div[1]/div")));
		
		// //*[@id='filters-form']/div[1]/div/div/ul/li[1]/div[2]/div/div/ul/li[1]/div/div[2]/div[2]/div/div[1]/div
    	WebElement low = driver.findElement(By.xpath("//*[@id='filters-form']/div[1]/div/div/ul/li[1]/div[2]/div/div/ul/li[1]/div/div[2]/div[2]/div/div[1]/div"));

		
		int lwidth = low.getSize().width;
		action.dragAndDropBy(low, lwidth*3, 0);
		action.build().perform();
		

		//upperEnd slider (Price)
		wait = new WebDriverWait(driver, 300);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='filters-form']/div[1]/div/div/ul/li[1]/div[2]/div/div/ul/li[1]/div/div[2]/div[2]/div/div[2]/div")));
		
		// //*[@id='filters-form']/div[1]/div/div/ul/li[1]/div[2]/div/div/ul/li[1]/div/div[2]/div[2]/div/div[2]/div		
    	WebElement upper = driver.findElement(By.xpath("//*[@id='filters-form']/div[1]/div/div/ul/li[1]/div[2]/div/div/ul/li[1]/div/div[2]/div[2]/div/div[2]/div"));

		int uwidth = upper.getSize().width;
		action.dragAndDropBy(upper, (int) (-uwidth*(12.3)), 0);   //price is set to 15,640/-  by multiplying 12  but we need the price to be below 15,000/-
		action.build().perform();
		
		
	}

}
