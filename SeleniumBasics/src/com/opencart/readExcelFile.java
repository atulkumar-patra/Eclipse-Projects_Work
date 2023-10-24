package com.opencart;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class readExcelFile {
	
	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.opencart.com/index.php?route=account/register");
		
//		String ttl = driver.getTitle();
//		System.out.println(ttl);
		
		File f = new File("inputData.xlsx");
		f.getAbsolutePath();
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheetAt(0);
		
		driver.findElement(By.id("input-firstname")).sendKeys(sh.getRow(1).getCell(0).getStringCellValue());
		driver.findElement(By.id("input-lastname")).sendKeys(sh.getRow(1).getCell(1).getStringCellValue());

		wb.close();
		
		driver.quit();
	}
}
