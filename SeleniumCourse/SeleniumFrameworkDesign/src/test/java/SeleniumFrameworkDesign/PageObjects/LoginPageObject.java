package SeleniumFrameworkDesign.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import SeleniumFrameworkDesign.AbstractComponents.AbstractComponent;

public class LoginPageObject extends AbstractComponent{
	
	public WebDriver driver;
	By userField = By.xpath("//input[@id='userEmail']");
	By passwordField  = By.xpath("//input[@id='userPassword']");
	By loginButton  = By.xpath("//input[@id='login']");
	By erroMessage = By.id("toast-container");
	By webSiteLogo = By.cssSelector("div.left.mt-1");
	
	public LoginPageObject(WebDriver driver) {
		//to send the driver to  the parent class
		super(driver);
		this.driver = driver;
	}
	
	public ProductCatalogPageObject loginApplication(String user, String password) {
		driver.findElement(userField).sendKeys(user);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(loginButton).click();
		
		ProductCatalogPageObject productCatalogObj = new ProductCatalogPageObject(driver);
		return productCatalogObj;
	}
	
	public String getLoginErrorMessage() {
		waitForElementToAppear(erroMessage);
		String errorMsg = driver.findElement(erroMessage).getText();
		return errorMsg;
	}
	
	public boolean getLoginLogo() {
		waitForElementToAppear(webSiteLogo);
		return driver.findElement(webSiteLogo).isDisplayed();
	}
}
