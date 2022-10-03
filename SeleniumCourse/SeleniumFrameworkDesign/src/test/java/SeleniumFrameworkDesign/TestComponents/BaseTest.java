package SeleniumFrameworkDesign.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

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

	public List<HashMap<String, String>> getJsonDataToHashMap(String filePath) throws IOException {
		//get jason file into a string
		String jsonContet = FileUtils.readFileToString(new File (filePath),
				StandardCharsets.UTF_8);
	
		//get hashmap with the json
		ObjectMapper mapper = new ObjectMapper();
		
		//json to hashmap list
		List<HashMap<String,String>> data = mapper.readValue(jsonContet, new TypeReference<List<HashMap<String,String>>>(){});
		
		return data;
	}

}
