package WebElementsAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CompoundDropDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//set webdriver object
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\Usuario\\Desktop\\Automation\\WebDrivers\\chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				
				//implicit wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.manage().window().maximize();
				
				//open website
				driver.get("https://www.spicejet.com/");
				
				//click the dropdown
				driver.findElement(By.xpath("//div[@data-testid='home-page-travellers']")).click();
				
				//select number of people (adults)
				for(int i =0; i<8; i++) {
					driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).click();
				}

				//Exit from browser
				driver.quit();

	}

}
