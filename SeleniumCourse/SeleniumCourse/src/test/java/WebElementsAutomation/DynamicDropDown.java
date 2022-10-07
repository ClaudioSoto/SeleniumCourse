package WebElementsAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//set webdriver object
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		//open website
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		//click the dropdown
		driver.findElement(By.name("ctl00_mainContent_ddl_originStation1_CTXT")).click();

		//select start place - index way
		//driver.findElement(By.xpath("//a[@value='VTZ']")).click();

		//select end place - index way
		//driver.findElement(By.xpath("(//a[@value='DEL'])[2]")).click();

		//select start place - parent - child aproach
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='VTZ']")).click();

		//select end place - parent - child aproach
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='DEL']")).click();


		//Exit from browser
		//driver.quit();

	}

}
