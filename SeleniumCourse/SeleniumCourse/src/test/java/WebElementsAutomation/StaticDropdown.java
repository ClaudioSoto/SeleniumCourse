package WebElementsAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class StaticDropdown {

	public static void main(String[] args) {

		//set webdriver object
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		
		//open website
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//create a web element object for the dropdow
		WebElement dropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		
		//select the dropdown with the select object
		Select dropdownSelection = new Select(dropdown);
		
		//select an option
		dropdownSelection.selectByValue("USD");
		
		System.out.println(dropdownSelection.getFirstSelectedOption().getText());
		
		//Exit from browser
		driver.quit();
	}

}
