package Exercises;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//set webdriver object
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Usuario\\Desktop\\Automation\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		//open website
		driver.get("https://the-internet.herokuapp.com/windows");

		//click the opne new windown link
		driver.findElement(By.xpath("//div[@class='example']/a")).click();

		//get window id's in a set and declare iterator
		Set <String> windows = driver.getWindowHandles();
		Iterator <String> it = windows.iterator();

		//store parent and child id's
		String parentWindow = it.next().toString();
		String childWindow = it.next().toString();

		//move to the child window
		driver.switchTo().window(childWindow);

		//get text from from child window
		String childText = driver.findElement(By.xpath("//div[@class='example']/h3")).getText().toString();
		System.out.println("This is a child text:" + childText);

		//move to parent window
		driver.switchTo().window(parentWindow);

		//get text from from child window
		String parentText = driver.findElement(By.xpath("//div[@class='example']/h3")).getText().toString();
		System.out.println("This is a parent text:" + parentText);
		
		//close browser
		driver.quit();

	}

}
