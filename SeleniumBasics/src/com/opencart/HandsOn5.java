package com.opencart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandsOn5 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\atulk\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://demo.opencart.com/");
		driver.findElement(By.xpath("//a[@class='dropdown-toggle' and @title = 'My Account']")).click();
		driver.findElement(By.xpath("//a[text() = 'Register']")).click();
		
		WebElement noButton  = driver.findElement(By.xpath("//input[contains(@name, 'newsletter') and @value='1']"));
		boolean stt = noButton.isSelected();
		if(stt) {
			System.out.println("selected");
		}
		else {
			System.out.println("not selected");
			driver.findElement(By.xpath("//label[normalize-space()='Yes']")).click();
		}
		boolean status_agree1 = driver.findElement(By.xpath("//input[@name='agree']")).isSelected();
		if(status_agree1) {
			System.out.println("Privacy Policy checkbox selected");
		}
		else {
			System.out.println("Checkbox not selected");
			driver.findElement(By.xpath("//input[@name='agree']")).click();
		}
		Thread.sleep(1000);
		
		boolean status_yes_final = driver.findElement(By.xpath("//input[@value='1']")).isSelected();
		boolean status_agree_final = driver.findElement(By.xpath("//input[@name='agree']")).isSelected();
		
		System.out.println("Status of Yes button: "+status_yes_final);
		System.out.println("Status of Agree checkbox: "+status_agree_final);
		driver.close();
	}

}
