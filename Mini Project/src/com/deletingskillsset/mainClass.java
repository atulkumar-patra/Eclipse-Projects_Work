package com.deletingskillsset;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class mainClass {

	public static void main(String[] args) throws IOException {
		
		//Calling DriverSetup class
		WebDriver driver;
		DriverSetup setup = new DriverSetup();
		driver = setup.openBrowser();
		
		//maximize the window
		driver.manage().window().maximize();
				
		//timeWait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		//importing input from "config.properties" file
		FileReader fl = new FileReader("./Input Files/config.properties");
		Properties data = new Properties();
		data.load(fl);
		
		//navigate to the URL
		driver.navigate().to(data.getProperty("URL"));
		
		//enter username
		WebElement UserName = driver.findElement(By.id("txtUsername"));
		UserName.sendKeys(data.getProperty("UserName"));
		
		//enter password
		WebElement PassWord = driver.findElement(By.id("txtPassword"));
		PassWord.sendKeys(data.getProperty("PassWord"));
		
		//click login
		WebElement logIn = driver.findElement(By.id("btnLogin"));
		logIn.click();
		
		//click on admin
		WebElement admin = driver.findElement(By.xpath("//*[@id='menu_admin_viewAdminModule']/b"));
		//WebElement admin = driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[1]/a/b"));
		admin.click();
		
		//click on qualification
		driver.findElement(By.id("menu_admin_Qualifications")).click();
		
		//click on skills
		driver.findElement(By.id("menu_admin_viewSkills")).click();
		
		//count the check boxes before adding an extra skill
		int countCheckboxes1;
		List<WebElement> beforeSkillAddition = driver.findElements(By.xpath("//input[@type = 'checkbox']"));
		countCheckboxes1 = beforeSkillAddition.size();
		
		//add new skills
		driver.findElement(By.id("btnAdd")).click();
		
		//set name of the skill
		WebElement skillName = driver.findElement(By.id("skill_name"));
		skillName.sendKeys(data.getProperty("Skill"));
		
		//click on save
		driver.findElement(By.id("btnSave")).click();
		
		//select the extra skill
		//if skill name is not "Testing Demo" then please change the name respective to the new skill name in the xpath("//a[contains(text(), 'name')]/parent::td/parent::tr/td/input").
		driver.findElement(By.xpath("//a[contains(text(), 'Testing Demo')]/parent::td/parent::tr/td/input")).click();

		//delete 
		driver.findElement(By.id("btnDel")).click();
		
		//count the checkboxes after deleting the extra skill
		int countCheckboxes2;
		List<WebElement> afterSkillDeletion = driver.findElements(By.xpath("//input[@type = 'checkbox']"));
		countCheckboxes2 = afterSkillDeletion.size();
		
		//Checking whether the skill is deleted or not
		if(countCheckboxes1 == countCheckboxes2) {
			System.out.println("Skill is Deleted Successfully.");
		}
		else {
			System.out.println("Skill is not Deleted!");
			System.out.println("Trying again.....");
			driver.findElement(By.xpath("//a[contains(text(), 'Testing Demo')]/parent::td/parent::tr/td/input")).click();
			driver.findElement(By.id("btnDel")).click();
		}
		
		//click on account
		driver.findElement(By.id("welcome")).click();
	
		//logOut
		WebDriverWait wait = new WebDriverWait(driver,10);
	  	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Logout')]"))).click();
	  	
	  	//close the browser
	  	driver.quit();
		

	}

}
