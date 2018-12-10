package base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;

import java.lang.reflect.*;

/**
 * Created by arevikhakobyan on 12/10/18.
 */
public class SeleniumBaseTest {
	private WebDriver webDriver;
	private PageFactory pageFactory;
	private Wait wait;
	private Actions actions;
	private final String url = "https://stage1-vote.pollstream.com";

	@BeforeMethod(alwaysRun = true)
	public void setUpSelenium(Method method) {
		webDriver = new ChromeDriver();
		pageFactory = new PageFactory();
		//wait = new Wait(webDriver);
		actions = new Actions(webDriver);

		//webDriver.navigate().to(url);
		webDriver.get(url);
	}

	@AfterMethod(alwaysRun = true)
	public final void tearDownSelenium() {
		webDriver.quit();
	}


	public WebDriver getWebDriver() {
		return webDriver;
	}

	public PageFactory getPageFactory() {
		return pageFactory;
	}

	public Wait getWait() {
		return wait;
	}

	public Actions getActions() {
		return actions;
	}


}

