package WindowsAndIframes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//set webdriver object
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Usuario\\Desktop\\Automation\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		//open website
		driver.get("https://jqueryui.com/droppable/");
		
		//mover to the iframe
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		
		//drag and drop using action
		Actions actions = new Actions(driver);
		actions.dragAndDrop(driver.findElement(By.xpath("//div[@id='draggable']")), driver.findElement(By.id("droppable"))).build().perform();

	}

}
