package selenium;

import base.*;
import org.testng.annotations.*;
import pages.*;

/**
 * Created by arevikhakobyan on 12/10/18.
 */
public class SeleniumPollTest extends SeleniumBaseTest {

	@Test
	public void pollTest() {
		PollForm form = new PollForm(getWebDriver());
		form.clickButton();

		// poll page
		form = new PollForm(getWebDriver());
		form.selectAnswerForQuestion1And4ByIndex(2);
		form.selectAnswerForQuestion2("Ansver B");
		form.selectAnswerForQuestion3and5();
		// click submit button
		form.clickButton();

		// result page
		form = new PollForm(getWebDriver());
		form.clickButton();

		// next poll
		form = new PollForm(getWebDriver());
		form.selectAnswerForQuestion1And4ByIndex(2);
		form.selectAnswerForQuestion1And4ByIndex(1);
		form.selectAnswerForQuestion3and5();
		form.selectAnswerForQuestion3and5();
		form.clickButton();

		// result page
		form = new PollForm(getWebDriver());
		form.clickButton();

		// next poll
		form = new PollForm(getWebDriver());
		form.selectAnswerForQuestion6("1", 9);
		form.selectAnswerForQuestion7("3", 6);
		form.selectAnswerForQuestion8(3, "3");
		form.selectAnswerForQuestion9(6, "8");

	}


}

