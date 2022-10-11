package Locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdvancedLocators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//set webdriver object
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		//open website
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		//get the login button name using following-sibling technique
		String buttonName = driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText();

		//print the button text
		System.out.println("The text in the selected button is: " + buttonName);

		//get the link text using the parent technique starting from the button
		String linkText = driver.findElement(By.xpath("//header/div/button[1]/parent::div/parent::header/a[2]")).getText();

		//print the link text starting from the button
		System.out.println("The text in the link is: " + linkText);

		//close driver
		driver.quit();

	}

}
