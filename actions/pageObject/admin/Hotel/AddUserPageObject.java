package pageObject.admin.Hotel;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.admin.Hotel.AddUserPageObjectUIs;

public class AddUserPageObject extends BasePage{
		private WebDriver driver;
		
		public AddUserPageObject(WebDriver driver) {
			this.driver = driver;
	}

		public void EnterToTextareaAddress(String address) {
			waitForElementVisible(driver, AddUserPageObjectUIs.TEXTAREA_ADRESS);
			sendkeyToElemnet(driver, AddUserPageObjectUIs.TEXTAREA_ADRESS, address);
		}

		public void EnterToConfirmPassword(String confirmPassword) {
			waitForElementVisible(driver, AddUserPageObjectUIs.CONFIRM_PASSWORD);
			sendkeyToElemnet(driver, AddUserPageObjectUIs.CONFIRM_PASSWORD, confirmPassword);
		}

		public void ClickOnSubmitButton() {
			waitForElementClickable(driver, AddUserPageObjectUIs.SUBMIT_BUTTON);
			clickToElemnet(driver,AddUserPageObjectUIs.SUBMIT_BUTTON );
		}

		

}

