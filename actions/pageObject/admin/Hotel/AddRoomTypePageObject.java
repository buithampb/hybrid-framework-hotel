package pageObject.admin.Hotel;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.admin.Hotel.AddRoomPageObjectUIs;
import pageUIs.admin.Hotel.AddRoomTypePageObjectUIs;
import pageUIs.admin.Hotel.BasePageUIs;

public class AddRoomTypePageObject extends BasePage{
		private WebDriver driver;
		
		public AddRoomTypePageObject(WebDriver driver) {
			this.driver = driver;
	}

		public void SelectDropdownlistByValue(String name,String value) {
			waitForElementVisible(driver,AddRoomTypePageObjectUIs.CLICK_TEXBOX_BY_NAME,name);
			clickToElemnet(driver, AddRoomTypePageObjectUIs.CLICK_TEXBOX_BY_NAME, name);
			
			waitForElementVisible(driver,AddRoomTypePageObjectUIs.DROPDOWNLIST_VALUE_BY_NAME,name,value);
			clickToElemnet(driver, AddRoomTypePageObjectUIs.DROPDOWNLIST_VALUE_BY_NAME, name,value);
			
		}

		public boolean isAllRoomTypesTextDisplayed() {
			return isElementDisplayed(driver, AddRoomTypePageObjectUIs.ALL_ROOM_TYPE_TEXT);
		}


	

}
