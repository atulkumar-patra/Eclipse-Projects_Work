package com.opencart;


import java.util.concurrent.TimeUnit;

//explicitly wait

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class task4 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\atulk\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//maximize the browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//to load a page
		driver.get("https://www.itgeared.com/demo/1506-ajax-loading.html");
		
		driver.findElement(By.linkText("Click to load get data via Ajax!")).click();
		
		
		WebDriverWait ww = new WebDriverWait(driver, 20);
		ww.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='content']/div")));
//		try {
//			Thread.sleep(4000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		String str = driver.findElement(By.xpath("//*[@id='content']/div")).getText();
		System.out.println(str);
	}

}
