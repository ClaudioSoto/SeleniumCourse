package WebElementsAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class VerifyIfEnabled {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//set webdriver object
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Usuario\\Desktop\\Automation\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		//open website
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		//get value of the calendar and verify if is enabled when on way
		String attributerValue = driver.findElement(By.id("Div1")).getAttribute("style");
		Assert.assertFalse(verifyIfEnabled(attributerValue));

		//change thje value to round trip
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();

		//get value of the calendar and verify if is enabled when on way
		attributerValue = driver.findElement(By.id("Div1")).getAttribute("style");
		Assert.assertTrue(verifyIfEnabled(attributerValue));
		
		//close browser
		driver.quit();
	}

	public static boolean verifyIfEnabled(String statusOfTheElement) {

		if(statusOfTheElement.contains("1")) {
			System.out.println("Is enabled!");
			return true;
		}else{
			System.out.println("Is disbled!");
			return false;
		}
	}

}
