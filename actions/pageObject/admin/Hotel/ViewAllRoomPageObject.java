package pageObject.admin.Hotel;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.admin.Hotel.AddRoomPageObjectUIs;
import pageUIs.admin.Hotel.AddRoomTypePageObjectUIs;
import pageUIs.admin.Hotel.ViewAllRoomPageUIs;

public class ViewAllRoomPageObject extends BasePage{
		private WebDriver driver;
		
		public ViewAllRoomPageObject(WebDriver driver) {
			this.driver = driver;
	}
		public boolean isAllRoomsTextDisplayed() {
			return isElementDisplayed(driver,ViewAllRoomPageUIs.ALL_ROOM_TEXT );
		}

		public void clickOnViewAllRoomTypes() {
			waitForElementClickable(driver, ViewAllRoomPageUIs.VIEW_ALL_ROOM_TYPE);
			clickToElemnet(driver, ViewAllRoomPageUIs.VIEW_ALL_ROOM_TYPE);
			
		}
	
}
