package SeleniumFrameworkDesign.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import SeleniumFrameworkDesign.AbstractComponents.AbstractComponent;

public class ProductCatalogPageObject extends AbstractComponent{
	
	public WebDriver driver;
	By productNameSection = By.cssSelector("b");
	By addCartButton  = By.cssSelector(".card-body button:last-of-type");
	By productsCatalog = By.xpath("//div[@class='card-body']");
	By addToCartToast = By.id("toast-container");
	By disappearToastAnimation = By.cssSelector(".ng-animating");
	By cartIcon = By.xpath("//button[@routerlink='/dashboard/cart']");
	public WebElement targetProduct;
	public List <WebElement> products;
	
	public ProductCatalogPageObject(WebDriver driver) {
		//to send the driver to  the parent class
		super(driver);
		this.driver = driver;
	}
	
	public List<WebElement> getProducts() {
		products = driver.findElements(productsCatalog);
		return products;
	}
	
	public WebElement getTargetProduct(String targProd) {
		targetProduct = getProducts().stream().filter(product-> product.findElement(productNameSection).getText().contains(targProd)).findFirst().orElse(null);
		return targetProduct;
	}
	
	public void addTargetProductToCart(String targProd) {
		getTargetProduct(targProd).findElement(addCartButton).click();
	}
	
	public CartPageObject goToCart() {
		waitForElementToAppear(addToCartToast);
		waitForElementToDisappear(disappearToastAnimation);
		driver.findElement(cartIcon).click();
		
		CartPageObject cartObj = new CartPageObject(driver);
		return cartObj;
	}
	

}
