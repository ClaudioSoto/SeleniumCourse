package WindowsAndIframes;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChildWindows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//set webdriver object
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		//open website
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		//click the link to open child window
		driver.findElement(By.className("blinkingText")).click();
		
		//to get the windows and declare iterator for window id's
		Set <String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		
		//get the parent id
		String parentId = it.next().toString();
		String childId = it.next().toString();
		
		//go back to parent window
		driver.switchTo().window(parentId);
		
		//go back to child id
		driver.switchTo().window(childId);

	}

}
