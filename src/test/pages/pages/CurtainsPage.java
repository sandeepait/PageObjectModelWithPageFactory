package pages;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import commonPackage.BaseClass;

public class CurtainsPage extends BaseClass{

	WebDriver driver;

	public CurtainsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@CacheLookup
	@FindBy(xpath="(//div[@id='product_list']//a[@class='whishlist_ic']/following-sibling::a)[1]")
	WebElement firstProduct;
	
	@CacheLookup
	@FindBy(id="add_cart")
	WebElement btn_addToCart;
	
	@CacheLookup
	@FindBy(xpath="//div[@id='snackbar']")
	WebElement productAddedMsg;
	
	public void clickOnfirstProduct() {
		firstProduct.click();
	}
	
	public void switchToBuyTab() {
		Set<String> openedWindows = driver.getWindowHandles();
		
		for(String window:openedWindows) {
			System.out.println("Title-->"+driver.getTitle());
			driver.switchTo().window(window);
			if(driver.getTitle().startsWith("Buy")) {
				System.out.println("*****Switched To Buy window********");
				System.out.println("*****Window Title-->"+driver.getTitle());
				break;
			}
		}
	}
	
	public void waitForInvisibilityOfPriceMessage() {
		if(productAddedMsg.isDisplayed()) {
			BaseClass.explicitWait(10).until(ExpectedConditions.attributeToBe(productAddedMsg, "class", "cb_toastmsg"));
		}
	}
	
	public void clickOnAddToCart() {
		BaseClass.explicitWait(10).until(ExpectedConditions.elementToBeClickable(btn_addToCart)).click();
		System.out.println("******Clicked on Add to cart.");
	}
	
	public void verifProductAddedMsg() {
	 BaseClass.explicitWait(10).until(ExpectedConditions.attributeToBe(productAddedMsg, "class", "cb_toastmsg show"));
	 String productAddedMSg = productAddedMsg.getText();
	Assert.assertEquals(productAddedMSg, "Product added to cart", "Message is not as expected");
	System.out.println("******Product successfully added to cart.");
	}
}
