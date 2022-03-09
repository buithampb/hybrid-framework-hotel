package pageObject.customer.Hotel;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.customer.Hotel.ConfirmPageUIs;

public class ConfirmPageObject extends BasePage{
	private WebDriver driver;
	
	public ConfirmPageObject(WebDriver driver) {
		this.driver = driver;
}

	public String getTextSuccessfuly() {
		return getElementText(driver,ConfirmPageUIs.TEXT_SUCCESS);
	}


	
}
