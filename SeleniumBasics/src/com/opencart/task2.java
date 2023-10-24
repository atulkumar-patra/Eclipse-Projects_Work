package com.opencart;

//dropdown locator
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class task2 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\atulk\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.orangehrm.com/");
		
		driver.findElement(By.xpath("//*[@id='header-navbar']/ul[3]/li[2]/a")).click();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement noOfEmp = driver.findElement(By.xpath("//*[@id='Form_submitForm_NoOfEmployees']"));
		Select emp = new Select(noOfEmp);
		emp.selectByIndex(2);
		
		
		WebElement industry = driver.findElement(By.xpath("//*[@id='Form_submitForm_Industry']"));
		Select ind = new Select(industry);
		ind.selectByValue("Agriculture/Forestry");
		
		
		WebElement country = driver.findElement(By.xpath("//*[@id='Form_submitForm_Country']"));
		Select cou = new Select(country);
		cou.selectByVisibleText("India");
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//driver.quit();
	}

}
