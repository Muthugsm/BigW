package com.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Base.Base;

public class ProductDetails_page extends Base {
	
	
public ProductDetails_page() {
PageFactory.initElements(driver, this);

}
@FindBy(xpath="//button[@id='addToCartButton' and @type='submit']")
static WebElement addToCart;
@FindBy(xpath="//a[@href='/cart']//child::span[.='$29.00']")
WebElement updated_Cart;

public void click_addToCart(long sec) {
	 
	WebDriverWait cartWait=new WebDriverWait(driver, sec);
	WebElement WaitForCartElement = cartWait.until(ExpectedConditions.elementToBeClickable(addToCart));
	WaitForCartElement.click();
}

public String validate_cart_ICon() {
	return updated_Cart.getText();
	
}
}
