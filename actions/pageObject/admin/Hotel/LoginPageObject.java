package pageObject.admin.Hotel;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.admin.Hotel.LoginPageUI;

public class LoginPageObject extends BasePage{
	private WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;

}

	public void LoginAdmin(String user, String password) {
		waitForElementVisible(driver,LoginPageUI.USER_NAME );
		sendkeyToElemnet(driver,LoginPageUI.USER_NAME, user);
		waitForElementVisible(driver, LoginPageUI.PASSWORD);
		sendkeyToElemnet(driver, LoginPageUI.PASSWORD, password);
		clickToElemnet(driver, LoginPageUI.LOGIN_BUTTON);
	}

}
