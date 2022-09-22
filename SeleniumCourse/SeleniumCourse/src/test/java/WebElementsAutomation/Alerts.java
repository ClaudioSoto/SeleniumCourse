package WebElementsAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Alerts {

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
		
		//name to display in the alert
		String name= "Luis Claudio Soto Ayala";
		
		//enter the name
		driver.findElement(By.id("name")).sendKeys("Luis Claudio Soto Ayala");
		
		//click to trigger the alert
		driver.findElement(By.id("alertbtn")).click();
		
		//verify if the name is displayed in the alert
		Assert.assertTrue(driver.switchTo().alert().getText().contains(name));
		
		//accept the notification
		driver.switchTo().alert().accept();
		
		//now trigger the confirmation alert
		driver.findElement(By.id("confirmbtn")).click();
		
		//confirm or cancel the alert
		//driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();
		
		driver.quit();

	}

}
