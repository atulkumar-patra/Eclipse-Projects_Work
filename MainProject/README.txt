1.Module Name: Epic
------------------------------------------------------------

2.Files & Folders:
->ScreenShots: It contains web page & console output screenshot.

->Input File: It contains properties & excel file.

->test-output: It contains Extent Html reports.

->drivers: It contains browser drivers.

->Features: It contains feature file for Cucumber.

-----------------------------------------------------------

3.Project Structure:

->baseClass.java: It includes methods for invoking browser,
 finding web elements, capturing screenshot.

->homePage.java: It includes methods to work on home page
 web elements.

->projectPage.java: It includes methods to work on project
 page web elements.

->epicModulePage: It includes methods to create epic project
 using valid & invalid details.

->validateEpicModule: It is a test class containing all the
 test methods to run on TestNG.

->extentReportManager.java: It includes method to generate
 html reports.

->stepDefinition.java: It contains methods to run on Cucumber.

->TestRunner.java: It can run the project using cucumber.
-----------------------------------------------------------

