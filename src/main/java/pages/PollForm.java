package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import java.util.*;
import java.util.concurrent.*;

/**
 * Created by arevikhakobyan on 12/10/18.
 */

public class PollForm {
	private WebDriver webDriver;

	public PollForm(WebDriver driver) {
		PageFactory.initElements(driver, this);
		webDriver = driver;
	}

//	@FindBy(id = "ps_form_PSPoll")
//	private WebElement form;
//
//	@FindBy(css = ".ps-vote-button")
//	private WebElement primaryButton;



	private List<WebElement> optionsList() {
		List<WebElement> radioList = webDriver.findElements(By.cssSelector("tr .pst-answer-row-table-tr"));
		return radioList;
	}

	public void selectOptionsByIndex(int index) {
		optionsList().get(index);
	}

	public void selectOptionInSelect(String option) {
		Select select = new Select(webDriver.findElement(By.cssSelector("select[id='answer_id']")));
		select.selectByVisibleText(option);
	}

	public void selectImgByIndex(int index) {
		webDriver.findElements(By.cssSelector(".question-image")).get(index).click();
	}

	public void clickButton() {
		webDriver.findElement(By.cssSelector(".ps-vote-button")).click();
		waitForPollNextForm();

	}

	public void waitForPollNextForm() {
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void waitForElementToBeVisible(By location) {
		new WebDriverWait(webDriver, 10)
			.until(ExpectedConditions.visibilityOfElementLocated(location));
	}

	public void waitForElementToBeVisible(WebElement element) {
		new WebDriverWait(webDriver, 10)
			.until(ExpectedConditions.visibilityOf(element));
	}

}


