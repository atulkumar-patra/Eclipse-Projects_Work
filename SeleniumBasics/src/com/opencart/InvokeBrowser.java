package com.opencart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvokeBrowser {

	public static void main(String[] args) throws InterruptedException {
		 
		//set path of chrome driver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\atulk\\chromedriver_win32\\chromedriver.exe");
		//create new chrome driver object
		WebDriver driver = new ChromeDriver();
		//to load a page
		driver.get("https://demo.opencart.com/index.php?route=account/register");
		//find the element
		driver.findElement(By.id("input-firstname")).sendKeys("AtulKumar");
		driver.findElement(By.id("input-lastname")).sendKeys("Patra");
		driver.findElement(By.id("input-email")).sendKeys("apatra@hotmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("1231239990");
		driver.findElement(By.id("input-password")).sendKeys("pass123");
		driver.findElement(By.id("input-confirm")).sendKeys("pass123");
		driver.findElement(By.xpath("//input[@name = 'newsletter' and @checked = 'checked']")).click();
		//Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@type = 'checkbox' and @name='agree']")).click();
		//input[@type = "submit"]
		driver.findElement(By.xpath("//input[@type = 'submit']")).click();

		//close the driver
		System.out.println("Script executed successfully");
		driver.close();
	}

}
