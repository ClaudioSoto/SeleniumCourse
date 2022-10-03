package SeleniumFrameworkDesign.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import SeleniumFrameworkDesign.TestComponents.BaseTest;

public class LoginTests extends BaseTest{
	
	
	@Test
	public void verifyCorrectLogin() {
		loginObj.loginApplication("claudio.soto.ayala@gmail.com", "Legostarwars10.");
		Assert.assertTrue(loginObj.getLoginLogo());
		
	}
	
	
	@Test
	public void verifyIncorrectLoginMessage() {
		loginObj.loginApplication("not.an.email@gmail.com", "incorrect.");
		Assert.assertEquals(loginObj.getLoginErrorMessage(), "Incorrect email or password.");
	}

}
