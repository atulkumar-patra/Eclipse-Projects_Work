package com.selenium.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.selenium.utils.extentReportManager;

public class baseClass {

	public static WebDriver driver;
	public static Properties prop;
	public ExtentReports report = extentReportManager.getReportInstance();
	public ExtentTest logger;
	
	
	//Invoke Browser
	public void invokeBrowser(String browser) {
		
		try {
			if (browser.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver","./drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("Edge")) {
				System.setProperty("webdriver.edge.driver","./drivers/msedgedriver.exe");
				driver = new EdgeDriver();
			} else {
				driver = new SafariDriver();
			}
		} catch (Exception e) {
			reportFail(e.getMessage());
			//e.getMessage();
		}
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void flushReports() {
		report.flush();
	}
	
	public static Properties setProperties() throws IOException {
		prop = new Properties();
		FileInputStream file = new FileInputStream("./Input File/config.properties");
		prop.load(file);
		return prop;
	}
	
	//Open URL
	public void openURL(String URL) {
		
		try {
			driver.get(prop.getProperty(URL));
			reportPass(URL + " Identified Successfully");
		} catch (Exception e) {
			reportFail(e.getMessage());
			e.getMessage();
		}
	}
	
	
	//Close Browser
	public void tearDown() {
		driver.close();
	}
	
	//Quit Browser
	public void quitBrowser() {
		driver.quit();
	}
	
	//Identify Element
	public static WebElement getElement(String locatorKey) {
		WebElement element = null;

		try {
			if (locatorKey.endsWith("_Id")) {
				element = driver.findElement(By.id(prop.getProperty(locatorKey)));
				//logger.log(Status.INFO, "Locator Identidied : " + locatorKey);
			} else if (locatorKey.endsWith("_Xpath")) {
				element = driver.findElement(By.xpath(prop.getProperty(locatorKey)));
				//logger.log(Status.INFO, "Locator Identidied : " + locatorKey);
			} else if (locatorKey.endsWith("_ClassName")) {
				element = driver.findElement(By.className(prop.getProperty(locatorKey)));
				//logger.log(Status.INFO, "Locator Identidied : " + locatorKey);
			} else if (locatorKey.endsWith("_CSS")) {
				element = driver.findElement(By.cssSelector(prop.getProperty(locatorKey)));
				//logger.log(Status.INFO, "Locator Identidied : " + locatorKey);
			} else if (locatorKey.endsWith("_LinkText")) {
				element = driver.findElement(By.linkText(prop.getProperty(locatorKey)));
				//logger.log(Status.INFO, "Locator Identidied : " + locatorKey);
			} else if (locatorKey.endsWith("_PartialLinkText")) {
				element = driver.findElement(By.partialLinkText(prop.getProperty(locatorKey)));
				//logger.log(Status.INFO, "Locator Identidied : " + locatorKey);
			} else if (locatorKey.endsWith("_Name")) {
				element = driver.findElement(By.name(prop.getProperty(locatorKey)));
				//logger.log(Status.INFO, "Locator Identidied : " + locatorKey);
			} else {
				reportFail("Failing the Testcase, Invalid Locator " + locatorKey);
			}
		} catch (Exception e) {

			// Fail the TestCase and Report the error
			reportFail(e.getMessage());
			e.printStackTrace();
		}
		return element;
	}
	
	//Enter Text
	public void enterText(String xpathKey, String data) {
		try {
			getElement(xpathKey).sendKeys(data);
			reportPass(data + " - Entered successfully in locator Element : " + xpathKey);
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	//Click Element
	public void elementClick(String xpathKey) {
		try {
			getElement(xpathKey).click();
			reportPass(xpathKey + " : Element Clicked Successfully");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	//Reporting Functions
	public static void reportFail(String reportString) {
		//logger.log(Status.FAIL, reportString);
		//takeScreenShot();
		Assert.fail(reportString);
	}

	public void reportPass(String reportString) {
		logger.log(Status.PASS, reportString);
	}
	
	/* This method is used to take screenshot */
	public static void takeScreenShot(String name) throws InterruptedException {
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		File sourceFile = takeScreenShot.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(sourceFile, new File(System.getProperty("user.dir") + "\\ScreenShots\\"+name+".png"));
			//logger.addScreenCaptureFromPath(System.getProperty("user.dir") + "\\ScreenShots\\"+name+".png");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//Read from excel sheet
	public static String[] readExcelData() throws IOException {
		File f = new File("./Input File/details.xlsx");
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheetAt(0);
		XSSFRow row = sh.getRow(1);
		String[] details = new String[5];
		for(int i=0; i<5; i++) {
			details[i] = row.getCell(i).toString();
		}
		return details;
	}
	
	//Mouse Hover
	public void mouseHover(String xpathKey) {
		Actions action = new Actions(driver);
		WebElement element = null;
		element = getElement(xpathKey);
		action.moveToElement(element).build().perform();
	}
	
	//WebDriver Wait
	public void webDriverWait(String xpathKey, int waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.visibilityOf(getElement(xpathKey)));

	}
	
	//Scrolling
	public void scrolling(int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(x,y)");

	}
	
}
