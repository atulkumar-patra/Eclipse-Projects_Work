package com.opencart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandsOn4 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\atulk\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.opencart.com/");
		
		String ttl1 = driver.getTitle();
		System.out.println(ttl1);
		
		driver.findElement(By.xpath("//a[@class='dropdown-toggle' and @title = 'My Account']")).click();
		driver.findElement(By.xpath("//a[text() = 'Register']")).click();
		String ttl = driver.getTitle();
		System.out.println(ttl);
		
		driver.findElement(By.id("input-firstname")).sendKeys("AtulKumar");
		driver.findElement(By.id("input-lastname")).sendKeys("Patra");
		driver.findElement(By.id("input-email")).sendKeys("a3pvatra@hotmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("1231239990");
		driver.findElement(By.id("input-password")).sendKeys("pass123");
		driver.findElement(By.id("input-confirm")).sendKeys("pass123");
		driver.findElement(By.xpath("//input[@name = 'newsletter' and @checked = 'checked']")).click();
		
		driver.findElement(By.xpath("//input[@type = 'checkbox' and @name='agree']")).click();
		driver.findElement(By.xpath("//input[@type = 'submit']")).click();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Boolean sts = driver.findElement(By.cssSelector("div[id='content'] h1")).isDisplayed();
		if(sts) {
			System.out.println("Successfully Registered.");
		}else {
			System.out.println("Unable to register!");
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.quit();
		
	}

}
