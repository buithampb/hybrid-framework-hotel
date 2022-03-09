package pageObject.customer.Hotel;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.customer.Hotel.HomPageUIs;

public class HomePageObject extends BasePage{
	private WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
}

	public void clickLoginLink() {
		waitForElementVisible(driver, HomPageUIs.LOGIN_BUTTON);
		clickToElemnet(driver, HomPageUIs.LOGIN_BUTTON);
		
	}

	public String getProfileText() {
		waitForElementVisible(driver, HomPageUIs.PROFILE_IMG);	
		return getElementText(driver, HomPageUIs.PROFILE_IMG);
	}

	public void enterToTexboxById( String id, String value) {
		waitForElementVisible(driver, HomPageUIs.TEXTBOX_BY_ID,id);
		sendkeyToElemnet(driver, HomPageUIs.TEXTBOX_BY_ID, value,id);
		
		
	}

	public void clickOnSearchButton() {
		waitForElementClickable(driver,HomPageUIs.SEARCH_BUTTON);
		clickToElemnet(driver, HomPageUIs.SEARCH_BUTTON);
	
	}

	
}
