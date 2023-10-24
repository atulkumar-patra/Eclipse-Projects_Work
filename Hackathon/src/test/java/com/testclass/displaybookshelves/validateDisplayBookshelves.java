package com.testclass.displaybookshelves;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.baseclass.displaybookshelves.baseClass;
import com.pageclass.displaybookshelves.bookshelvesPage1;
import com.pageclass.displaybookshelves.collectionPage1;
import com.pageclass.displaybookshelves.giftcardPage1;
import com.pageclass.displaybookshelves.homePage;

public class validateDisplayBookshelves extends baseClass {

	homePage homepage = new homePage(driver);
	bookshelvesPage1 bookshelvespage; // = new bookshelvesPage1(driver);
	collectionPage1 collectionpage = new collectionPage1(driver);
	giftcardPage1 gift = new giftcardPage1(driver);
	
	
	//Invoke browser
	@BeforeClass
	public void initialiseSetup() throws IOException {
		Properties prop = baseClass.setProperties();
		String browser = prop.getProperty("browser");
		invokeBrowser(browser);
		driver.get(prop.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(6000, TimeUnit.SECONDS);
		
	}
	
	//Home Page
	@Test(priority=1)
	public void homePage() throws Exception{
		
		logger = report.createTest("Verify HomePage");
		homepage.closePopup();
		homepage.searchBox(prop.getProperty("searchKeyword"));
		logger.log(Status.INFO, "Entering keyword in textbox");
		bookshelvespage = homepage.gotoBookshelves();
		logger.log(Status.PASS, "Displaying book shelves");
		
	}
	
	//BookShelves Page
	
	@Test(priority=2)
	public void bookshelves() throws InterruptedException {
		logger = report.createTest("Display bookshelves name and price");
		bookshelvespage.setCategory();
		logger.log(Status.INFO, "Selecting category as Bookshelves");
		bookshelvespage.selectPrice();
		logger.log(Status.INFO, "Selecting price range");
		bookshelvespage.setStorageType();
		logger.log(Status.PASS, "Set storage type as open");
		bookshelvespage.clickOutOfStock();
		logger.log(Status.PASS, "Checking out of stock items");
		bookshelvespage.getBookDetails();
		logger.log(Status.PASS, "Getting item details");
		takeScreenShot("bookshelvesPageSS");
		System.out.println("Screenshot taken");
	}
	
	//Collection Page

	@Test(priority=3)
	public void collectionMenu() throws InterruptedException {
		logger = report.createTest("Display sub-menu items under New Arrivals");
		collectionpage.scrollingUp();
		collectionpage.collection();
		logger.log(Status.INFO, "Viewing Collection menu");
		collectionpage.subMenuList();
		logger.log(Status.PASS, "Getting sub-menu items and Display it");
		takeScreenShot("subMenuPageSS");
		System.out.println("Screenshot taken");
			
	}
	
	
	//GiftCard Page

	@Test(priority=4)
	public void validatingGiftCard() throws InterruptedException, IOException {
		logger = report.createTest("Display error message in Gift card page");
		gift.scrollingUp();
		gift.giftCard();
		logger.log(Status.INFO, "Opening Gift card page");
		logger.log(Status.PASS, "Gift card page is opened");
		gift.chooseGiftCard();
		logger.log(Status.INFO, "Selecting giftcard type");
		gift.giftCardAmount();
		logger.log(Status.PASS, "Selecting giftcard amount");
		gift.nextOn();
		gift.enterRecipientName();
		logger.log(Status.PASS, "Entered Recipient name");
		gift.enterSenderEmail();
		logger.log(Status.PASS, "Entered Sender's email");
		gift.enterSenderName();
		logger.log(Status.PASS, "Entered Sender's Name");
		gift.enterSenderNo();
		logger.log(Status.PASS, "Entered Sender's mobile no.");
		gift.displayErrorMessage();
		logger.log(Status.PASS, "Displaying error message");
		takeScreenShot("giftcardPageSS");
		System.out.println("Screenshot taken");
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
