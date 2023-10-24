package com.opencart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandsOn2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\atulk\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		driver.navigate().to("https://www.hdfcbank.com/");
		
		String ttl = driver.getTitle();
		System.out.println(ttl);
		
		driver.get("https://www.icicibank.com/");
		String URL = driver.getCurrentUrl();
		System.out.println(URL);
		
		driver.manage().window().maximize();
		
		driver.navigate().back();
		String URL1 = driver.getCurrentUrl();
		System.out.println(URL1);
		
		driver.navigate().forward();
		String ttl1 = driver.getTitle();
		System.out.println(ttl1);
		
		String URL2 = driver.getCurrentUrl();
		System.out.println(URL2);
		
	}

}
