package SeleniumFrameworkDesign.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import SeleniumFrameworkDesign.PageObjects.OrdersListPageObject;

public class AbstractComponent {
	
	public WebDriver driver;
	public WebDriverWait wait;
	Actions act;
	
	//common locators
	By homePageButton = By.xpath("//button[@routerlink='/dashboard/']");
	By OrderPageButton = By.xpath("//button[@routerlink='/dashboard/myorders']");
	
	
	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		act = new Actions(driver);
	}
	
	public void waitForElementToAppear(By findBy) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForElementToDisappear(By findBy) {
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(findBy)));
	}
	
	public void goToHome() {
		driver.findElement(homePageButton).click();
	}
	
	public OrdersListPageObject goToOrders() {
		driver.findElement(OrderPageButton).click();
		OrdersListPageObject ordersListObj = new OrdersListPageObject(driver);
		return ordersListObj;
	}

}
