package Exercises;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddItemsToCart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//set webdriver object
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();

		//open website
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");

		//add the target product to cart
		addProductToCart(driver, "Cucumber");
		addProductToCart(driver, "Pears");
		
		//close browser
		driver.quit();
	}

	public static void addProductToCart(WebDriver driver,String targetProduct) throws InterruptedException {
		
		//select all the products
		int productsLen = driver.findElements(By.xpath("//h4[@class='product-name']")).size();
		
		//iterate all the products and print the names
		for(int i=0; i<productsLen; i++) {

			//to find the target element in the list and click it
			if(driver.findElements(By.xpath("//h4[@class='product-name']")).get(i).getText().contains(targetProduct)) {
				System.out.println("The target element index is:" + i);
				
				//this line produces problems since the text can change when clicked, and the ids are not the same
				//driver.findElements(By.xpath("//button[contains(text(),'ADD TO CART')]")).get(i).click();
				
				//here we click the add button using the parent child approach for the button
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
			}
		}
	}

}
