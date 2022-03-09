package pageObject.admin.Hotel;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.admin.Hotel.UserDetailPageUIs;

public class UserDetailPageObject extends BasePage {
	private WebDriver driver;

	public UserDetailPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void EditToTextboxByName(String name, String value) {
		waitForElementVisible(driver, UserDetailPageUIs.TEXBOX_EDIT_USER_BY_NAME, name);
	
		sendkeyToElemnet(driver, UserDetailPageUIs.TEXBOX_EDIT_USER_BY_NAME, value, name);
	}

	public void ClickOnSubmitButtonByAction(String action) {
		waitForElementClickable(driver, UserDetailPageUIs.SUBMIT_BUTTON,action);
		clickToElemnet(driver, UserDetailPageUIs.SUBMIT_BUTTON,action);

	}

	public void ClickOnChangePassword() {
		waitForElementClickable(driver,UserDetailPageUIs.CHANGE_PASSWORD );
		clickToElemnet(driver,UserDetailPageUIs.CHANGE_PASSWORD );
		
	}
	public void EnterToTextboxByName(String name, String value) {
		waitForElementVisible(driver,UserDetailPageUIs.TEXTBOX_CHANGE_PASSWORD_BY_NAME, name);
		sendkeyToElemnet(driver, UserDetailPageUIs.TEXTBOX_CHANGE_PASSWORD_BY_NAME, value, name);
		
	}

	public String TextboxByValue(String name , String attributename) {
		return getAttributeValue(driver,UserDetailPageUIs.TEXBOX_EDIT_USER_BY_NAME,attributename ,name);
	}

	public boolean isProfileSidebarDisplayed() {
		return isElementDisplayed(driver, UserDetailPageUIs.PROFILE_SIDEBAR);
	}

	

}
