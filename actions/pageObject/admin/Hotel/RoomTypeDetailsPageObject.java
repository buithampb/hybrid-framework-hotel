package pageObject.admin.Hotel;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import adminHotel.Room;
import commons.BasePage;
import pageUIs.admin.Hotel.RoomTypeDetailsPageUIs;
import pageUIs.admin.Hotel.UserDetailPageUIs;

public class RoomTypeDetailsPageObject extends BasePage {
	private WebDriver driver;

	public RoomTypeDetailsPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void uploadImageRoomType(String nameFile) {
		waitForElementVisible(driver, RoomTypeDetailsPageUIs.CHOOSE_FILE);
		uploadImage(driver, RoomTypeDetailsPageUIs.CHOOSE_FILE, nameFile);

	}

	public void clickTOnUpLoadImageButton() {
		waitForElementClickable(driver, RoomTypeDetailsPageUIs.UPLOAD_IMAGE);
		clickToElemnet(driver,RoomTypeDetailsPageUIs.UPLOAD_IMAGE);
	}

	public String textboxByValue(String name , String attributename) {
		return getAttributeValue(driver,RoomTypeDetailsPageUIs.TEXBOX_EDIT_ROOM_TYPE_BY_NAME,attributename ,name);
	}

	public boolean isImagedisplayed() {	
		return isElementDisplayed(driver, RoomTypeDetailsPageUIs.IMAGE);
	}

}
