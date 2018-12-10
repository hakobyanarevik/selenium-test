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
		form.selectOptionsByIndex(2);
		form.selectOptionInSelect("Ansver B");
		form.selectImgByIndex(1);
		// click submit button
		form.clickButton();

		// result page
		form = new PollForm(getWebDriver());
		form.clickButton();

		// next poll
		form = new PollForm(getWebDriver());
		form.selectOptionsByIndex(2);
		form.selectOptionsByIndex(1);
		form.selectImgByIndex(1);
		form.selectImgByIndex(2);
		form.clickButton();

		// result page
		form = new PollForm(getWebDriver());
		form.clickButton();

		// next poll
		form = new PollForm(getWebDriver());










	}


}

