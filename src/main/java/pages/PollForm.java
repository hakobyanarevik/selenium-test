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



	public void selectAnswerForQuestion1And4ByIndex(int index) {
		List<WebElement> radioList = webDriver.findElements(By.cssSelector(".pst-answer-row-table-tr"));
		radioList.get(index).click();
	}

	public void selectAnswerForQuestion2(String option) {
		Select select = new Select(webDriver.findElement(By.cssSelector("select[id='answer_id']")));
		select.selectByVisibleText(option);
	}

	public void selectAnswerForQuestion3and5() {
		List<WebElement> elements = webDriver.findElements(By.cssSelector("span .question-image"));
		elements.get(elements.size() - 1).click();
	}

	public void selectAnswerForQuestion6(String rowIndex, int radioIndex) {
		String selector = String.format("#question-79368 [data-pst-answer-index = %s] > table > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(2) input", rowIndex);
		webDriver.findElements(By.cssSelector(selector)).get(radioIndex).click();
	}

	public void selectAnswerForQuestion7(String rowIndex, int radioIndex) {
		String selector = String.format("#question-79371 [data-pst-answer-index = %s] > table > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(2) input", rowIndex);
		webDriver.findElements(By.cssSelector(selector)).get(radioIndex).click();
	}

	public void selectAnswerForQuestion8(int index, String option) {
		WebElement element = webDriver.findElements(By.cssSelector("#question-79370 > div .ps-answer select")).get(index);

		Select select = new Select(element);
		select.selectByVisibleText(option);
	}

	public void selectAnswerForQuestion9(int index, String option) {
		WebElement element = webDriver.findElements(By.cssSelector("#question-79369 > div .ps-answer select")).get(index);

		Select select = new Select(element);
		select.selectByVisibleText(option);
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


