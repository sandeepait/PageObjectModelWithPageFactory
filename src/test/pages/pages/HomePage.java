package pages;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(xpath="//div[@class='moe-button-wrapper']/button[1]")
	WebElement btn_dontAllow;
	
	@FindBy(xpath="//a[text()='Home & Kitchen']")
	WebElement	link_homeAndKitchen;
	
	@FindBy(xpath="//ul[@class='list_blocks']//a[text()='Curtains']")
	WebElement link_curtains;
	
	public void clickDontAllow() {
		btn_dontAllow.click();
		System.out.println("*****Clicked on don't Allow *****");
	}
	
	public void hoverOverHomeAndKitchenMenu() {
		Actions ac = new Actions(driver);
		ac.moveToElement(link_homeAndKitchen).build().perform();;
		System.out.println("*****Mouse moved over to Home&Kitchen*****");

	}
	
	public void clickOnCurtainsLink() {
		link_curtains.click();
		System.out.println("*****Clicked on Curtains Link*****");
		String mainWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		
		for(String window:allWindows) {
			
			if(!window.equalsIgnoreCase(mainWindow)) {
				driver.switchTo().window(window);
			}
		}
	}

}
