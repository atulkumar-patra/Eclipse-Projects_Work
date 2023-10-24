package com.opencart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class Dropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\atulk\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//li[@xpath = '1']")).click();
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//driver.findElement(By.id("u_0_2_Rx"));
		
		
		WebElement monthDropDown = driver.findElement(By.id("month"));
		Select mnth = new Select(monthDropDown);
		mnth.selectByIndex(5);
	}

}
