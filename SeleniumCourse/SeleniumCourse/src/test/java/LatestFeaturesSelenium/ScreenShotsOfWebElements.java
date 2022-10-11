package LatestFeaturesSelenium;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShotsOfWebElements {
	
	public static WebElement websiteImage;
	
	public static void main(String[] args) {

		//set webdriver object
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//open website - primal
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		//initialize the image website
		websiteImage = driver.findElement(By.className(".jumbotron"));
		
		//generate the screenshot
		File file = websiteImage.getScreenshotAs(OutputType.FILE);
		
		//necesita libreria file utils o el jar
		//FileUtils.copyFile(file, new File("image.png"));

		

		driver.quit();
	}

}
