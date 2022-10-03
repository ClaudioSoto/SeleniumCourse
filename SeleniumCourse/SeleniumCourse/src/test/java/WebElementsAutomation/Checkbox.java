package WebElementsAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkbox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//set webdriver object
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Usuario\\Desktop\\Automation\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		//open website
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//check if the status of the checkbox
		boolean checkboxStatus = driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_friendsandfamily']")).isSelected();
		
		//print the status of the checkbox
		System.out.println("original status:" + checkboxStatus);
		
		//click the check box
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_friendsandfamily']")).click();
		
		//check if the status of the checkbox
		checkboxStatus = driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_friendsandfamily']")).isSelected();
		
		//print the status of the checkbox
		System.out.println("post status:" + checkboxStatus);
		
		//get all the checkboxes in the screen
		int numberCbxs = driver.findElements(By.xpath("//input[@type='checkbox']")).size();
		
		//print number of cherckboxes
		System.out.println("the number of checkboxes are:" + numberCbxs);
		
		//close browser
		driver.quit();

	}

}
