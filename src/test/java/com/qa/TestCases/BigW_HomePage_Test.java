package com.qa.TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.Base.Base;
import com.ObjectRepository.BigW_Test;
import com.ObjectRepository.HomePage;
import com.ObjectRepository.ProductDetails_page;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.functionalLibrary.FunctionalLibrary;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BigW_HomePage_Test extends Base{
	 static HomePage home;
	 static ProductDetails_page product;
	
	 public BigW_HomePage_Test() {
     super();
	 }
	 @Before
public  void setup() {
 initialization();
 home=new HomePage();
 product=new ProductDetails_page();
  
} 
	 

@Given("^The User is in BigW homepage$")
public void the_User_is_in_BigW_homepage() throws Throwable {
	 
	 home.closeAuto_POp();
		driver.manage().timeouts().pageLoadTimeout(FunctionalLibrary.IMPLICIT_WAIT, TimeUnit.SECONDS);
	   
}
@When("^User Clicks on SetLocation$")
public void user_Clicks_on_SetLocation() throws Throwable {
	 
    home.clickLocation(FunctionalLibrary.WebDriverWait);
}

@When("^The user Enters \"([^\"]*)\" Location$")
public void the_user_Enters_Location(String arg1) throws Throwable {
	 
	 home.setLocation(arg1);
}
@When("^Select the first Entry$")
public void select_the_first_Entry()   {
	 
	home.selectFirstEntry("2150 HARRIS PARK NSW");
     
    
}


@When("^The user should see the Location$")
public void the_user_should_see_the_Location() throws Throwable {
	 
	boolean verify_FirstEntry = home.Verify_FirstEntry();
	Assert. assertTrue(verify_FirstEntry);
	 
}

@When("^user navigate to Product Details$")
public void user_navigate_to_Product_Details() throws Throwable {

	 home.navigateTo(prop.getProperty("Navigate"));
	 
}

@When("^user click the addToCart$")
public void user_click_the_addToCart() throws Throwable {
    product.click_addToCart(FunctionalLibrary.WebDriverWait);
}

@Then("^Validate the updated Cart Icon$")
public void validate_the_updated_Cart_Icon() throws Throwable {
     String validate_cart_ICon = product.validate_cart_ICon();
     Assert.assertEquals(validate_cart_ICon, "$29.00");
     
}


	 
	 
}
