package com.opencart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserCommand {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\atulk\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//maximize the browser
		driver.manage().window().maximize();
		
		//to load a page
		driver.get("https://demo.opencart.com/");
		//or
		//driver.navigate().to("https://www.hdfcbank.com/");
		
		//to get the title of a page
		String tt = driver.getTitle();
		System.out.println(tt);
	
		//to get Title length
		int ttLnth = driver.getTitle().length();
		System.out.println(ttLnth);
		
		
		
		//get the URL
		String URL = driver.getCurrentUrl();
		System.out.println(URL);
		
		//get page source
//		String PSource = driver.getPageSource();
//		System.out.println(PSource);
		
		//get length of page source
		int PSourceLength = URL.length();
		System.out.println(PSourceLength);
		
		
		//find element
		// driver.findElement(By.xpath(".//*[@id='menu-item-374']/a")).click();
		 
		//to forward
		//driver.navigate().forward();
		
		//to backward
		//driver.navigate().back();
		
		
		//WEB ELEMENT
		
		//to send inputs
		driver.findElement(By.id("first-name")).sendKeys("Kumar");
		//or
		WebElement txtBox_name = driver.findElement(By.id("last-name"));
		txtBox_name.sendKeys("Patra");
		//can clear the text
		txtBox_name.clear();
		//can send another text
		txtBox_name.sendKeys("Somni");
		
		
		//whether checkbox is checked or not
		
		
		
		//to close the browser
		//driver.close();
		//or
		//to quit the browser and driver as well
		//driver.quit();

	}

}
