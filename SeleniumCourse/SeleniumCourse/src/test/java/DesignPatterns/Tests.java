package DesignPatterns;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Tests {

	public static WebDriver driver;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		initialize();
		SubmitRegisterFormTest();
	}

	public static void SubmitRegisterFormTest() {

		HomePageObject homeObj = new HomePageObject(driver);

		//fill the form
		homeObj.setName("Luis Claudio Soto Ayala");
		homeObj.setEmail("claudio.soto.ayala@gmail.com");
		homeObj.setPassword("LuisClaudioSoto");
		homeObj.clickIceCreamCheckBox();
		homeObj.selectGender("Female");
		homeObj.clickEmploymentStatusStudent();
		homeObj.inputDate("21", "08", "1996");
		homeObj.submitForm();
		Assert.assertEquals(homeObj.getSubmitAlertText(), "Success!");
		driver.quit();
	}

	public static void initialize() {
		//set webdriver object
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\WebDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//open website - primal
		driver.get("https://rahulshettyacademy.com/angularpractice/");
	}

}
