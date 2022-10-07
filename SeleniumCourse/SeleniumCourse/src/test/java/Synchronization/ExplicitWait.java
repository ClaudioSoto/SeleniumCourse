package Synchronization;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ExplicitWait {
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//set webdriver object
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		//Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		//open website
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		
		//target products
		List<String> targetProducts = new ArrayList<String>();
		targetProducts.add("Cucumber");
		targetProducts.add("Pears");
		
		//add products to cart
		for(int i=0; i<targetProducts.size();i++) {
			//add the target product to cart
			addProductToCart(driver, targetProducts.get(i).toString());
		}

		//open the cart
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();

		//verify if products are in cart
		for(int i=0; i<targetProducts.size();i++) {
			//add the target product to cart
			verifyAddedProducts(driver, targetProducts);
		}
		
		
		//proceed with the selected cart
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='action-block'] //button[contains(text(),'PROCEED TO CHECKOUT')]")));
		driver.findElement(By.xpath("//div[@class='action-block'] //button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		
		//enter promotion code and apply it
		addAndApplyPromCode(driver);

		//Verify if the code was waplied
		verifyPromCodeAplied(driver,wait);
		
		//close browser
		//driver.quit();
		
		
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

				//exit loop
				break;

			}
		}
	}

	public static void verifyAddedProducts(WebDriver driver, List<String> targetProducts) {

		//declare list of elements in the cart
		List <WebElement> cartProducts = driver.findElements(By.xpath("//div[@class='cart-preview active'] //div[@class='product-info'] //p[@class='product-name']"));
		int len = cartProducts.size();

		//current product
		String current= "";

		//clean the name
		for(int i=0; i<len; i++) {
			current = cartProducts.get(i).getText().toString();
			Assert.assertTrue(current.contains(targetProducts.get(i)),"El producto no fue agregado correctamente");
		}

	}
	
	public static void addAndApplyPromCode(WebDriver driver) {
		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//div[@class='promoWrapper']/button")).click();
	}
	
	public static void verifyPromCodeAplied(WebDriver driver, WebDriverWait wait) {
		//esperamos especificamente por este elemento hasta que sea visible
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")));
		Assert.assertTrue(driver.findElement(By.xpath("//span[@class='promoInfo']")).isDisplayed(),"El codigo promocional no fue aplicado correctamente");
	}

}
