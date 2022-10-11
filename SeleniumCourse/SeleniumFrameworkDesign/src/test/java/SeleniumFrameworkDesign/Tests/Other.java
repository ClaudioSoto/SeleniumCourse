package SeleniumFrameworkDesign.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import SeleniumFrameworkDesign.TestComponents.BaseTest;
import SeleniumFrameworkDesign.TestComponents.RetryFailed;

public class Other extends BaseTest{
	
	@Test(retryAnalyzer = RetryFailed.class)
	public void verifyWebsiteUrl() {
		//get the current url and verify with the expected
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://rahulshettyacademy.com/client/auth/login");
	}

}
