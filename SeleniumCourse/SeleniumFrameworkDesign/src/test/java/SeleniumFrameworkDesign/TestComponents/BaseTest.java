package SeleniumFrameworkDesign.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import SeleniumFrameworkDesign.PageObjects.LoginPageObject;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	//declare global webdriver
	public WebDriver driver;
	public LoginPageObject loginObj;
	
	public WebDriver initializeDriver() throws IOException {
		//delcare fileInputStream for global properties object, if you need to share the project is necessary to fix the path to get local path
		//FileInputStream globalProperties = new FileInputStream("C:\\Users\\Usuario\\Desktop\\Automation\\SeleniumCourse\\SeleniumFrameworkDesign\\src\\test\\java\\SeleniumFrameworkDesign\\Resources\\GlobalProperties.properties");
		FileInputStream globalProperties = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\SeleniumFrameworkDesign\\Resources\\GlobalProperties.properties");
		
		//declare properties object and load file properties
		Properties prop = new Properties();
		prop.load(globalProperties);
		String browser = prop.getProperty("browser");
		
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if (browser.equalsIgnoreCase("firefox")) {
			//for firefox
		}else {
			//for edge
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client/");

		return driver;
	}
	
	@BeforeMethod
	public LoginPageObject launchApp() throws IOException {
		driver = initializeDriver();
		loginObj = new LoginPageObject(driver);
		return loginObj;
	}
	
	@AfterMethod
	public void closeApp() {
		driver.quit();
	}


}
