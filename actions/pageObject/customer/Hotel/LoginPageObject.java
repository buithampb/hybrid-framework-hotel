package pageObject.customer.Hotel;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.customer.Hotel.LoginPageUIs;

public class LoginPageObject extends BasePage{
	private WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
}

	public void loginPage(String name, String password) {
		waitForElementVisible(driver, LoginPageUIs.USER_NAME);
		sendkeyToElemnet(driver, LoginPageUIs.USER_NAME, name);
		waitForElementVisible(driver, LoginPageUIs.PASSWORD);
		sendkeyToElemnet(driver, LoginPageUIs.PASSWORD, password);
		waitForElementClickable(driver, LoginPageUIs.SINGIN_BUTTON);
		clickToElemnet(driver, LoginPageUIs.SINGIN_BUTTON);

	}

	public String getTextErrorMessager() {
		return getElementText(driver, LoginPageUIs.ERROR_LOGIN);
	}

}
