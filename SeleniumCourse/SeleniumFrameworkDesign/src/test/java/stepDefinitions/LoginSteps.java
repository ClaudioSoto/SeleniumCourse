package stepDefinitions;

import org.testng.Assert;

import SeleniumFrameworkDesign.PageObjects.LoginPageObject;
import SeleniumFrameworkDesign.TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends BaseTest{
	
	public LoginPageObject loginObj;
	
    @Given("^The user is in the login page$")
    public void the_user_is_in_the_login_page() throws Throwable {
    	loginObj = launchApp();
    }

    @When("^The user login the application by enter (.+) and (.+)$")
    public void the_user_login_the_application_by_enter_and(String user, String password) throws Throwable {
    	loginObj.loginApplication(user, password);
    }

    @Then("^Validate if redirected to the cart page$")
    public void validate_if_redirected_to_the_cart_page() throws Throwable {
    	Assert.assertTrue(loginObj.getLoginLogo());
    	closeApp();
    }
    
    @Then("^Verify if the message error is displayed$")
    public void verify_if_the_message_error_is_displayed() throws Throwable {
    	Assert.assertEquals(loginObj.getLoginErrorMessage(), "Incorrect email or password.");
    	closeApp();
    }

}
