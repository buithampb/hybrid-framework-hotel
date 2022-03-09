package pageObject.customer.Hotel;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.customer.Hotel.RoomPageUIs;

public class RoomPageObject extends BasePage{
	private WebDriver driver;
	
	public RoomPageObject(WebDriver driver) {
		this.driver = driver;
}

	public void clickViewDetailsButton() {
		waitForElementClickable(driver, RoomPageUIs.VIEW_DETAILS_BUTTON);
		clickToElemnet(driver, RoomPageUIs.VIEW_DETAILS_BUTTON);
	}

	
	
}
