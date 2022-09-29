package SeleniumFrameworkDesign.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import SeleniumFrameworkDesign.AbstractComponents.AbstractComponent;

public class OrderPageObject extends AbstractComponent{
	
	public WebDriver driver;
	
	//locators
	By confirmationMsg = By.xpath("//h1[@class='hero-primary']");


	public OrderPageObject(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public String getConfirmationMessage() {
		return driver.findElement(confirmationMsg).getText().trim();
	}
	
	public void returnHome() {
		goToHome();
	}

}
