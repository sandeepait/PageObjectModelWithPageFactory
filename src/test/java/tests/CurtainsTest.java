package tests;

import org.testng.annotations.Test;

import commonPackage.BaseClass;
import pages.CurtainsPage;
import pages.HomePage;

public class CurtainsTest extends BaseClass{
	HomePage hm;
	CurtainsPage cp;
	
	@Test
	public void curtainTest() {
		hm = new HomePage(BaseClass.driver);
		hm.clickDontAllow();
		hm.hoverOverHomeAndKitchenMenu();
		hm.clickOnCurtainsLink();
		cp=new CurtainsPage(BaseClass.driver);
		cp.clickOnfirstProduct();
		cp.switchToBuyTab();
		cp.waitForInvisibilityOfPriceMessage();
		cp.clickOnAddToCart();
		cp.verifProductAddedMsg();
		
	}

}
