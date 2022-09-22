package tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import testdata.URL;
import testmessages.Messages;

@SuppressWarnings("deprecation")
public class ProductDetailsBookingTests extends SaucedemoBaseTest {

	@Before @Override
	public void before() throws AWTException {
		super.before();
		loginValidInvalidDataPage.authenticate(userloginTD.getUserName(), userloginTD.getPassword());
		System.out.println("Current URL: " + driver.getCurrentUrl());
		System.out.println("Page title:  " + driver.getTitle());
		Assert.assertEquals(URL.INV_URL, driver.getCurrentUrl());
		Assert.assertEquals(Messages.BASE_TITLE, driver.getTitle());
	}
	
	@Test
	public void productDetailsAddRemoveToCart() {

		// ORDER Price (low to high)
		productDetails.selectMethodSix();
		// CONTINUE SHOPPING IF EMPTY CART
		productDetails.continueShopping();
		Assert.assertEquals(Messages.PRODUCT_NAME, productDetails.getProductNameOnesieText());
		Assert.assertEquals(Messages.JUNIOR_AUTOMATION_TEXT, productDetails.getProductDescription());
		Assert.assertEquals(Messages.PRODUCT_PRICE, productDetails.getProductPrice());
		// PICTURE OF THE ADDED PRODUCT
		productDetails.productPicture();
		// ADD PRODUCT TO THE CART
		productDetails.productAddToCart();
		// PRODUCTS INTO THE CART
		Assert.assertEquals(Messages.PRODUCT_ONE_INTO_CART_ADDED, "Products into the cart:   " + header.shoppingCartBadge());
		// REMOVE PRODUCT FROM THE CART
		productDetails.productRemoval();
		// ADD NEW PRODUCT TO CART 
		productDetails.addNewProductToCart();
	}
	
	@Test
	public void productDetailsBookingOneProduct() {
		
		// FROM HERE IT REPEATS ITSELF IN TEST productDetailsBookingTwoProducts()***  		see test below  
		Assert.assertEquals(Messages.PRODUCT_ONE_ADDED, "Product 1 added: " + productDetails.getProductNameBikeLightText() + " ,  " + productDetails.getProductBikeLightPrice());
		productDetails.addNewProductToCart();
		
		// PRODUCTS INTO THE CART
		System.out.println("Products into the cart automatically updated:   " + header.shoppingCartBadge());
		Assert.assertNotNull(header.shoppingCartBadge());
		productDetails.shoppingCartClick();
		productDetails.checkoutProducts();
		productDetails.sendInputsForCheckout();
		
		// LIST OF INFOS ABOUT CHECKOUT
		Assert.assertTrue(productDetails.getInfoCheckout().contains(Messages.INFO_SAUCECARD_CHECKOUT));
		Assert.assertTrue(productDetails.getInfoCheckout().contains(Messages.INFO_DELIVERY_CHECKOUT));

		// ASSERTS BASED ON CHECKOUT INFOS
		Assert.assertEquals(Messages.INFO_PAYMENT_CHECKOUT, productDetails.getInfoPaymentCheckout());
		Assert.assertTrue(productDetails.getInfoSauceCardCheckout().contains(Messages.INFO_SAUCECARD_CHECKOUT));
		Assert.assertEquals(Messages.INFO_SHIPPING_CHECKOUT, productDetails.getInfoShippingCheckout());
		Assert.assertEquals(Messages.INFO_DELIVERY_CHECKOUT, productDetails.getInfoDeliveryCheckout());
		Assert.assertTrue(productDetails.getInfoNoTaxTotalCheckout().contains(Messages.INFO_NOTAX_TOTAL_CHECKOUT));
		Assert.assertTrue(productDetails.getInfoTaxCheckout().contains(Messages.INFO_TAX_CHECKOUT));
		Assert.assertTrue(productDetails.getInfoTotalCheckout().contains(Messages.INFO_TOTAL_CHECKOUT));

		// TOTAL PRICE OF THE CART
		System.out.println("Price of the cart automatically updated:   *     " + productDetails.getProductsTotalPrice());
		Assert.assertNotNull(productDetails.getProductsTotalPrice());
		
		// FINISH CLICK
		productDetails.finishClick();
		// CHECKOUT COMPLETE
		Assert.assertEquals(Messages.CHECKOUT_COMPLETE, productDetails.getCheckoutComplete());
		// CHECKOUT COMPLETE thankYou
		Assert.assertEquals(Messages.THANK_YOU, productDetails.getThankYou());
		// CHECKOUT COMPLETE msgPony
		Assert.assertEquals(Messages.MSG_PONY, productDetails.getMsgPony());
		// CHECKOUT COMPLETE imgPony
		Assert.assertEquals(Messages.IMG_PONY, productDetails.getImgPony());
		// CHECKOUT COMPLETE backHome
		productDetails.backHome();
	}
	
	@Test
	public void productDetailsBookingOneTwoProducts() throws AWTException {

		// ADDING PRODUCTS TO CART FROM  https://www.saucedemo.com/inventory-item.html?id=2
		// SECOND ADD Sauce Labs Onesie

		Assert.assertEquals(Messages.PRODUCT_TWO_ADDED, "Product 2 added: " + productDetails.getProductNameOnesieText() + " ,  " + productDetails.getProductOnesiePrice());
		// PRODUCT NAME CLICK	!!!
		productDetails.productNameClick();
		// HANDLING THE COORDINATES OF THE BROWSER ZOOMING OUT
		Robot robot = new Robot();
		for (int i = 0; i < 5; i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}
		// CURRENT URL AFTER ADDING TO CART
		Assert.assertEquals(URL.ITEM_URL, driver.getCurrentUrl());
		// ASSERTS FOR NAME, DESCRIPTION & PRICE OF THE PRODUCT
		Assert.assertEquals(Messages.PRODUCT_NAME, productDetails.getProductNameAfterClick());
		Assert.assertEquals(Messages.JUNIOR_AUTOMATION_TEXT, productDetails.getProductDescriptionAfterClick());
		Assert.assertEquals(Messages.PRODUCT_PRICE, productDetails.getProductPriceAfterClick());
		// PICTURE AFTER CLICK ON NAME 
		productDetails.productPictureAfterClick();
		// ADD PRODUCT TO THE CART AFTER CLICK ON NAME
		productDetails.productAddToCartAfterClick();
		// BACK TO PRODUCTS
		productDetails.backToProducts();
		
		// ADDING PRODUCTS TO CART FROM https://www.saucedemo.com/inventory.html
		productDetailsBookingOneProduct();

		// FROM HERE IT REPEATS ITSELF IN TEST productDetailsBookingTwoProducts()***  		see test above
	}
	
	@Test
	public void productPriceAssertions() {

		Assert.assertEquals("Product 1 : " + Messages.PRODUCT_NAME_BIKE_LIGHT + " ,  " + Messages.PRODUCT_PRICE_BIKE_LIGHT, "Product 1 : " + productDetails.getProductNameBikeLightText() + " ,  " + productDetails.getProductBikeLightPrice());
		Assert.assertEquals("Product 2 : " + Messages.PRODUCT_NAME + "	  ,  " + Messages.PRODUCT_PRICE, "Product 2 : " + productDetails.getProductNameOnesieText() + "	  ,  " + productDetails.getProductOnesiePrice());

		Assert.assertEquals(Messages.PRODUCT_TOTAL_PRICE_TEXT, " Total price of two products:     " + (Messages.PRICE_ONESIE + Messages.PRICE_BIKE_LIGHT) + " $ ");
		Assert.assertEquals(Messages.PRODUCT_PRICE_AFTER_TAXES_TEXT, " After adding taxes of 	  	   " + Messages.TAX + " $  \n The total price is : 	          " + (Messages.PRICE_ONESIE + Messages.PRICE_BIKE_LIGHT + Messages.TAX) + " $ ");
		
		// PRICE ASSERTIONS
		Assert.assertEquals("$" + Messages.PRICE_ONESIE, productDetails.getProductOnesiePrice());
		Assert.assertEquals("$" + Messages.PRICE_BIKE_LIGHT, productDetails.getProductBikeLightPrice());
		Assert.assertEquals("Total: $" + (Messages.PRICE_ONESIE + Messages.PRICE_BIKE_LIGHT + Messages.TAX), "Total: $19.42");
		Assert.assertEquals(Messages.PRICE_ONESIE + Messages.PRICE_BIKE_LIGHT + Messages.TAX, Messages.TOTAL_PRICE_CART);
	}
	
	@Test
	public void productInvalidSenderData() throws AWTException {
		
		// HANDLING THE COORDINATES OF THE BROWSER ZOOMING OUT
		Robot robot = new Robot();
		for (int i = 0; i < 5; i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}
		productDetails.addNewProductToCart();
		productDetails.shoppingCartClick();
		productDetails.checkoutProducts();
		productDetails.sendInvalidInputsForCheckoutFirstName();
		Assert.assertEquals(Messages.SENDER_ERR_FIRSTNAME, productDetails.getSenderError());
		productDetails.clickErr();
		productDetails.sendInvalidInputsForCheckoutLastName();
		Assert.assertEquals(Messages.SENDER_ERR_LASTNAME, productDetails.getSenderError());
		productDetails.clickErr();
		productDetails.sendInvalidInputsForCheckoutPostalCode();
		Assert.assertEquals(Messages.SENDER_ERR_POSTALCODE, productDetails.getSenderError());
		productDetails.clickErr();
	}
}
