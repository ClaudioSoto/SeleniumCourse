package Exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedFramesExercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//set webdriver object
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Usuario\\Desktop\\Automation\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		//open website
		driver.get("https://the-internet.herokuapp.com/nested_frames");

		//move to frame top
		driver.switchTo().frame(driver.findElement(By.name("frame-top")));
		
		//left
		printFrameValue(driver, "frame-left");
		
		//middle
		printFrameValue(driver, "frame-middle");
		
		//right
		printFrameValue(driver, "frame-right");
		
		//go back to the root
		driver.switchTo().parentFrame();
		
		//move to frame bottom
		driver.switchTo().frame(driver.findElement(By.name("frame-bottom")));
		
		//bottom
		printFrameValue(driver, "");
		
		//close browser
		driver.quit();

	}
	
	public static void printFrameValue(WebDriver driver, String targetFrameXpath) {
		
		if(!targetFrameXpath.isEmpty()) {
			driver.switchTo().frame(driver.findElement(By.name(targetFrameXpath)));
		}
		System.out.println("frame text:" + driver.findElement(By.xpath("//body")).getText());
		driver.switchTo().parentFrame();
	}

}
