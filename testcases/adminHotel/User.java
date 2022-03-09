package adminHotel;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.admin.Hotel.AddUserPageObject;
import pageObject.admin.Hotel.HomePageObject;
import pageObject.admin.Hotel.LoginPageObject;
import pageObject.admin.Hotel.PageGenaratorManager;
import pageObject.admin.Hotel.UserDetailPageObject;
import pageObject.admin.Hotel.ViewAllUserPageObject;

public class User extends BaseTest {
	WebDriver driver;
	String email,username;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		
		loginPage = PageGenaratorManager.getLoginPage(driver);
		loginPage.LoginAdmin("anhnguyen", "123456");
		homePage = PageGenaratorManager.getHomepage(driver);

	}

	@Test
	public void TC_01_AddUserSuccessfilly() {
		email = getRandomEmail();
		username = getRandom();
		homePage.clickMenuLinkByName(driver, "Users");
		homePage.clickMenuLinkByName(driver, "Add User");
		addUserPage = PageGenaratorManager.getAddUserPage(driver);
		addUserPage.enterToTexboxByName(driver,"name","Shin Mo");
		addUserPage.enterToTexboxByName(driver,"email",email);
		addUserPage.enterToTexboxByName(driver,"phone","0974563792");
		addUserPage.enterToTexboxByName(driver,"username",username);
		addUserPage.enterToTexboxByName(driver,"password","123456");
		addUserPage.EnterToConfirmPassword("123456");
		addUserPage.EnterToTextareaAddress("Viet Nam");
		addUserPage.ClickOnSubmitButton();
		
		viewAllUser = PageGenaratorManager.getViewAllUserPage(driver);
		Assert.assertTrue(viewAllUser.isAllUserTextdisplayed());
		
	}
	@Test
	public void TC_02_EditUser() {
		viewAllUser.EnterToSearchTextbox("Shin Mo");
		viewAllUser.ClickEditIcon();
		userDetail = PageGenaratorManager.getUserDetailPage(driver);
		userDetail.EditToTextboxByName("phone","09836725638");
		userDetail.EditToTextboxByName("name","Ha Ha");
		userDetail.ClickOnSubmitButtonByAction("updateUser");
		Assert.assertEquals(userDetail.TextboxByValue("phone","value"),"09836725638");
		Assert.assertEquals(userDetail.TextboxByValue("name","value"),"Ha Ha");
		
		
	}
	@Test
	public void TC_03_ChangePassword() {
		userDetail.ClickOnChangePassword();
		userDetail.EnterToTextboxByName("oldPass","123456");
		userDetail.EnterToTextboxByName("newPass","111111");
		userDetail.EnterToTextboxByName("confirmPass","111111");
		userDetail.ClickOnSubmitButtonByAction("changePass");
		Assert.assertTrue(userDetail.isProfileSidebarDisplayed());
		
		
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private AddUserPageObject addUserPage;
	private ViewAllUserPageObject viewAllUser;
	private UserDetailPageObject userDetail;

}
