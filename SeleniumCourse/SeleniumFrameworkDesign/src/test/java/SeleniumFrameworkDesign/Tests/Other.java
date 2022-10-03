package SeleniumFrameworkDesign.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import SeleniumFrameworkDesign.TestComponents.BaseTest;

public class Other extends BaseTest{
	
	@Test
	public void verifyWebsiteUrl() {
		//get the current url and verify with the expected
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://rahulshettyacademy.com/client/auth/login");
	}

}
