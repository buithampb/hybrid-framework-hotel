package adminHotel;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.admin.Hotel.AddRoomPageObject;
import pageObject.admin.Hotel.AddRoomTypePageObject;
import pageObject.admin.Hotel.HomePageObject;
import pageObject.admin.Hotel.LoginPageObject;
import pageObject.admin.Hotel.PageGenaratorManager;
import pageObject.admin.Hotel.RoomTypeDetailsPageObject;
import pageObject.admin.Hotel.ViewAllRoomPageObject;
import pageObject.admin.Hotel.ViewAllRoomTypePageObject;

public class Room extends BaseTest {
	WebDriver driver;
	String titleRoomType,newtitle;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		loginPage = PageGenaratorManager.getLoginPage(driver);
		loginPage.LoginAdmin("anhnguyen", "123456");
		homePage = PageGenaratorManager.getHomepage(driver);
		titleRoomType = titleRoomType();
		newtitle = newTitleRoomType();

	}

	@Test
	public void TC_01_Add_Room_Type_Successfully() {
		homePage.clickMenuLinkByName(driver, "Room Types");
		homePage.clickMenuLinkByName(driver, "Add Room Type");
		addRoomTypePage = PageGenaratorManager.getAddRoomTypePage(driver);
		addRoomTypePage.enterToTexboxByName(driver, "title", titleRoomType);
		addRoomTypePage.enterToTexboxByName(driver, "price", "1000");
		addRoomTypePage.SelectDropdownlistByValue("adult", "2");
		addRoomTypePage.SelectDropdownlistByValue("children", "1");
		addRoomTypePage.clickOnSubmitButton(driver);

		Assert.assertTrue(addRoomTypePage.isAllRoomTypesTextDisplayed());

	}

	@Test
	public void TC_02_Add_Room_Successfully() {
		addRoomTypePage.clickMenuLinkByName(driver, "Rooms");
		addRoomTypePage.clickMenuLinkByName(driver, "Add Room");
		addRoomPage = PageGenaratorManager.getAddRoomPage(driver);
		addRoomPage.enterToTexboxByName(driver, "roomnumber", "12");
		addRoomPage.selectRoomType(titleRoomType);
		addRoomPage.enterToTexboxByName(driver, "floor", "3");
		addRoomPage.enterToDesription("Vip");
		addRoomPage.clickOnSubmitButton(driver);
		viewAllRoomPage = PageGenaratorManager.getViewAllRoom(driver);
		Assert.assertTrue(viewAllRoomPage.isAllRoomsTextDisplayed());

	}

	@Test
	public void TC_03_Edit_Upload_Image() {
		viewAllRoomPage.clickMenuLinkByName(driver, "Room Types");
		viewAllRoomPage.clickOnViewAllRoomTypes();
		viewAllRoomTypePage = PageGenaratorManager.getViewAllRoomTypePage(driver);
		viewAllRoomTypePage.entertoSearchTextbox(titleRoomType);
		viewAllRoomTypePage.clickEditIcon();
		roomTypeDetailPage = PageGenaratorManager.getRoomTypeDetailsPage(driver);
		roomTypeDetailPage.enterToTexboxByName(driver, "typename",newtitle);
		roomTypeDetailPage.enterToTexboxByName(driver, "price", "1500");
		roomTypeDetailPage.clickOnSubmitButton(driver);
		roomTypeDetailPage.uploadImageRoomType("moon.jpg");
		roomTypeDetailPage.clickTOnUpLoadImageButton();
		
		Assert.assertEquals(roomTypeDetailPage.textboxByValue("typename","value"),newtitle);
		Assert.assertEquals(roomTypeDetailPage.textboxByValue("price","value"),"1500.0");
		Assert.assertTrue(roomTypeDetailPage.isImagedisplayed());

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private AddRoomPageObject addRoomPage;
	private AddRoomTypePageObject addRoomTypePage;
	private ViewAllRoomPageObject viewAllRoomPage;
	private ViewAllRoomTypePageObject viewAllRoomTypePage;
	private RoomTypeDetailsPageObject roomTypeDetailPage;
	

}
