package Exercises;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ExplicitWaitExercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//set webdriver object
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Usuario\\Desktop\\Automation\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		//Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));

		//open website
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");

		//fill login form
		fillLoginForm(driver, wait);

		//select all products
		selectAllProducts(driver, wait);

		//open the cart
		openCart(driver, wait);
		
		//verify purchase
		verifyTransaction(driver, wait);
		
		//close browser
		driver.close();
	}

	public static void fillLoginForm(WebDriver driver, WebDriverWait wait) {
		//enter name
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");

		//enter password
		driver.findElement(By.id("password")).sendKeys("learning");

		//select user
		driver.findElement(By.xpath("//input[@value='user']")).click();

		//manage alert
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();

		//select consultant
		WebElement staticDropdown = driver.findElement(By.xpath("//select[@data-style='btn-info']"));
		Select dropDown = new Select(staticDropdown);
		dropDown.selectByValue("consult");

		//accept terms
		driver.findElement(By.id("terms")).click();

		//submit login form
		driver.findElement(By.id("signInBtn")).click();
	}

	public static void selectAllProducts(WebDriver driver, WebDriverWait wait) {

		//wait until page is loaded
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-lg-3']/h1")));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

		//wait until buttons are visible
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='card-footer']/button")));

		//click all the buttons for adding to cart
		List <WebElement> buttons = driver.findElements(By.xpath("//div[@class='card-footer']/button"));

		//click all the buttons
		for(int i=0; i<buttons.size(); i++) {
			buttons.get(i).click();
		}

	}

	public static void openCart(WebDriver driver, WebDriverWait wait) {
		//to perform Scroll on application using Selenium
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)", "");

		//wait until cart button is visible
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.nav-link.btn.btn-primary")));

		//clic cart icon
		driver.findElement(By.cssSelector("a.nav-link.btn.btn-primary")).click();
	}
	
	public static void verifyTransaction(WebDriver driver, WebDriverWait wait) {
		//wait until cart button is visible
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.btn.btn-success")));
		
		//assert if button to complete purchase is there
		Assert.assertTrue(driver.findElement(By.cssSelector("button.btn.btn-success")).isDisplayed());
	}

}
