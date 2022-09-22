package pages;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import components.Header;
import testmessages.Messages;

public class ProductDetails extends Header{
	
	private WebDriver driver;

	public ProductDetails(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	private By applLogo = By.xpath("//div[@class=\"header_label\"]/div[@class=\"app_logo\"]");
	private By productNameOnesie = By.xpath("//div/a[@id=\"item_2_title_link\"]/div");
	private By productNameBikeLight = By.xpath("//div/a[@id=\"item_0_title_link\"]/div");
	private By productPriceOnesie = By.xpath("//div[@class=\"pricebar\"]/div[contains(.,\""+Messages.PRICE_ONESIE+"\")]");
	private By productPriceBikeLight = By.xpath("//div/a[@id=\"item_0_title_link\"]/parent::div/following-sibling::div/div[contains(.,\""+Messages.PRICE_BIKE_LIGHT+"\")]");
	private By productTotalDoublePrice = By.xpath("//div[@class=\"summary_total_label\"]");
	private By productDescription = By.xpath("//div/a[@id=\"item_2_title_link\"]/following-sibling::div[@class=\"inventory_item_desc\"]");
	private By productPicture = By.xpath("//div/a[@id=\"item_2_img_link\"]/img");
	private By productPrice = By.xpath("//div/a[@id=\"item_2_title_link\"]/parent::div[@class=\"inventory_item_label\"]/following-sibling::div[@class=\"pricebar\"]/div");
	private By productAddToCart = By.xpath("//div/a[@id=\"item_2_title_link\"]/parent::div[@class=\"inventory_item_label\"]/following-sibling::div[@class=\"pricebar\"]/button");
	private By productRemoval = By.id("remove-sauce-labs-onesie");
	private By productNameClick = By.xpath("//div[@class=\"inventory_details_name large_size\"]");
	private By productDescriptionClick = By.xpath("//div[@class=\"inventory_details_desc large_size\"]");
	private By productPictureClick = By.xpath("//img[@class=\"inventory_details_img\"]");
	private By productPriceClick = By.xpath("//div[@class=\"inventory_details_price\"]");
	private By productAddToCartClick = By.xpath("//button[@class=\"btn btn_primary btn_small btn_inventory\"]");
	private By backToProducts = By.xpath("//button[@id=\"back-to-products\"]");
	private By addNewProductToCart = By.xpath("//button[@id=\"add-to-cart-sauce-labs-bike-light\"]");
	private By checkoutProducts = By.name("checkout");
	private By firstName = By.id("first-name");
	private By lastName = By.id("last-name");
	private By postalCode = By.id("postal-code");
	private By continueButton = By.id("continue");
	private By infoCheckout = By.xpath("//div[@class=\"summary_info\"]/div");
	private By infoPaymentCheckout = By.xpath("//div[@class=\"summary_info\"]/div[1]");
	private By infoSauceCardCheckout = By.xpath("//div[@class=\"summary_info\"]/div[2]");
	private By infoShippingCheckout = By.xpath("//div[@class=\"summary_info\"]/div[3]");
	private By infoDeliveryCheckout = By.xpath("//div[@class=\"summary_info\"]/div[4]");
	private By infoNoTaxTotalCheckout = By.xpath("//div[@class=\"summary_info\"]/div[5]");
	private By infoTaxCheckout = By.xpath("//div[@class=\"summary_info\"]/div[6]");
	private By infoTotalCheckout = By.xpath("//div[@class=\"summary_info\"]/div[7]");
	private By finishClick = By.xpath("//div[@class=\"summary_info\"]/div[@class=\"cart_footer\"]/button[@id=\"finish\"]");
	private By checkoutComplete = By.xpath("//span[contains(text(),\""+Messages.CHECKOUT_COMPLETE_LOWER+"\")]");
	private By thankYou = By.xpath("//div[@id=\"checkout_complete_container\"]/h2");
	private By msgPony = By.xpath("//div[@id=\"checkout_complete_container\"]/h2/following-sibling::div");
	private By imgPony = By.xpath("//div[@id=\"checkout_complete_container\"]/h2/following-sibling::img");
	private By backHome = By.xpath("//div[@id=\"checkout_complete_container\"]/h2/following-sibling::button");
	private By continueShopping = By.xpath("//div[@class=\"cart_footer\"]/button[@id=\"continue-shopping\"]");
	private By senderError = By.xpath("//h3");
	private By clickErr = By.xpath("//h3/button/*");

	
	// SELECT PRODUCTS IN A CERTAIN ORDER
	@Before @Override
	public void selectMethodSix() {
		super.selectMethodSix();	// SELECT PRODUCTS WITH PRICES FROM LOW TO HIGH
		super.shoppingCartClick();	// SHOPPING CART CLICK
	}
	// PRODUCT NAME ONESIE
	public String getProductNameOnesieText() {
		return driver.findElement(productNameOnesie).getText();
	}
	// PRODUCT ONESIE PRICE
	public String getProductOnesiePrice() {
		return driver.findElement(productPriceOnesie).getText();
	}
	// PRODUCT NAME BIKE LIGHT 
	public String getProductNameBikeLightText() {
		return driver.findElement(productNameBikeLight).getText();
	}
	// PRODUCT BIKE LIGHT PRICE
	public String getProductBikeLightPrice() {
		return driver.findElement(productPriceBikeLight).getText();
	}
	// PRODUCTs DOUBLE TOTAL PRICE
	public String getProductsTotalPrice() {
		return driver.findElement(productTotalDoublePrice).getText();
	}
	// PRODUCT DESCRIPTION
	public String getProductDescription() {
		return driver.findElement(productDescription).getText();
	}
	// PRODUCT PICTURE
	public void productPicture() {
		System.out.println("Product's picture location:	 " + driver.findElement(productPicture).getLocation());
		System.out.println("Product's picture source:	 " + driver.findElement(productPicture).getAttribute("src"));
	}
	// PRODUCT PRICE
	public String getProductPrice() {
		return driver.findElement(productPrice).getText();
	}
	// ADD PRODUCT TO THE CART
	public void productAddToCart() {
		driver.findElement(productAddToCart).click();
	}
	// REMOVE PRODUCT FROM THE CART
	public void productRemoval() {
		driver.findElement(productRemoval).click();
	}
	// CONTINUE SHOPPING IF EMPTY CART
	public void continueShopping() {
		driver.findElement(continueShopping).click();
	}
	// PRODUCT NAME CLICK	!!!
	public void productNameClick() {
		driver.findElement(productNameOnesie).click();
	}
	// PRODUCT NAME AFTER CLICK ON NAME
	public String getProductNameAfterClick() {
		return driver.findElement(productNameClick).getText();
	}
	// PRODUCT DESCRIPTION AFTER CLICK ON NAME
	public String getProductDescriptionAfterClick() {
		return driver.findElement(productDescriptionClick).getText();
	}
	// PRODUCT PICTURE AFTER CLICK ON NAME
	public void productPictureAfterClick() {
		System.out.println("Product's picture location:	 " + driver.findElement(productPictureClick).getLocation());
		System.out.println("Product's picture source:	 " + driver.findElement(productPictureClick).getAttribute("src"));
	}
	// PRODUCT PRICE AFTER CLICK ON NAME
	public String getProductPriceAfterClick() {
		return driver.findElement(productPriceClick).getText();
	}
	// ADD PRODUCT TO THE CART AFTER CLICK ON NAME
	public void productAddToCartAfterClick() {
		driver.findElement(productAddToCartClick).click();
	}
	// BACK TO PRODUCTS 
	public void backToProducts() {
		driver.findElement(backToProducts).click();
	}
	// ADD NEW PRODUCT TO CART 
	public void addNewProductToCart() {
		driver.findElement(addNewProductToCart).click();
	}
	// CHECKOUT
	public void checkoutProducts() {
		driver.findElement(checkoutProducts).click();
	}
	// SEND INPUTS FOR CHECKOUT
	public void sendInputsForCheckout() {
		driver.findElement(firstName).sendKeys(Messages.CHECKOUT_FIRST_NAME);
		driver.findElement(lastName).sendKeys(Messages.CHECKOUT_LAST_NAME);
		driver.findElement(postalCode).sendKeys(Messages.CHECKOUT_POSTAL_CODE);
		driver.findElement(continueButton).click();
	}
	// SEND INVALID FIRST NAME FOR CHECKOUT
	public void sendInvalidInputsForCheckoutFirstName() {
		driver.findElement(continueButton).click();
	}
	// SEND INVALID LAST NAME FOR CHECKOUT
	public void sendInvalidInputsForCheckoutLastName() {
		driver.findElement(firstName).sendKeys(Messages.CHECKOUT_FIRST_NAME);
		driver.findElement(continueButton).click();
	}
	// SEND INVALID POSTAL CODE FOR CHECKOUT
	public void sendInvalidInputsForCheckoutPostalCode() {
		driver.findElement(lastName).sendKeys(Messages.CHECKOUT_LAST_NAME);
		driver.findElement(continueButton).click();
	}
	// SENDER ERROR 
	public String getSenderError() {
		return driver.findElement(senderError).getText();
	}
	// CLICK ERR 1 FIRST NAME
	public void clickErr() {
		driver.findElement(clickErr).click();
	}
	// CHECKOUT INFOS
	public List<String> getInfoCheckout() {
		List<WebElement> elements = driver.findElements(infoCheckout);
		List<String> elementsText = new ArrayList<String>();
		for (WebElement element : elements) {
			elementsText.add(element.getText());
		}
		return elementsText;
	}
	// CHECKOUT DETAILS infoPaymentCheckout
	public String getInfoPaymentCheckout() {
		return driver.findElement(infoPaymentCheckout).getText();
	}
	// CHECKOUT DETAILS infoSauceCardCheckout
	public String getInfoSauceCardCheckout() {
		return driver.findElement(infoSauceCardCheckout).getText();
	}
	// CHECKOUT DETAILS infoShippingCheckout
	public String getInfoShippingCheckout() {
		return driver.findElement(infoShippingCheckout).getText();
	}
	// CHECKOUT DETAILS infoDeliveryCheckout
	public String getInfoDeliveryCheckout() {
		return driver.findElement(infoDeliveryCheckout).getText();
	}
	// CHECKOUT DETAILS infoNoTaxTotalCheckout
	public String getInfoNoTaxTotalCheckout() {
		return driver.findElement(infoNoTaxTotalCheckout).getText();
	}
	// CHECKOUT DETAILS infoTaxCheckout
	public String getInfoTaxCheckout() {
		return driver.findElement(infoTaxCheckout).getText();
	}
	// CHECKOUT DETAILS infoTotalCheckout
	public String getInfoTotalCheckout() {
		return driver.findElement(infoTotalCheckout).getText();
	}
	// FINISH CLICK
	public void finishClick() {
		driver.findElement(finishClick).click();
	}
	// CHECKOUT COMPLETE
	public String getCheckoutComplete() {
		return driver.findElement(checkoutComplete).getText();
	}
	// CHECKOUT COMPLETE thankYou
	public String getThankYou() {
		return driver.findElement(thankYou).getText();
	}
	// CHECKOUT COMPLETE msgPony
	public String getMsgPony() {
		return driver.findElement(msgPony).getText();
	}
	// CHECKOUT COMPLETE imgPony
	public String getImgPony() {
		return driver.findElement(imgPony).getAttribute("class");
	}
	// CHECKOUT COMPLETE backHome
	public void backHome() {
		driver.findElement(backHome).click();
	}

}
