Deleting Skills Set
--------------------

Folders:
------
1.drivers --> (it contains all the Web Drivers)
------Due to restriction of the file size in TEKSTAC Platform I have removed gecko driver and msEdge driver------
	-chromedriver.exe
	-geckodriver.exe
	-msedgedriver.exe

2.Input Files --> (Properties file for input)
	-config.properties

3.Output Files --> (Screenshots of the console)
	-ConsoleSS_Chrome Browser.jpg
	-ConsoleSS_default Browser.jpg
	-ConsoleSS_Edge Browser.jpg
	-ConsoleSS_Firefox Browser.jpg

4.src > com > deletingskillsset --> (Script files)
	-DriverSetup.java
	-mainClass.java



Note:
-----
1.If the skill name is ALREADY EXIST then please delete that skill first and then Execute the 'mainClass.java' file again.
2.If skill name is not "Testing Demo" then please change the name respective to the new skill 'name' in the xpath that is in "mainClass.java".
  [driver.findElement(By.xpath("//a[contains(text(), 'name')]/parent::td/parent::tr/td/input")).click();]