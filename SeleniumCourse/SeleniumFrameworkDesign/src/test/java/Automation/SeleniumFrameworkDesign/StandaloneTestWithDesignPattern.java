package Automation.SeleniumFrameworkDesign;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import PageObjects.PageObjectManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandaloneTestWithDesignPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client/");
		
		//Test data
		String targProd = "IPHONE";
		String country = "Mexico";
		
		//declare page object manager
		PageObjectManager manager = new PageObjectManager(driver);
		
		/* LOGIN PAGE*/
		//enter login data, and submit
		manager.loginObj.loginApplication("claudio.soto.ayala@gmail.com", "Legostarwars10.");
		
		/* CATALOG PAGE*/
		//add the target product to cart
		manager.productCatalogObj.addTargetProductToCart(targProd);
		//go to the cart
		manager.productCatalogObj.goToCart();
		
		/* CART PAGE*/
		//verify if the target product is on cart
		Assert.assertNotNull(manager.cartObj.getTargetCartProduct(targProd), "The product was not found!");
		//go to the checkout page
		manager.cartObj.goToCheckout();
		
		/* CHECKOUT PAGE*/
		//enter and select the target country  for shipping
		manager.checkoutObj.selectCountry(country);
		//place the order
		manager.checkoutObj.placeTheOrder();
		
		/* ORDER PAGE*/
		//verify if place order message is correct
		Assert.assertTrue(manager.orderObj.getConfirmationMessage().equalsIgnoreCase("Thankyou for the order."));
		//go back to home
		manager.orderObj.returnHome();
		
		//close brwoser
		driver.quit();

	}

}
