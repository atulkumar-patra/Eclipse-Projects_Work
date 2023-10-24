package com.opencart;



import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class miniProject_trial {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver;
		DriverSetup setup = new DriverSetup();
		driver = setup.openBrowser();
			
		
		//set driver
	//	//System.setProperty("webdriver.chrome.driver", "C:\\Users\\atulk\\chromedriver_win32\\chromedriver.exe");
		
		//use ChromeOption to open browser forcefully
//		ChromeOptions co = new ChromeOptions();
//		co.setPageLoadStrategy(PageLoadStrategy.EAGER);
		
		//create driver object
		//WebDriver driver = new ChromeDriver();
		
		//maximize the window
		driver.manage().window().maximize();
		
		//timeWait
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		
		//importing input from "config.properties" file
		FileReader fl = new FileReader("./Input Files/config.properties");
		Properties data = new Properties();
		data.load(fl);
		
		
		//navigate to the URL
		//driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.navigate().to(data.getProperty("URL"));

		
		//enter username
		WebElement UserName = driver.findElement(By.id("txtUsername"));
		//UserName.sendKeys("Admin");
		UserName.sendKeys(data.getProperty("UserName"));
		
		//enter password
		WebElement PassWord = driver.findElement(By.id("txtPassword"));
		//PassWord.sendKeys("admin123");
		PassWord.sendKeys(data.getProperty("PassWord"));
		
		//click login
		WebElement logIn = driver.findElement(By.id("btnLogin"));
		logIn.click();
		


		
		//click on admin
		// /html/body/div[1]/div[2]/ul/li[1]/a/b
		WebElement admin = driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[1]/a/b"));
		//WebElement admin = driver.findElement(By.xpath("//*[@id='menu_admin_viewAdminModule']/b"));
		//admin.click();
		
		Actions action = new Actions(driver);
		action.moveToElement(admin).build().perform();
		
		
		
		//click on qualification
		driver.findElement(By.id("menu_admin_Qualifications")).click();
		
		//click on skills
		driver.findElement(By.id("menu_admin_viewSkills")).click();
		

		
		//count the check boxes before adding an extra skill
		int countCheckboxes1;
		List<WebElement> beforeSkillAddition = driver.findElements(By.xpath("//input[@type = 'checkbox']"));
		countCheckboxes1 = beforeSkillAddition.size();
		//System.out.println(countCheckboxes1);
		
		
		//add new skills
		driver.findElement(By.id("btnAdd")).click();
		
		//set skill as "Testing Demo"
		WebElement skillName = driver.findElement(By.id("skill_name"));
		//skillName.sendKeys("Testing Demo");
		skillName.sendKeys(data.getProperty("Skill"));
		
		//click on save
		driver.findElement(By.id("btnSave")).click();
		

		

		//select "Testing Demo"
		driver.findElement(By.xpath("//a[contains(text(), 'Testing Demo')]/parent::td/parent::tr/td/input")).click();
		

		
		//delete "Testing Demo"
		driver.findElement(By.id("btnDel")).click();
		
		
		
		//count the checkboxes after deleting the extra skill
		int countCheckboxes2;
		List<WebElement> afterSkillDeletion = driver.findElements(By.xpath("//input[@type = 'checkbox']"));
		countCheckboxes2 = afterSkillDeletion.size();
		//System.out.println(countCheckboxes2);


		
		//Checking whether the skill is deleted or not
		if(countCheckboxes1 == countCheckboxes2) {
			System.out.println("Extra Skill is Deleted Successfully.");
		}
		else {
			System.out.println("Extra Skill is not Deleted!");
			System.out.println("Trying again.....");
			driver.findElement(By.xpath("//a[contains(text(), 'Testing Demo')]/parent::td/parent::tr/td/input")).click();
			driver.findElement(By.id("btnDel")).click();
		}
		
		//click on account
		driver.findElement(By.id("welcome")).click();
	
		//logOut
		WebDriverWait wait = new WebDriverWait(driver,10);
	  	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Logout')]"))).click();
	  	

		
		driver.quit();

	}

}
