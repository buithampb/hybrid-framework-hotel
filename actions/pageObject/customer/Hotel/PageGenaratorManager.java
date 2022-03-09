package pageObject.customer.Hotel;

import org.openqa.selenium.WebDriver;

public class PageGenaratorManager {
	private static LoginPageObject loginPage;
	private static HomePageObject homePage;
	private static RoomPageObject roomPage;
	private static BookRoomPageObject bookRoomPage;
	private static RoomDetailsPageObject roomDetailPage;
	private static CheckoutPageObject checkoutPage;
	private static ConfirmPageObject confirmPage;

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

	public static RoomPageObject getRoomPage(WebDriver driver) {
		roomPage = new RoomPageObject(driver);
		return roomPage;
	}

	public static BookRoomPageObject getBookRoomPage(WebDriver driver) {
		bookRoomPage = new BookRoomPageObject(driver);
		return bookRoomPage;
	}

	public static RoomDetailsPageObject getRoomDetailsPage(WebDriver driver) {
		roomDetailPage = new RoomDetailsPageObject(driver);
		return roomDetailPage;
	}
	public static CheckoutPageObject getCheckoutPage(WebDriver driver) {
		checkoutPage = new CheckoutPageObject(driver);
		return checkoutPage;
	}

	public static ConfirmPageObject getConfirmPage(WebDriver driver) {
		confirmPage = new ConfirmPageObject(driver);
		return confirmPage;
	}

}
