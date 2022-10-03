package SeleniumFrameworkDesign.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import SeleniumFrameworkDesign.AbstractComponents.AbstractComponent;

public class OrdersListPageObject extends AbstractComponent{
	
	List <WebElement> registeredOrders;
	
	//locators
	By tableElements = By.cssSelector("tr td:nth-child(3)");
	

	public OrdersListPageObject(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public List<WebElement> getListOfOrders() {
		registeredOrders = driver.findElements(tableElements);
		return registeredOrders;
	}
	
	public WebElement getTargetProductInOrders(String targProd) {
		WebElement targetProductOrdered = getListOfOrders().stream().filter(order -> order.getText().contains(targProd.toLowerCase())).findFirst().orElse(null);
		return targetProductOrdered;
	}
	
	
	
	

}
