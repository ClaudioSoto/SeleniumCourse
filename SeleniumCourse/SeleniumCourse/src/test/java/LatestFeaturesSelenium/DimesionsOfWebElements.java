package LatestFeaturesSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DimesionsOfWebElements {

	//get height and width of website image
	public static WebElement nameField;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//set webdriver object
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//open website - primal
		driver.get("https://rahulshettyacademy.com/angularpractice/");

		//initialize the image website
		nameField = driver.findElement(By.xpath("//input[@name='name']"));
		
		int h = nameField.getRect().getHeight();
		int w = nameField.getRect().getWidth();
		
		System.out.println("The dimesions are:" + " H:" + h + " W:" + w);
		
		driver.quit();

	}

}
