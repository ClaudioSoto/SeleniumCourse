package LatestFeaturesSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocators {
	
	public static WebElement nameSection;
	public static WebElement checkBoxMsg;
	public static WebElement passwordLabel;
	public static WebElement studentRadioButton;
	
	public static void main(String[] args) {

		//set webdriver object
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//open website
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		
		//get the name of the section on label tagname
		nameSection = driver.findElement(By.xpath("(//input[@name='name'])[1]"));
		String fieldName = driver.findElement(with(By.tagName("label")).above(nameSection)).getText();
		System.out.println("The label text is:" + fieldName);
		
		//click check box to the left of a text
		checkBoxMsg = driver.findElement(By.cssSelector("label[for='exampleCheck1']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(checkBoxMsg)).click();
		
		//we are going to enter the email usign the above feature with the password field
		passwordLabel = driver.findElement(By.cssSelector("label[for='exampleInputPassword1']"));
		driver.findElement(with(By.tagName("input")).above(passwordLabel)).sendKeys("claudio.soto.ayala@gmail.com");
		
		//what is the message to the right of the checkbox 
		studentRadioButton = driver.findElement(By.id("inlineRadio1"));
		String radioLabelText = driver.findElement(with(By.tagName("label")).toRightOf(studentRadioButton)).getText();
		System.out.println("The label text is:" + radioLabelText);
		
		driver.quit();
	}

}
