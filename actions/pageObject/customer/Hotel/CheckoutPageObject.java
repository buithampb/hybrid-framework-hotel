package pageObject.customer.Hotel;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.customer.Hotel.CheckoutPageUIs;

public class CheckoutPageObject extends BasePage{
	private WebDriver driver;
	
	public CheckoutPageObject(WebDriver driver) {
		this.driver = driver;
}

	public void clickOnPayNowButton() {
	waitForElementClickable(driver, CheckoutPageUIs.PAY_NOW_BUTTON);
	clickToElemnet(driver, CheckoutPageUIs.PAY_NOW_BUTTON);
		
	}

	
	
}
