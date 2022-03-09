package pageObject.admin.Hotel;

import org.openqa.selenium.WebDriver;

public class PageGenaratorManager {
	private static LoginPageObject loginPage;
	private static HomePageObject homePage;
	private static AddUserPageObject addUserPage;
	private static AddRoomPageObject addRoomPage;
	private static AddRoomTypePageObject addRoomTypePage;
	private static ViewAllUserPageObject viewAllUser;
	private static UserDetailPageObject userDetail;
	private static ViewAllRoomPageObject viewAllRoom;
	private static ViewAllRoomTypePageObject viewAllRoomType;
	private static RoomTypeDetailsPageObject roomTypeDetail;

	private PageGenaratorManager() {
		
	}
	
	public static LoginPageObject getLoginPage(WebDriver driver) {
			loginPage = new LoginPageObject(driver);
		return loginPage;
	}

	public static HomePageObject getHomepage(WebDriver driver) {
		homePage = new HomePageObject(driver);
		return homePage;
	}
	public static AddUserPageObject getAddUserPage(WebDriver driver) {
		addUserPage = new AddUserPageObject(driver);
		return addUserPage;
	}
	public static AddRoomPageObject getAddRoomPage(WebDriver driver) {
		addRoomPage = new AddRoomPageObject(driver);
		return addRoomPage;
	}
	public static AddRoomTypePageObject getAddRoomTypePage(WebDriver driver) {
		addRoomTypePage = new AddRoomTypePageObject(driver);
		return addRoomTypePage;
	}

	public static ViewAllUserPageObject getViewAllUserPage(WebDriver driver) {
		viewAllUser = new ViewAllUserPageObject(driver);
		return viewAllUser;
	}

	public static UserDetailPageObject getUserDetailPage(WebDriver driver) {
		userDetail = new UserDetailPageObject(driver);
		return userDetail;
	}

	public static ViewAllRoomPageObject getViewAllRoom(WebDriver driver) {
		viewAllRoom = new ViewAllRoomPageObject(driver);
		return viewAllRoom;
	}

	public static ViewAllRoomTypePageObject getViewAllRoomTypePage(WebDriver driver) {
		viewAllRoomType = new ViewAllRoomTypePageObject(driver);
		return viewAllRoomType ;
	}

	public static RoomTypeDetailsPageObject getRoomTypeDetailsPage(WebDriver driver) {
		roomTypeDetail = new RoomTypeDetailsPageObject(driver);
		return roomTypeDetail;
	}

	

}
