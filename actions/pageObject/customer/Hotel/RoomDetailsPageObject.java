package pageObject.customer.Hotel;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.customer.Hotel.RoomDetailsPageUIs;

public class RoomDetailsPageObject extends BasePage{
	private WebDriver driver;
	
	public RoomDetailsPageObject(WebDriver driver) {
		this.driver = driver;
}

	public String getValueConfirmByName(String nameAttribute,String value) {	
		return getAttributeValue(driver,RoomDetailsPageUIs.GET_VALUE_BY_ID,value,nameAttribute);
	}

	public void clickOnBookNowButton() {
		waitForElementClickable(driver, RoomDetailsPageUIs.BOOK_NOW_BUTTON);
		clickToElemnet(driver, RoomDetailsPageUIs.BOOK_NOW_BUTTON);
	}

	
	
}
