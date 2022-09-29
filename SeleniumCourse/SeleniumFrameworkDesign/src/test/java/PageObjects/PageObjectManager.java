package PageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	public LoginPageObject loginObj;
	public ProductCatalogPageObject productCatalogObj;
	public CartPageObject cartObj;
	public CheckoutPageObject checkoutObj;
	public OrderPageObject orderObj;
	
	public PageObjectManager(WebDriver driver) {
		this.loginObj = new LoginPageObject(driver);
		this.productCatalogObj = new ProductCatalogPageObject(driver);
		this.cartObj = new CartPageObject(driver);
		this.checkoutObj = new CheckoutPageObject(driver);
		this.orderObj = new OrderPageObject(driver);
	}

}
