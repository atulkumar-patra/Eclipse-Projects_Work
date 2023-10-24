package com.opencart;

//checkbox
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class task1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\atulk\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.spicejet.com/");
		
		String title = driver.getTitle();
		System.out.println(title);
		
		boolean chkd = driver.findElement(By.xpath("//*[@id='ctl00_mainContent_chk_friendsandfamily']")).isSelected();
		if(chkd == false) {
			System.out.println("Unchecked!");
			driver.findElement(By.xpath("//*[@id='ctl00_mainContent_chk_friendsandfamily']")).click();
		}
		else {
			System.out.println("Checked.");
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		boolean newchkd = driver.findElement(By.xpath("//*[@id='ctl00_mainContent_chk_friendsandfamily']")).isSelected();
		if(newchkd == true) {
			System.out.println("Checked");
		}
		
		List<WebElement> chkBoxes = driver.findElements(By.xpath("//input[@type = 'checkbox']"));
		int no = chkBoxes.size();
		System.out.println(no);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.quit();
		
		
	}

}
