package com.ObjectRepository;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Base.Base;

public class HomePage extends Base{
	 
	public HomePage() {
  PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[.='×']")
	WebElement autoPOpUP;

	@FindBy(xpath = "(//*[.='Set your location'])[2]")
	static WebElement ClickOnSetLocation;
	
    @FindBy(id="userLocationInput")
    WebElement locationInput;
	
	 
    @FindBy(xpath="//ul[@id='ui-id-1']//li")	   
    List<WebElement> allLocationList;
	 
	@FindBy(xpath="//span[.='2150 HARRIS PARK']")
	WebElement verifyfirstEntry;
	
	public void closeAuto_POp() {
        autoPOpUP.click();
	}
	public void clickLocation(long sec) {
	    WebDriverWait wait= new WebDriverWait(driver, sec);
		WebElement until = wait.until(ExpectedConditions.elementToBeClickable(ClickOnSetLocation));
		until.click();
	}
	
	 public void setLocation(String location) {
     locationInput.sendKeys(location);
	}
	
	 public void selectFirstEntry(String selectFirst) {
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 for (int i = 0; i <allLocationList.size() ; i++) {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				System.out.println(allLocationList.get(i).getText());
				if (allLocationList.get(i).getText().equals(selectFirst)) {
					allLocationList.get(i).click();
				}
				}
		 
	 }
	 public boolean Verify_FirstEntry() {
		return verifyfirstEntry.isDisplayed();
	 }
	
 public  HomePage navigateTo(String productPage) {
	 driver.navigate().to(productPage);
	 return new HomePage();
 }
  
}
