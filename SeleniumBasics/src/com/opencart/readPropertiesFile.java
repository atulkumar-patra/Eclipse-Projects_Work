package com.opencart;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class readPropertiesFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//maximize the window
		driver.manage().window().maximize();
		
		FileReader fl = new FileReader("config.properties");
		Properties data = new Properties();
		data.load(fl);
		
		driver.get(data.getProperty("URL"));
		
		driver.findElement(By.id("input-firstname")).sendKeys(data.getProperty("fName"));
		driver.findElement(By.id("input-lastname")).sendKeys(data.getProperty("lName"));
	}

}
