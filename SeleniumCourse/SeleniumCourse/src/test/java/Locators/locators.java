package Locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class locators {

	public static void main(String[] args) {

		//set webdriver object
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//open website
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		//locators usage:ID
		driver.findElement(By.id("inputUsername")).sendKeys("claudio");
		
		//locators usage:NAME
		driver.findElement(By.name("inputPassword")).sendKeys("claudio");
		
		//locators usage:CLASS NAME (have spaces)
		//driver.findElement(By.className("submit signInBtn")).click();
		
		//locators usage:CSS SELECTOR
		driver.findElement(By.cssSelector("button.ghost"));
		driver.findElement(By.cssSelector("input#chkboxOne"));
		driver.findElement(By.cssSelector("button[class='ghost']"));

		//locators usage:LINKS
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		//locators usage:XPATH
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("claudio");
		
		//Exit from browser
		driver.quit();
		
	}

}
