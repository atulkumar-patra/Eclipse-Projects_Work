package com.selenium.testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Features/epicModule.feature"
		,glue={"com.selenium.stepdefinition"}
		,monochrome = true
		,tags="@SmokeTest"
		,plugin = {"html:target/reports" , "json:target/cucumber.json", "junit:target/cucumber.xml" }
		)


public class TestRunner {

}
