package Exercises;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SubmitForm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//set webdriver object
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Usuario\\Desktop\\Automation\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();

		//open website
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		//enter name
		driver.findElement(By.name("name")).sendKeys("Luis Claudio Soto Ayala");
		
		//enter email
		driver.findElement(By.name("email")).sendKeys("claudio.soto.ayala@gmail.com");
		
		//enter password
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("claudio.soto.ayala@gmail.com");
		
		//click the check box
		driver.findElement(By.id("exampleCheck1")).click();
		
		//select gender
		WebElement dropDown = driver.findElement(By.id("exampleFormControlSelect1"));
		Select staticDropdown = new Select(dropDown);
		staticDropdown.selectByVisibleText("Female");
		
	
		//select person status
		driver.findElement(By.id("inlineRadio2")).click();
		
		//select birthday
		driver.findElement(By.name("bday")).click();
		driver.findElement(By.name("bday")).sendKeys("08");
		driver.findElement(By.name("bday")).sendKeys("21");
		driver.findElement(By.name("bday")).sendKeys("1996");
		
		//Submit the form
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		
		//Result
		String result = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible'] //strong")).getText();
		
		//Assert that form is submitted
		Assert.assertTrue(result.contains("Success"));
		
		//close browser
		driver.quit();
		
	}

}
