package commons;

import java.io.File;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageUIs.admin.Hotel.BasePageUIs;

public class BasePage {
	
    public static BasePage getBasePage() {
    	return new BasePage();
}
    public void sleepInSecond(long timeoutInSecond) {
		try {
			Thread.sleep(timeoutInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
    public void backToPage(WebDriver driver) {
		driver.navigate().back();

	}
    public void refreshCurrenPage(WebDriver driver) {
		driver.navigate().refresh();

	}
    public WebElement getElement(WebDriver driver, String locator) {
		return driver.findElement(getByXpath(locator));
	}
	
	public WebElement getElement(WebDriver driver, String locator,String...params) {
		return driver.findElement(getByXpath(getDynamicLocator(locator, params)));
	}

    public By getByXpath(String locator) {
		return By.xpath(locator);

	}
    public String getDynamicLocator(String locator, String... params) {
		return String.format(locator, (Object[]) params);

	}
    public void clickToElemnet(WebDriver driver, String locator) {
		getElement(driver, locator).click();
	}

	public void clickToElemnet(WebDriver driver, String locator, String... params) {
		getElement(driver, getDynamicLocator(locator, params)).click();
	}

	public void sendkeyToElemnet(WebDriver driver, String locator, String value) {
		getElement(driver, locator).clear();
		getElement(driver, locator).sendKeys(value);
	}

	public void sendkeyToElemnet(WebDriver driver, String locator, String value, String... params) {
		locator = getDynamicLocator(locator, params);
		getElement(driver, locator).clear();
		getElement(driver, locator).sendKeys(value);
	}
	public void selectDropdownByText(WebDriver driver, String locator, String itemText) {
		select = new Select(getElement(driver, locator));
		select.selectByVisibleText(itemText);
	}
	public String getElementText(WebDriver driver, String locator) {
		return getElement(driver, locator).getText();
	}
	public boolean isElementDisplayed(WebDriver driver, String locator) {
		try {
			return getElement(driver, locator).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	public boolean isElementDisplayed(WebDriver driver, String locator,String...params) {
		try {
			return getElement(driver, locator,params).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	public String getAttributeValue(WebDriver driver, String locator, String attributeName, String... params) {
		return getElement(driver, getDynamicLocator(locator, params)).getAttribute(attributeName);
	}
	public Alert waitForAlertPresence(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, 30);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}
	public void acceptAlert(WebDriver driver) {
		alert = waitForAlertPresence(driver);
		alert.accept();

	}

	
	public void waitForElementVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver,30);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
	}
	
	public void waitForElementVisible(WebDriver driver, String locator, String... params) {
		explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(getDynamicLocator(locator, params))));
	}

	public void waitForElementClickable(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
	}
	public void waitForElementClickable(WebDriver driver, String locator, String... params) {
		explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(getDynamicLocator(locator, params))));
	}
	public void scrollToElementOnDown(WebDriver driver, String locator,String...params) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(false);", getElement(driver, locator,params));
	}
	
	public void clickMenuLinkByName(WebDriver driver,String name) {
		waitForElementClickable(driver,BasePageUIs.MENU_LINK_BY_NAME,name);
		clickToElemnet(driver, BasePageUIs.MENU_LINK_BY_NAME, name);
	}
	public void enterToTexboxByName(WebDriver driver,String name, String value) {
		waitForElementVisible(driver,BasePageUIs.ENTER_TEXTBOX_BY_NAME,name);
		sendkeyToElemnet(driver, BasePageUIs.ENTER_TEXTBOX_BY_NAME, value, name);
	}
	
	public void clickOnSubmitButton(WebDriver driver) {
		waitForElementClickable(driver,BasePageUIs.SUBMIT_BUTTON);
		clickToElemnet(driver,BasePageUIs.SUBMIT_BUTTON );
	}

	public void uploadImage(WebDriver driver,String locator,String nameFile) {
		String projectPath = System.getProperty("user.dir");
		String uploadFilePath = projectPath + File.separator + "uploadFiles" + File.separator;
		String moonFilePath = uploadFilePath + nameFile;
		driver.findElement(By.xpath(locator)).sendKeys(moonFilePath);
	}
	public boolean isTitelPageDisplayed(WebDriver driver,String...params) {
		waitForElementVisible(driver, BasePageUIs.PAGE_TITLE,params);
		return isElementDisplayed(driver, BasePageUIs.PAGE_TITLE,params);
	}

	private Select select;
	private Alert alert;
	private JavascriptExecutor jsExecutor;
	private WebDriverWait explicitWait;
	

}
