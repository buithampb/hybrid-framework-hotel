package pageObject.customer.Hotel;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.customer.Hotel.BookRoomPageUIs;

public class BookRoomPageObject extends BasePage {
	private WebDriver driver;

	public BookRoomPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getValueConfirmByName(String nameAttribute, String value) {
		return getAttributeValue(driver, BookRoomPageUIs.GET_VALUE_BY_ID, value, nameAttribute);
	}

	public void clickOnCheckboxAgree() {
		waitForElementClickable(driver, BookRoomPageUIs.CHECKBOX);
		clickToElemnet(driver, BookRoomPageUIs.CHECKBOX);
	}

	public void clickOnSubmitButton() {
		waitForElementClickable(driver, BookRoomPageUIs.SUBMIT_BUTTON);
		clickToElemnet(driver, BookRoomPageUIs.SUBMIT_BUTTON);

	}

}
