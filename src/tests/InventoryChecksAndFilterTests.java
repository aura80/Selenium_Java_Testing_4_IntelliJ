package tests;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import testdata.URL;
import testmessages.Messages;

@SuppressWarnings("deprecation")
public class InventoryChecksAndFilterTests extends SaucedemoBaseTest {

	@Before @Override
	public void before() throws AWTException {
		super.before();
		loginValidInvalidDataPage.authenticate(userloginTD.getUserName(), userloginTD.getPassword());
		// CURRENT URL, TITLE, PAGE SOURCE, WINDOW HANDLE
		inventoryPage.generalInfos();
	}
	
	@Test
	public void applPageLogin() {
		// SWAGLABS - logo
		Assert.assertTrue(header.applLogoDisplayed());
		Assert.assertTrue(header.applLogoEnabled());
		Assert.assertTrue(header.applLogoGetClass().contains(Messages.LOGO_BURGER_CLASS));
		header.applLogoGetLocation();
		// BURGER BUTTON
		Assert.assertTrue(header.burgerButtonDisplayed());
		Assert.assertTrue(header.burgerButtonEnabled());
		Assert.assertTrue(header.burgerButtonGetClass().contains(Messages.LOGO_BURGER_CLASS));
		header.burgerButtonLocation();
		Assert.assertEquals(header.applLogoGetClass(), header.burgerButtonGetClass());
		// BURGER BUTTON
		header.burgerButtonClick();
		// BURGER BUTTON ELEMENTS
		System.out.println(header.burgerButtonElements());
		try {
			Assert.assertTrue(header.burgerButtonElements().contains(Messages.ALL_ITEMS));
		}catch (Exception e) {
			System.out.println("ALL_ITEMS not found!");
		}
		try {
			Assert.assertTrue(header.burgerButtonElements().contains(Messages.ABOUT));
		} catch (Exception e2) {
			System.out.println("ABOUT not found!");
		}
		try {
			Assert.assertTrue(header.burgerButtonElements().contains(Messages.LOGOUT));
		} catch (Exception e3) {
			System.out.println("LOGOUT not found!");
		}
		try {
			Assert.assertTrue(header.burgerButtonElements().contains(Messages.RESET_APP_STATE));
		} catch (Exception e4) {
			System.out.println("RESET_APP_STATE not found!");
		}
			
		// BURGER BUTTON CLOSE
		header.burgerButtonClose();
		// SHOPPING CART
		Assert.assertTrue(header.shoppingCartDisplayed());
		Assert.assertTrue(header.shoppingCartEnabled());
		Assert.assertTrue(header.shoppingCartGetClass().contains(Messages.LOGO_BURGER_CLASS));
		header.burgerButtonLocation();
		Assert.assertEquals(header.applLogoGetClass(), header.shoppingCartGetClass());		
		// PRODUCTS
		Assert.assertEquals(Messages.PRODUCTS, header.productsLogo());
		// PICTURE
		header.peekPicture();		
		// FOOTER COLOR, LINKS, PICTURE
		// ASSERT BETWEEN FOOTER BACGROUND COLOR AND SECONDARY HEADER BACGROUND COLOR
		Assert.assertEquals(header.getSecondaryHeaderBackgroundColor(), footer.getFooterBackgroundColor());
		System.out.println();		
		// FOOTER LINKS
		footer.footerLinks();
		Assert.assertTrue(footer.footerText().contains(Messages.FOOTER_TEXT));
		System.out.println();
		// FOOTER PICTURE
		footer.footerPicture();
	}
	
	@Test
	public void applPageLoginAllLinks() {
		// ALL LINKS
		inventoryPage.allLinks();
		Assert.assertEquals(driver.getCurrentUrl(), URL.INV_URL);
	}
	
	@Test
	public void applPageFilters() {
		// SELECT 1 ALL TYPES OF SORT TEXT
		Assert.assertTrue(header.selectMethodOne().contains(Messages.SELECT_DROPDOWN_NAME_A));
		Assert.assertTrue(header.selectMethodOne().contains(Messages.SELECT_DROPDOWN_NAME_Z));
		Assert.assertTrue(header.selectMethodOne().contains(Messages.SELECT_DROPDOWN_NAME_LOW));
		Assert.assertTrue(header.selectMethodOne().contains(Messages.SELECT_DROPDOWN_NAME_HIGH));

		// SELECT 2 Price (low to high)
		header.selectMethodTwo();
		String priceSecondPrice = Float.toString(Messages.PRICE_THIRD_PRODUCT);						//  value 15.99f transformed into String
		Assert.assertEquals("$" + priceSecondPrice, inventoryPage.getListOfPrices().get(2));
		
		// SELECT 3 Price (high to low)
		header.selectMethodFive();
		String priceThirdPrice = Float.toString(Messages.PRICE_THIRD_PRODUCT);						//  value 15.99f transformed into String
		Assert.assertEquals("$" + priceThirdPrice, inventoryPage.getListOfPrices().get(3));
		
		// SELECT 4 Name (Z to A)
		header.selectMethodThree();
		Assert.assertEquals(Messages.PRODUCT_NAME_BIKE_LIGHT, inventoryPage.getListOfProducts().get(4));
		
		// SELECT 5 Name (A to Z)
		header.selectMethodFour();
		Assert.assertEquals(Messages.PRODUCT_NAME_RED_TSHIRT, inventoryPage.getListOfProducts().get(5));
		
		// SELECT 6 Price (low to high) PRICES, PRODUCTS, DESCRIPTIONS
		header.selectMethodSix();
		String priceLow = Float.toString(Messages.PRICE_ONESIE);						// lowest price 7.99f transformed into String
		Assert.assertEquals("$" + priceLow, inventoryPage.getListOfPrices().get(0));
		Assert.assertEquals(Messages.PRODUCT_NAME, inventoryPage.getListOfProducts().get(0));	// first product at lowest price
		Assert.assertEquals(Messages.JUNIOR_AUTOMATION_TEXT, inventoryPage.getListOfDescriptions().get(0)); // lowest price description
		
		// SELECT 7 Name (A to Z) PRICES, PRODUCTS, DESCRIPTIONS
		header.selectMethodSeven();
		Assert.assertEquals(Messages.PRODUCT_NAME_BACKPACK, inventoryPage.getListOfProducts().get(0));	// first product alfabetically
		String priceFirstName = Float.toString(Messages.PRICE_FIRST_NAME);						//  value 29.99f price of first name product transformed into String
		Assert.assertEquals("$" + priceFirstName, inventoryPage.getListOfPrices().get(0));
		Assert.assertEquals(Messages.SLY_PACK_TEXT, inventoryPage.getListOfDescriptions().get(0));	// first name product description
	}
	
	@Test
	public void productsList() {

		Assert.assertTrue(inventoryPage.getListOfProducts().contains(Messages.PRODUCT_NAME_BIKE_LIGHT));
		Assert.assertTrue(inventoryPage.getListOfProducts().contains(Messages.PRODUCT_NAME_FLEECE_JACKET));
		Assert.assertTrue(inventoryPage.getListOfProducts().contains(Messages.PRODUCT_NAME));
		Assert.assertTrue(inventoryPage.getListOfProducts().contains(Messages.PRODUCT_NAME_BACKPACK));
		Assert.assertTrue(inventoryPage.getListOfProducts().contains(Messages.PRODUCT_NAME_BOLT_TSHIRT));
		Assert.assertTrue(inventoryPage.getListOfProducts().contains(Messages.PRODUCT_NAME_RED_TSHIRT));

		Assert.assertTrue(inventoryPage.getListOfPrices().contains(Messages.PRODUCT_PRICE));
		Assert.assertTrue(inventoryPage.getListOfPrices().contains(Messages.PRODUCT_PRICE_BIKE_LIGHT));
		
		Assert.assertTrue(inventoryPage.getListOfDescriptions().contains(Messages.SLY_PACK_TEXT));
		Assert.assertTrue(inventoryPage.getListOfDescriptions().contains(Messages.BIKE_TEXT));
		Assert.assertTrue(inventoryPage.getListOfDescriptions().contains(Messages.SUPERHERO_TEXT));
		Assert.assertTrue(inventoryPage.getListOfDescriptions().contains(Messages.QUARTER_ZIP_TEXT));
		Assert.assertTrue(inventoryPage.getListOfDescriptions().contains(Messages.JUNIOR_AUTOMATION_TEXT));
		Assert.assertTrue(inventoryPage.getListOfDescriptions().contains(Messages.COZYING_TEXT));
				
		for (String s : inventoryPage.getListOfProducts()) {
			if (s.contains(Messages.SAUCE)) {
				Assert.assertTrue(s.contains(Messages.LABS));
			}
			else {
				Assert.assertTrue(s.contains(Messages.TEST));
			}
		}
		
		System.out.println();
		
		for (String d : inventoryPage.getListOfDescriptions()) {
			if (d.contains(Messages.SLY_PACK)) {
				Assert.assertTrue(d.contains(Messages.SLY_PACK_TEXT));
			}else if(d.contains(Messages.BIKE)) {
				Assert.assertTrue(d.contains(Messages.BIKE_TEXT));
			}else if(d.contains(Messages.SUPERHERO)) {
				Assert.assertTrue(d.contains(Messages.SUPERHERO_TEXT));
			}else if(d.contains(Messages.QUARTER_ZIP)) {
				Assert.assertTrue(d.contains(Messages.QUARTER_ZIP_TEXT));
			}else if(d.contains(Messages.JUNIOR_AUTOMATION)) {
				Assert.assertTrue(d.contains(Messages.JUNIOR_AUTOMATION_TEXT));
			}else if(d.contains(Messages.COZYING)) {
				Assert.assertTrue(d.contains(Messages.COZYING_TEXT));
			}
		}
	}
	
	@Test
	public void burgerItems() {
		
		// CLICK ON JACKET TO SEE BETTER ALL ITEMS AFTER CLICK ON ALL ITEMS BUTTON  
		header.fleceJacketClick();
		header.burgerButtonClick();
		header.allItemsClick();
		header.burgerButtonClick();
		header.aboutClick();
		Assert.assertEquals(URL.LABS_URL, driver.getCurrentUrl());
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().back();
		driver.navigate().to(URL.INV_URL);
		Assert.assertEquals(URL.INV_URL, driver.getCurrentUrl());
		header.burgerButtonClick();
		header.resetClick();
//		header.burgerButtonClick();
//		header.logoutClick();
		logoutPage.logOutClick();
	}
	
}
