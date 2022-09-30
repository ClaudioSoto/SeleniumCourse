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
		baseObj = new BaseTest();
		loginObj = baseObj.launchApp();
		productCatalogObj = new ProductCatalogPageObject(loginObj.driver);
		cartObj = new CartPageObject(loginObj.driver);
		checkoutObj = new CheckoutPageObject(loginObj.driver);
		orderObj = new OrderPageObject(loginObj.driver);
	}

}
