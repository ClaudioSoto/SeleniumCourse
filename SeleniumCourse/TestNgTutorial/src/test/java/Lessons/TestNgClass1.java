package Lessons;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgClass1 {

	@Test(groups= {"smoke"}, timeOut= 4000)
	public void test1() {
		System.out.println("Hello I am the first test!");
	}

	@Test
	public void test2() {
		System.out.println("Hello I am the second test!");
	}

	//this method will be excluded in the execution via testng.xml
	@Test
	public void test3() {
		System.out.println("This test is excluded!");
	}

	//this method will be included in the execution via testng.xml
	//this will run as a part of smoke selected test cases and it depends on the execution of test1
	@Test (groups= {"smoke"}, dependsOnMethods = {"test1"})
	public void test4() {
		System.out.println("This test is an included!");
	}

	//this method will be excluded in the execution via testng.xml by regex
	@Test
	public void test5() {
		System.out.println("This test is excluded by regex!");
	}

	//this method will be excluded in the execution via testng.xml by regex
	@Test
	public void test51() {
		System.out.println("This test is excluded by regex!");
	}

	//this method will be excluded before any other
	@BeforeTest
	public void test6() {
		System.out.println("This test is will be executed before others");
	}

	//this method will be excluded after  any other
	@AfterTest
	public void test7() {
		System.out.println("This test is will be executed after others");
	}

	//this method will be excluded before suite
	@BeforeSuite
	public void test8() {
		System.out.println("This test is will be executed before the suite starts");
	}

	//this method will be excluded after suite
	@AfterSuite
	public void test9() {
		System.out.println("This test is will be executed after the suite ends");
	}

	//this method will be excluded before every method
	@BeforeMethod
	public void test10() {
		System.out.println("Start a test");
	}

	//this method will be excluded after every emethod
	@AfterMethod
	public void test11() {
		System.out.println("End a test" + "\n");
	}
	
	@BeforeClass
	public void test12() {
		System.out.println("This method will execute before class!");
	}
	
	@AfterClass
	public void test13() {
		System.out.println("This method will execute after class!");
	}
}
