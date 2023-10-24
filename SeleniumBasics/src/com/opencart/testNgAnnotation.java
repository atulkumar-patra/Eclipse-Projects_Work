package com.opencart;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testNgAnnotation {

	public static void main(String[] args) {
		System.out.println("Main Method");


	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before class");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");

	}
	
	@Test
	public void firstTest() {
		System.out.println("Test 1");

	}
	
	@Test
	public void secTest() {
		System.out.println("Test 2");

	}
	
	@Test
	public void thirdTest() {
		System.out.println("Test 3");

	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");

	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("After class");

	}
	

}
