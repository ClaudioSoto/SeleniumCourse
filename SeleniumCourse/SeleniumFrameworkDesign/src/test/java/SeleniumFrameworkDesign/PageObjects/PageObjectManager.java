package SeleniumFrameworkDesign.PageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import SeleniumFrameworkDesign.TestComponents.BaseTest;

public class PageObjectManager {
	
	public BaseTest baseObj;
	public LoginPageObject loginObj;
	public ProductCatalogPageObject productCatalogObj;
	public CartPageObject cartObj;
	public CheckoutPageObject checkoutObj;
	public OrderPageObject orderObj;
	public WebDriver driver;
	
	public PageObjectManager() throws IOException {
		this.baseObj = new BaseTest();
		driver = this.baseObj.initializeDriver();
		
		this.loginObj = new LoginPageObject(driver);
		this.productCatalogObj = new ProductCatalogPageObject(driver);
		this.cartObj = new CartPageObject(driver);
		this.checkoutObj = new CheckoutPageObject(driver);
		this.orderObj = new OrderPageObject(driver);
	}

}
