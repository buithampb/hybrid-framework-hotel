package customerHotel;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.customer.Hotel.BookRoomPageObject;
import pageObject.customer.Hotel.CheckoutPageObject;
import pageObject.customer.Hotel.ConfirmPageObject;
import pageObject.customer.Hotel.HomePageObject;
import pageObject.customer.Hotel.LoginPageObject;
import pageObject.customer.Hotel.PageGenaratorManager;
import pageObject.customer.Hotel.RoomDetailsPageObject;
import pageObject.customer.Hotel.RoomPageObject;

public class Login_Booking extends BaseTest {
	WebDriver driver;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGenaratorManager.getHomepage(driver);

	}

	@Test
	public void TC_01_Login_Empty_User_And_Empty_Password() {
		homePage.clickLoginLink();
		loginPage = PageGenaratorManager.getLoginPage(driver);
		loginPage.loginPage("", "");
		Assert.assertEquals(loginPage.getTextErrorMessager(), "Error: Wrong username or password !!!");
	}

	@Test
	public void TC_02_Login_Incorrect_User_Correct_Password() {
		loginPage.loginPage("cucai", "123456");
		Assert.assertEquals(loginPage.getTextErrorMessager(), "Error: Wrong username or password !!!");
	}

	@Test
	public void TC_03_Login_Correct_User_Incorret_Password() {
		loginPage.loginPage("cuca", "121212");
		Assert.assertEquals(loginPage.getTextErrorMessager(), "Error: Wrong username or password !!!");
	}

	@Test
	public void TC_04_Login_Corret_User_And_Password() {
		loginPage.loginPage("cucai", "121212");
		homePage = PageGenaratorManager.getHomepage(driver);
		Assert.assertEquals(homePage.getProfileText(), "cucai");

	}

	@Test
	public void TC_05_Search_Room() {
		homePage.enterToTexboxById("check-in", "2022/03/15");
		homePage.enterToTexboxById("check-out", "2022/03/19");
		homePage.enterToTexboxByName(driver, "adult", "2");
		homePage.enterToTexboxByName(driver, "children", "1");
		homePage.clickOnSearchButton();
		roomPage = PageGenaratorManager.getRoomPage(driver);
		Assert.assertTrue(roomPage.isTitelPageDisplayed(driver, "Rooms"));
	}

	@Test
	public void TC_06_Booking_Room() {
		roomPage.clickViewDetailsButton();
		roomDetailPage = PageGenaratorManager.getRoomDetailsPage(driver);
		assertEquals(roomDetailPage.getValueConfirmByName("check-in","value"), "2022/03/15");
		assertEquals(roomDetailPage.getValueConfirmByName("check-out","value"), "2022/03/19");
		assertEquals(roomDetailPage.getValueConfirmByName("adult","value"), "2");
		assertEquals(roomDetailPage.getValueConfirmByName("children","value"), "1");
	
		roomDetailPage.clickOnBookNowButton();
		bookRoomPage = PageGenaratorManager.getBookRoomPage(driver);
		Assert.assertTrue(bookRoomPage.isTitelPageDisplayed(driver, "Book Now"));
		assertEquals(bookRoomPage.getValueConfirmByName("name","value"), "cucai");
		assertEquals(bookRoomPage.getValueConfirmByName("email","value"), "thsj@gmail.com");
		assertEquals(bookRoomPage.getValueConfirmByName("phone","value"), "09362363828");
		bookRoomPage.clickOnCheckboxAgree();
		bookRoomPage.clickOnSubmitButton();
		checkoutPage = PageGenaratorManager.getCheckoutPage(driver);
		Assert.assertTrue(checkoutPage.isTitelPageDisplayed(driver, "Checkout"));
	}
	@Test
	public void TC_07_Payment_And_Verify_Book_Successfuly() {
		checkoutPage.enterToTexboxByName(driver,"cardNumber","2004 2004 2004 2004" );
		checkoutPage.enterToTexboxByName(driver,"ownerName","ANH NGUYEN" );
		checkoutPage.enterToTexboxByName(driver,"expiry","12/25" );
		checkoutPage.enterToTexboxByName(driver,"cvvcode","1234" );
		checkoutPage.clickOnPayNowButton();
		
		confirmPage = PageGenaratorManager.getConfirmPage(driver);
		Assert.assertTrue(confirmPage.isTitelPageDisplayed(driver, "Confirm"));
		Assert.assertEquals(confirmPage.getTextSuccessfuly(), "Thank you! Your booking has been placed. We will contact you to confirm about the booking soon.");
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}


	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private RoomPageObject roomPage;
	private RoomDetailsPageObject roomDetailPage;
	private BookRoomPageObject bookRoomPage;
	private CheckoutPageObject checkoutPage;
	private ConfirmPageObject confirmPage;
}
