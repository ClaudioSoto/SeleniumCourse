package SeleniumFrameworkDesign.Tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import SeleniumFrameworkDesign.PageObjects.CartPageObject;
import SeleniumFrameworkDesign.PageObjects.CheckoutPageObject;
import SeleniumFrameworkDesign.PageObjects.OrderPageObject;
import SeleniumFrameworkDesign.PageObjects.OrdersListPageObject;
import SeleniumFrameworkDesign.PageObjects.ProductCatalogPageObject;
import SeleniumFrameworkDesign.TestComponents.BaseTest;


public class StandaloneTestWithDesignPattern extends BaseTest{
	//Test data
	public String targProd = "IPHONE";
	
	@Test
	public void placeOrder() throws IOException {
		/* CATALOG PAGE*/
		//ProductCatalogPageObject productCatalogObj = new ProductCatalogPageObject(driver);
		ProductCatalogPageObject productCatalogObj = loginObj.loginApplication("claudio.soto.ayala@gmail.com", "Legostarwars10.");
		//add the target product to cart
		productCatalogObj.addTargetProductToCart(targProd);

		/* CART PAGE*/
		CartPageObject cartObj = productCatalogObj.goToCart();
		//verify if the target product is on cart
		Assert.assertNotNull(cartObj.getTargetCartProduct(targProd), "The product was not found!");

		/* CHECKOUT PAGE*/
		CheckoutPageObject checkoutObj =  cartObj.goToCheckout();
		//enter and select the target country  for shipping
		checkoutObj.selectCountry("Mexico");

		/* ORDER PAGE*/
		OrderPageObject orderObj = checkoutObj.placeTheOrder();
		//verify if place order message is correct
		Assert.assertTrue(orderObj.getConfirmationMessage().equalsIgnoreCase("Thankyou for the order."));
		//go back to home
		orderObj.returnHome();
	}

	@Test(dependsOnMethods= {"placeOrder"})
	public void verifyOrders() {

		ProductCatalogPageObject productCatalogObj = loginObj.loginApplication("claudio.soto.ayala@gmail.com", "Legostarwars10.");
		OrdersListPageObject orderListObj = productCatalogObj.goToOrders();
		Assert.assertNotNull(orderListObj.getTargetProductInOrders(targProd));

	}



}
