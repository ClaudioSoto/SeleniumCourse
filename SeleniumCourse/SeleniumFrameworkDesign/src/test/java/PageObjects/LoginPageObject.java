package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import AbstractComponents.AbstractComponent;

public class LoginPageObject extends AbstractComponent{
	
	public WebDriver driver;
	By userField = By.xpath("//input[@id='userEmail']");
	By passwordField  = By.xpath("//input[@id='userPassword']");
	By loginButton  = By.xpath("//input[@id='login']");
	
	public LoginPageObject(WebDriver driver) {
		//to send the driver to  the parent class
		super(driver);
		this.driver = driver;
	}
	
	public void loginApplication(String user, String password) {
		driver.findElement(userField).sendKeys(user);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(loginButton).click();
	}
	
}
