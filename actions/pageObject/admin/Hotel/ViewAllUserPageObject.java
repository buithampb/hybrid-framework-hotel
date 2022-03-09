package pageObject.admin.Hotel;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.admin.Hotel.ViewAllUserPageUIs;

public class ViewAllUserPageObject extends BasePage {
	private WebDriver driver;

	public ViewAllUserPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isAllUserTextdisplayed() {
		return isElementDisplayed(driver, ViewAllUserPageUIs.ALL_USER_TEXT);
	}

	public void EnterToSearchTextbox(String name) {
		waitForElementVisible(driver, ViewAllUserPageUIs.SEARCH_TEXTBOX);
		sendkeyToElemnet(driver, ViewAllUserPageUIs.SEARCH_TEXTBOX, name);

	}

	public void ClickEditIcon() {
		waitForElementClickable(driver, ViewAllUserPageUIs.EDIT_ICON);
		clickToElemnet(driver, ViewAllUserPageUIs.EDIT_ICON);
	}

}
