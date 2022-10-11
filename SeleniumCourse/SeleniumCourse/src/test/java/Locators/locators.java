package Locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


public class locators {

	public static void main(String[] args) throws InterruptedException {

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

		//locators using regex for: CSS
		driver.findElement(By.cssSelector("input[placeholder*='Em']")).sendKeys("claudio.soto.ayala@gmail.com");

		//locators using regex for: XPATH
		driver.findElement(By.xpath("//input[contains(@placeholder,'Phone')]")).sendKeys("4425426141");

		//locators using regex for: CSS
		driver.findElement(By.cssSelector("button[class*='reset']")).click();

		//get the password text
		String temporalPassword = driver.findElement(By.cssSelector("p[class*='infoMsg']")).getText().toString();

		//get only the password
		String result = new String();

		result = formatPassword(temporalPassword);
		
		System.out.println(result);

		//go back to login
		driver.findElement(By.cssSelector("button[class*='login']")).click();
		
		Thread.sleep(2000);
		
		//enter the new password
		driver.findElement(By.name("inputPassword")).clear();
		driver.findElement(By.name("inputPassword")).sendKeys(result);
		
		//click login button
		driver.findElement(By.cssSelector("button[class*='submit']")).click();
		
		//verify if logged successfully
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='login-container']/p")).isDisplayed());
		
		//log out regex
		driver.findElement(By.cssSelector("button[class*='logout']")).click();
		
		//log out using text
		//driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		
		//logout using text and regex for tagname
		//driver.findElement(By.xpath("//*[text()='Log Out']")).click();

		//Exit from browser
		driver.quit();

	}
	
	//to format and get the password
	public static String formatPassword(String temporalPassword) {
		
		boolean aux = false;
		String result = "";

		for(int i=0;i<temporalPassword.length();i++) {

			if(aux && temporalPassword.charAt(i) != '\'') {
				result += temporalPassword.charAt(i);
			}

			if(temporalPassword.charAt(i) == '\'' && aux) {
				break;
			}else if(temporalPassword.charAt(i) == '\'') {
				aux = true;	
			}
		}
		
		return result;
		
	}

}
