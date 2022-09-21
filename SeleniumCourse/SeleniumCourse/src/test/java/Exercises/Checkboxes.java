package Exercises;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Checkboxes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//set webdriver object
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Usuario\\Desktop\\Automation\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		//open website
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Verify if the first check box is un-checked
		Assert.assertFalse(driver.findElement(By.name("checkBoxOption1")).isSelected());
		
		//select the first checkbox again
		driver.findElement(By.name("checkBoxOption1")).click();
		
		//Verify if the first check box is checked
		Assert.assertTrue(driver.findElement(By.name("checkBoxOption1")).isSelected());
		
		//get all the checkboxes in the website
		int numberCbxes = driver.findElements(By.xpath("//input[@type='checkbox']")).size();
		
		//print number of checboxes
		System.out.println("The number of checkboxes is: " + numberCbxes);
		
		//close browser
		driver.quit();
		
	}

}
