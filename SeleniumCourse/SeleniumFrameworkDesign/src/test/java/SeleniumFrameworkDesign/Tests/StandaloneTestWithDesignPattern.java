package SeleniumFrameworkDesign.Tests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import SeleniumFrameworkDesign.PageObjects.PageObjectManager;

public class StandaloneTestWithDesignPattern {

	@Test
	public void placeOrder() throws IOException {
		//Test data
		String targProd = "IPHONE";
		String country = "Mexico";

		//declare page object manager
		PageObjectManager manager = new PageObjectManager();

		//laucnh app
		manager.baseObj.launchApp();

		/* LOGIN PAGE*/
		//enter login data, and submit
		manager.loginObj.loginApplication("claudio.soto.ayala@gmail.com", "Legostarwars10.");

		/* CATALOG PAGE*/
		//add the target product to cart
		manager.productCatalogObj.addTargetProductToCart(targProd);
		//go to the cart
		manager.productCatalogObj.goToCart();

		/* CART PAGE*/
		//verify if the target product is on cart
		Assert.assertNotNull(manager.cartObj.getTargetCartProduct(targProd), "The product was not found!");
		//go to the checkout page
		manager.cartObj.goToCheckout();

		/* CHECKOUT PAGE*/
		//enter and select the target country  for shipping
		manager.checkoutObj.selectCountry(country);
		//place the order
		manager.checkoutObj.placeTheOrder();

		/* ORDER PAGE*/
		//verify if place order message is correct
		Assert.assertTrue(manager.orderObj.getConfirmationMessage().equalsIgnoreCase("Thankyou for the order."));
		//go back to home
		manager.orderObj.returnHome();

		//close brwoser
		manager.baseObj.closeBrowser();
	}

}
