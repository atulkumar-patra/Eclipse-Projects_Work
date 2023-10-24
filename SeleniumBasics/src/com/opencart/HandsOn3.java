package com.opencart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandsOn3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\atulk\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.opencart.com/");
		
		driver.findElement(By.xpath("//a[@class='dropdown-toggle' and @title = 'My Account']")).click();
		driver.findElement(By.xpath("//a[text() = 'Register']")).click();
		
		String lab = driver.findElement(By.xpath("//input[@value = 'Continue']")).getAttribute("value");
		System.out.println(lab);
		
		driver.findElement(By.xpath("//input[@type = 'submit']")).click();
		
		//input[@name = "lastname"]/following::div
		String errormsg = driver.findElement(By.xpath("//div[contains(text(),'Last Name must be')]")).getText();
		System.out.println(errormsg);
	
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	}

}
