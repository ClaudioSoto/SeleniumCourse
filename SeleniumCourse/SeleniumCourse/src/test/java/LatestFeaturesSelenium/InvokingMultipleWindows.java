package LatestFeaturesSelenium;


import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvokingMultipleWindows {

	static WebElement firstCourseTitle;

	public static void main(String[] args) {

		//set webdriver object
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//open website - primal
		driver.get("https://rahulshettyacademy.com/angularpractice/");

		//generate the second window
		driver.switchTo().newWindow(WindowType.WINDOW);

		//to get the windows and declare iterator for window id's
		Set <String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();

		//get the parent id
		String parentId = it.next().toString();
		String childId = it.next().toString();
		
		driver.switchTo().window(childId);

		//open the second website
		driver.get("https://rahulshettyacademy.com/");

		//get first course name
		firstCourseTitle = driver.findElement(By.xpath("(//div[@id='courses-block']//div//h2)[1]"));
		String courseName = firstCourseTitle.getText();
		System.out.println(courseName);
		
		//change to child window 
		driver.switchTo().window(parentId);
		
		//search and enter in name field the coruse name
		driver.findElement(By.cssSelector("input[name='name']")).sendKeys(courseName);

		driver.quit();
	}

}
