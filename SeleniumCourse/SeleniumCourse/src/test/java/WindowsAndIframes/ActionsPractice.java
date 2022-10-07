package WindowsAndIframes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsPractice {
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//set webdriver object
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();

		//open website
		driver.get("https://www.amazon.com.mx/ref=nav_logo");
		
		//Declare actions
		Actions actions = new Actions(driver);
		
		//define web element
		WebElement moveToMenu = driver.findElement(By.id("nav-link-accountList"));
		WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox"));
		
		//move to the search bar, click it, and send keys in capital letters
		actions.moveToElement(searchBar).click().keyDown(Keys.SHIFT).sendKeys("Play Station").doubleClick().build().perform();
		
		//mouse over
		actions.moveToElement(moveToMenu).build().perform();

	}

}
