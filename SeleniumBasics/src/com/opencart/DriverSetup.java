package com.opencart;

import java.util.*;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverSetup {

	public static WebDriver driver;
	
	public WebDriver openBrowser() {
		System.out.println("Choose a Browser (Chrome or Firefox or Edge):");
		Scanner sc = new Scanner(System.in);
		String Browser = sc.nextLine();
		
		if(Browser.equalsIgnoreCase("Chrome")) {
			System.out.println("Chrome Browser is Opening.");
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if(Browser.equalsIgnoreCase("Firefox")) {
			System.out.println("Firefox Browser is Opening.");
			System.setProperty("webdriver.gecko.driver","./drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		else if(Browser.equalsIgnoreCase("Edge")) {
			System.out.println("Edge Browser is Opening.");
			System.setProperty("webdriver.edge.driver","./drivers/msedgedriver.exe");
			driver = new EdgeDriver();
		}
		else {
			System.out.println("No Browser value is choosen!");
			System.out.println("Default Browser is Opening.");
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(22, TimeUnit.SECONDS);
		
		sc.close();
		
		return driver;
	}
	
}	
