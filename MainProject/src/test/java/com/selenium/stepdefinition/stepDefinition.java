package com.selenium.stepdefinition;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.selenium.baseclass.baseClass;
import com.selenium.pageclass.epicModulePage;
import com.selenium.pageclass.homePage;
import com.selenium.pageclass.projectPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class stepDefinition extends baseClass{
	
	homePage homepage = new homePage(driver);
	static projectPage projectpage;
	static epicModulePage epicmodulepage;


    @Given("^the user is on signin page$")
    public void the_user_is_on_signin_page() throws Throwable {
        System.out.println("the user is on signin page ");
		Properties prop = baseClass.setProperties();
		String browser = prop.getProperty("browser");
		invokeBrowser(browser);
		driver.get(prop.getProperty("URL"));
		
		Thread.sleep(60000);
		
    }

    @Then("^the user is on homePage$")
    public void the_user_is_on_homepage() throws Throwable {
        System.out.println("the user is on homePage ");
    }

    @Then("^the user is on projectPage$")
    public void the_user_is_on_projectpage() throws Throwable {
        System.out.println("the user is on projectPage ");
        projectpage = homepage.gotoProjectPage();
    }

    @Then("^the user is on epicModulePage$")
    public void the_user_is_on_epicmodulepage() throws Throwable {
        System.out.println("the user is on epicModulePage ");
        Thread.sleep(3000);
        epicmodulepage = projectpage.gotoEpicModulePage();
        takeScreenShot("epicspageSS");
    }

    @Then("^the Epic id is generated$")
    public void the_epic_id_is_generated() throws Throwable {
    	System.out.println("************************************************************************************");
        System.out.println("the Epic id is generated ");
        epicmodulepage.fetchId();
        takeScreenShot("epicidSS");
    }

    @Then("^user clicks on Save button$")
    public void user_clicks_on_save_button() throws Throwable {
        System.out.println("user clicks on Save button ");
        epicmodulepage.save();
    }

    @Then("^the user handles the Alerts$")
    public void the_user_handles_the_alerts() throws Throwable {
        System.out.println("the user handles the Alerts ");

		epicmodulepage.handleAlert();
		Thread.sleep(4000);
		driver.quit();
    }

    @And("^the user enters valid details and clicks on signin$")
    public void the_user_enters_valid_details_and_clicks_on_signin() throws Throwable {
        System.out.println("the user enters valid details and clicks on signin ");
    }

    @And("^the user hovers on menu$")
    public void the_user_hovers_on_menu() throws Throwable {
    	takeScreenShot("homepageSS");
        System.out.println("the user hovers on menu ");
        homepage.hoverOnMenu();
    }

    @And("^the user clicks on project$")
    public void the_user_clicks_on_project() throws Throwable {
        System.out.println("the user clicks on project ");
        homepage.clicksOnProject();
    }

    @And("^the user hovers on execute menu$")
    public void the_user_hovers_on_execute_menu() throws Throwable {
    	Thread.sleep(7000);
    	//driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
    	takeScreenShot("projectpageSS");
    	Thread.sleep(2000);
        System.out.println("the user hovers on execute menu ");
        projectpage.hoverOnExecuteMenu();
    }

    @And("^the user clicks on epics$")
    public void the_user_clicks_on_epics() throws Throwable {
        System.out.println("the user clicks on epics ");
        Thread.sleep(1000);
        projectpage.clicksOnEpics();
        //epicmodulepage = projectpage.gotoEpicModulePage();
    }

    @And("^the user clicks on add button$")
    public void the_user_clicks_on_add_button() throws Throwable {
        System.out.println("the user clicks on add button ");
		epicmodulepage.addEpic();
		epicmodulepage.detailsFrame();
    }

    @And("^the user enters Name (.+) ,Date (.+) ,Description (.+) ,Priority (.+) and Size (.+) in respective fields$")
    public void the_user_enters_name_date_description_priority_and_size_in_respective_fields(String name, String date, String desc, String priority, String size) throws Throwable {
        System.out.println("the user enters Name, Date, Description, Priority and Size in respective fields  ");
        epicmodulepage.validDetails(name, date, desc, priority, size);
    }

    @And("^the user clicks on Save button$")
    public void the_user_clicks_on_save_button() throws Throwable {
        System.out.println("the user clicks on Save button ");
        epicmodulepage.save();
    }

    @And("^user enters invalid details or leaves mandatory fields empty$")
    public void user_enters_invalid_details_or_leaves_mandatory_fields_empty() throws Throwable {
    	System.out.println("************************************************************************************");
        System.out.println("user enters invalid details or leaves mandatory fields empty ");
    }

    @And("^user clears the name field$")
    public void user_clears_the_name_field() throws Throwable {
        System.out.println("user clears the name field ");
        epicmodulepage.invalidName();
    }

    @And("^user clears the date field$")
    public void user_clears_the_date_field() throws Throwable {
        System.out.println("user clears the date field ");
		epicmodulepage.invalidDate();
		Thread.sleep(2000);
    }

}
