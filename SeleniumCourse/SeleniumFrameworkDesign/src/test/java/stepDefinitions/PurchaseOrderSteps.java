package stepDefinitions;

import org.testng.Assert;

import SeleniumFrameworkDesign.PageObjects.CartPageObject;
import SeleniumFrameworkDesign.PageObjects.CheckoutPageObject;
import SeleniumFrameworkDesign.PageObjects.OrderPageObject;
import SeleniumFrameworkDesign.PageObjects.ProductCatalogPageObject;
import SeleniumFrameworkDesign.TestComponents.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PurchaseOrderSteps extends BaseTest{

	public ProductCatalogPageObject productCatalogObj;
	public CartPageObject cartObj;
	public CheckoutPageObject checkoutObj;
	public OrderPageObject orderObj;


	@Given("^The user is in the login page and login$")
	public void the_user_is_in_the_login_page_and_login() throws Throwable {
		launchApp();
		productCatalogObj = loginObj.loginApplication("claudio.soto.ayala@gmail.com", "Legostarwars10.");
	}

	@When("^The user select the target product (.+)$")
	public void the_user_select_the_target_product(String product) throws Throwable {
		productCatalogObj.addTargetProductToCart(product);
	}

	@And("^The user goes to the cart page$")
	public void the_user_goes_to_the_cart_page() throws Throwable {
		cartObj = productCatalogObj.goToCart();
	}

	@And("^Verifies the product (.+) is on the cart$")
	public void verifies_the_product_is_on_the_cart(String product) throws Throwable {
		Assert.assertNotNull(cartObj.getTargetCartProduct(product), "The product was not found!");
	}

	@When("User proceed with the checkout")
	public void user_proceed_with_the_checkout() {
		// Write code here that turns the phrase above into concrete actions
		checkoutObj =  cartObj.goToCheckout();
	}

	@And("^fills the shipment information of the country (.+)$")
	public void fills_the_shipment_information_of_the_country(String country) throws Throwable {
		checkoutObj.selectCountry(country);
	}

	@And("^place the order$")
	public void place_the_order() throws Throwable {
		orderObj = checkoutObj.placeTheOrder();
	}

	@Then("^Verifies the conformation order message$")
	public void verifies_the_conformation_order_message() throws Throwable {
		Assert.assertTrue(orderObj.getConfirmationMessage().equalsIgnoreCase("Thankyou for the order."));
	}

	@And("^returns to home$")
	public void returns_to_home() throws Throwable {
		orderObj.returnHome();
		closeApp();
	}

}
