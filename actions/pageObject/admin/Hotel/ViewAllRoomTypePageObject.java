package pageObject.admin.Hotel;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.admin.Hotel.ViewAllRoomTypePageUIs;

public class ViewAllRoomTypePageObject extends BasePage {
	private WebDriver driver;

	public ViewAllRoomTypePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void entertoSearchTextbox(String value) {
		waitForElementVisible(driver, ViewAllRoomTypePageUIs.SEARCH_TEXTBOX);
		sendkeyToElemnet(driver, ViewAllRoomTypePageUIs.SEARCH_TEXTBOX, value);	
	}
	public void clickEditIcon() {
		waitForElementClickable(driver, ViewAllRoomTypePageUIs.EDIT_ICON);
		clickToElemnet(driver, ViewAllRoomTypePageUIs.EDIT_ICON);
	}

}
