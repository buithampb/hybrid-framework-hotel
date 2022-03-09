package pageObject.admin.Hotel;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.admin.Hotel.AddRoomPageObjectUIs;
import pageUIs.admin.Hotel.AddUserPageObjectUIs;

public class AddRoomPageObject extends BasePage{
		private WebDriver driver;
		
		public AddRoomPageObject(WebDriver driver) {
			this.driver = driver;
	}

		public void selectRoomType(String itemText) {
			waitForElementClickable(driver, AddRoomPageObjectUIs.ROOM_TYPE_TEXBOX);
			clickToElemnet(driver, AddRoomPageObjectUIs.ROOM_TYPE_TEXBOX);
			scrollToElementOnDown(driver,AddRoomPageObjectUIs.ROOM_TYPE, itemText);
			clickToElemnet(driver, AddRoomPageObjectUIs.ROOM_TYPE, itemText);
		}

		public void enterToDesription( String value) {
			waitForElementVisible(driver, AddRoomPageObjectUIs.DESRIPTION);
			sendkeyToElemnet(driver, AddRoomPageObjectUIs.DESRIPTION, value);
			
		}

		

}
