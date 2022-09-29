package Automation.SeleniumFrameworkDesign;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandaloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client/");
		
		//target product
		String targProd = "IPHONE";

		
		//enter user and password
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("claudio.soto.ayala@gmail.com");
		driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Legostarwars10.");
		
		//login
		driver.findElement(By.xpath("//input[@id='login']")).click();
		
		//get names of all the products in the website
		List <WebElement> products = driver.findElements(By.xpath("//div[@class='card-body']"));
		
		//ways to select iphone product
		
		//WAY 1: SELECT IPHONE USING FOR
		/*
		for(int i=0; i<products.size(); i++) {
			System.out.println(products.get(i).getText());
			
			if(products.get(i).getText().contains(targProd)) {
				driver.findElements(By.xpath("//div[@class='card']//button[contains(text(),'Add To Cart')]")).get(i).click();
				break;
			}
		}
		*/
		
		//WAY 2: SELECT IPHONE USING FILTER AND STREAM
		WebElement targetProduct = products.stream().filter(product-> product.findElement(By.cssSelector("b")).getText().contains(targProd)).findFirst().orElse(null);
		System.out.println("Product on the list:" + targetProduct.getText());
		targetProduct.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		//Verify if the product was added to the cart checking the toast
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		
		//Wait until toast dissapear
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		//go to the cart
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		
		//verify if the product is in the cart
		List <WebElement> cartProducts = driver.findElements(By.cssSelector("div.infoWrap"));
		
		WebElement cartTargetProduct = cartProducts.stream().filter(product-> product.findElement(By.cssSelector("h3")).getText().contains(targProd)).findFirst().orElse(null);
		System.out.println("Product on the cart list:" + cartTargetProduct.findElement(By.cssSelector("div[class='cartSection'] h3")).getText());
		
		//Assert that the product exists
		Assert.assertNotNull(cartTargetProduct, "The product was not found!");
		
		//go to the checkout
		driver.findElement(By.xpath("//li[@class='totalRow']//button")).click();
		
		//complete the order by filling the payment data, we use actions for several steps
		Actions act = new Actions(driver);
		act.click(driver.findElement(By.xpath("//input[@placeholder='Select Country']"))).sendKeys("Mexico").build().perform();
		
		//wait until options are available
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".ta-results"))));
		
		//click the option
		driver.findElement(By.cssSelector(".ta-results")).click();
		
		//place the order
		driver.findElement(By.cssSelector(".actions a")).click();
		
		//get the confirmation message
		String confirmationMsg = driver.findElement(By.xpath("//h1[@class='hero-primary']")).getText().trim();
		System.out.println("Message: " + confirmationMsg);
		
		//Verify if the message is correct
		Assert.assertTrue(confirmationMsg.equalsIgnoreCase("Thankyou for the order."));
		
		//close browser
		driver.quit();
	
	}

}
