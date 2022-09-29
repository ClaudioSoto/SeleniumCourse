package SeleniumFrameworkDesign.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import SeleniumFrameworkDesign.AbstractComponents.AbstractComponent;

public class CartPageObject extends AbstractComponent{

	public WebDriver driver;
	List <WebElement> cartProducts;
	WebElement cartTargetProduct;
	
	//locators
	By cartProductsList = By.cssSelector("div.infoWrap");
	By cartProductNames = By.cssSelector("h3");
	By checkOutButton = By.xpath("//li[@class='totalRow']//button");
	
	public CartPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public List<WebElement> getCartProducts() {
		cartProducts = driver.findElements(cartProductsList);
		return cartProducts;
	}
	
	public WebElement getTargetCartProduct(String targProd) {
		cartTargetProduct = getCartProducts().stream().filter(product-> product.findElement(cartProductNames).getText().contains(targProd)).findFirst().orElse(null);
		return cartTargetProduct;
	}
	
	public void goToCheckout() {
		driver.findElement(checkOutButton).click();
	}

}
