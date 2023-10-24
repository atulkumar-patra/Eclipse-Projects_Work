package com.opencart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AllWebElement {
	
	static String baseUrl = "https://webapps.tekstac.com/InvoiceUpdates/";
	static WebDriver driver;
	static WebElement element;
	static String Category;
	static String msg;
	
	public WebDriver createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\atulk\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}
	
	public void navigate(WebDriver driver) {
		driver.get(baseUrl);
	}
	
	public Select getCategoryElement(WebDriver driver) {
		WebElement ctg = driver.findElement(By.tagName("select"));
		Select Category = new Select(ctg);
		Category.selectByVisibleText("Utility Invoice");
		return Category;
	}
	
	public void setFormValues(WebDriver driver) {
		
		driver.findElement(By.id("name")).sendKeys("Rakesh");
		driver.findElement(By.id("number")).sendKeys("123");
		driver.findElement(By.id("newUser")).click();
		
		Select Category = getCategoryElement(driver);
		Category.selectByVisibleText("Utility Invoice");
		
		driver.findElement(By.name("amount")).sendKeys("1000");
		driver.findElement(By.name("num")).sendKeys("9876543210");
		driver.findElement(By.name("comments")).sendKeys("New User Invoice");
		
		driver.findElement(By.id("submit")).click();
		
	}
	
	public WebElement getSuccessMessageElement(WebDriver driver) {
		element = driver.findElement(By.id("result"));
		return element;
	}
	
	public String getSuccessMessage(WebElement element) {
		msg = element.getAttribute("value");
		return msg;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AllWebElement awe = new AllWebElement();
		awe.navigate(driver);
		awe.getCategoryElement(driver);
		awe.setFormValues(driver);
		awe.getSuccessMessageElement(driver);
		awe.getSuccessMessage(element);
		
	}

}
