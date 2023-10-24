package com.pageclass.displaybookshelves;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.testng.Reporter;

import com.baseclass.displaybookshelves.baseClass;

public class giftcardPage1 extends baseClass{

	public static Properties prop;
	public static String rName;
	public static String rMail;
	public static String yName;
	public static String yMail;
	public static String yNumber;

	public giftcardPage1(WebDriver driver) {
		baseClass.driver = driver;
		
		try {
			prop = baseClass.setProperties();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 rName = prop.getProperty("recipients_name");
		 rMail = prop.getProperty("recipients_mail");
		 yName = prop.getProperty("your_name");
		 yMail = prop.getProperty("your_mail");
		 yNumber = prop.getProperty("your_number");

	}
	
	//Scroll to top
	public void scrollingUp() {
		System.out.println("***************************************************************************************");
		System.out.println("Displaying Gift Card Error Message:    ");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-300)");
	}
	
	//Click on GiftCard
	public void giftCard() {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		baseClass.getElement("giftCard_Xpath").click();
	}
	
	//Choose category
	public void chooseGiftCard() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		baseClass.getElement("birthdayAniversary_Xpath").click();
	}
	
	//Enter Amount
	public void giftCardAmount() throws InterruptedException {
		Thread.sleep(2000);
		WebElement amount1 = baseClass.getElement("amount_Xpath");
		amount1.click();
	}
	
	//Click on Next
	public void nextOn() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		baseClass.getElement("next_Xpath").click();
	}
	
	
	//Entering Recipient Name
	public void enterRecipientName() throws InterruptedException {
		baseClass.getElement("recipentName_Xpath").sendKeys(rName);
		driver.manage().timeouts().implicitlyWait(10000,TimeUnit.SECONDS);	
	}
	
	//Entering Recipient Email
	public void enterSenderEmail() throws InterruptedException {
		baseClass.getElement("senderMail_Xpath").sendKeys(yMail);
		driver.manage().timeouts().implicitlyWait(10000,TimeUnit.SECONDS);	
	}
	
	 //Entering Sender Name
	public void enterSenderName() throws InterruptedException {
		baseClass.getElement("senderName_Xpath").sendKeys(yName);
		driver.manage().timeouts().implicitlyWait(10000,TimeUnit.SECONDS);	
	}
	
	//Entering Sender Number 
	public void enterSenderNo() throws InterruptedException {
		baseClass.getElement("senderPhNo_Xpath").sendKeys(yNumber);
		driver.manage().timeouts().implicitlyWait(10000,TimeUnit.SECONDS);	
	}
	
	//Displaying error message while entering invalid Sender Email
    public void displayErrorMessage() throws InterruptedException, IOException {
    	WebElement mail = baseClass.getElement("mailEnter1_Id");
    	mail.sendKeys(rMail);
    	driver.manage().timeouts().implicitlyWait(10000,TimeUnit.SECONDS);	
		String f= mail.getAttribute("validationMessage");
		baseClass.getElement("submit_Xpath").click();
		System.out.println("\n"+"The error message appeared for invalid e-mail: " +f +"\n");
	}
}
