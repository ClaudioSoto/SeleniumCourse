package SeleniumFrameworkDesign.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import SeleniumFrameworkDesign.AbstractComponents.AbstractComponent;

public class CheckoutPageObject extends AbstractComponent{

	public WebDriver driver;
	
	//locators
	By countryField = By.xpath("//input[@placeholder='Select Country']");
	By countryOptionList = By.cssSelector(".ta-results");
	By placeOrderButton = By.cssSelector(".actions a");
	
	
	
	public CheckoutPageObject(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public void selectCountry(String country) {
		Actions act = new Actions(driver);
		act.click(driver.findElement(countryField)).sendKeys(country).build().perform();
		waitForElementToAppear(countryOptionList);
		driver.findElement(countryOptionList).click();
	}
	
	public OrderPageObject placeTheOrder() {
		driver.findElement(placeOrderButton).click();
		OrderPageObject orderObj = new OrderPageObject(driver);
		return orderObj;
	}

}
