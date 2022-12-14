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
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import SeleniumFrameworkDesign.PageObjects.LoginPageObject;
import io.cucumber.java.After;
import io.cucumber.java.Before;
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
		String propertiesBrowser = prop.getProperty("browser");
		//to execute in terminal
		String terminalBrowser = System.getProperty("browser");

		//selects maven value if not null
		String selectedBrowser = terminalBrowserCheck(terminalBrowser, propertiesBrowser);

		if(selectedBrowser.contains("chrome")) {
			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if(selectedBrowser.contains("headless")) {
				options.addArguments("headless");
			}
			driver = new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440,900));//run in full screen
		}else if (selectedBrowser.equalsIgnoreCase("firefox")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if (selectedBrowser.contains("edge")){
			EdgeOptions options = new EdgeOptions();
			WebDriverManager.edgedriver().setup();
			if(selectedBrowser.contains("headless")) {
				options.addArguments("headless");
			}
			driver = new EdgeDriver(options);
			driver.manage().window().setSize(new Dimension(1440,900));//run in full screen
		}


		/*
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if (browser.equalsIgnoreCase("edge")){
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		 */

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
	

	/*UTILITIES */

	public String terminalBrowserCheck(String terminalBrowser, String propertiesBrowser) {
		return terminalBrowser != null ? terminalBrowser : propertiesBrowser;
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


	public String getScreenShot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "\\test-output\\" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "\\test-output\\" + testCaseName + ".png";

	}

}
