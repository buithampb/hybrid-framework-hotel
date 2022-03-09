package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

;

public class BaseTest {
	private WebDriver driver;
	
	 
	private enum BROWSER {
		CHROME, FIREFOX, IE, SAFARI, EDGE, EDGE_CHROMIUM, H_CHROME,H_FIREFOX;
	}

	protected WebDriver getBrowserDriver(String browserName, String appUrl) {
		BROWSER browser = BROWSER.valueOf(browserName.toUpperCase());
		if (browser == BROWSER.FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			driver =  new FirefoxDriver();
 		} else if (browser == BROWSER.CHROME) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser == BROWSER.EDGE_CHROMIUM) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			throw new RuntimeException(" Please enter correct browser name");
		}

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(appUrl);

		return driver;
	}
	
	protected String getRandom() {
		Random rand = new Random();
		return "Shinsu" + rand.nextInt(99);
		
	}
	protected String getRandomEmail() {
		Random rand = new Random();
		return "testing" + rand.nextInt(99) + "@mail.net";

	}
	protected String titleRoomType() {
		Random rand = new Random();
		return "yamamieru" + rand.nextInt(999);
		
	}
	protected String newTitleRoomType() {
		Random rand = new Random();
		return "yama" + rand.nextInt(99);
		
	}


}
