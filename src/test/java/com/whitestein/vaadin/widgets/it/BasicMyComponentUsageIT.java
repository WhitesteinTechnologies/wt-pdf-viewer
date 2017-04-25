package com.whitestein.vaadin.widgets.it;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

//import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.vaadin.addonhelpers.automated.AbstractWebDriverCase;
import org.vaadin.addonhelpers.automated.VaadinConditions;

import com.whitestein.vaadin.widgets.BasicMyComponentUsageUI;

/**
 * A simple example that uses Selenium to do a browser level test for a
 * BasicMyComponentUsageUI. For more complex tests, consider using page
 * object pattern.
 */
public class BasicMyComponentUsageIT extends AbstractWebDriverCase {

	@Test
	public void testJavaScriptComponentWithBrowser() throws InterruptedException {

		startBrowser();

		driver.navigate().to(
				BASEURL + BasicMyComponentUsageUI.class.getName());

		// Consider using Vaadin TestBench to make stuff easier
		new WebDriverWait(driver, 30).until(VaadinConditions.ajaxCallsCompleted());

		final WebElement el = driver.findElement(By.cssSelector(".mycomponent"));

		String origText = el.getText();

		el.click();

		new WebDriverWait(driver, 30).until(VaadinConditions.ajaxCallsCompleted());

		String newText = el.getText();

		assertNotSame(origText, newText);

		assertEquals("You have clicked 1 times", newText);

		// Just for demo purposes, keep the UI open for a while
		Thread.sleep(1000);

	}

	@Override
	protected void startBrowser() {
		startBrowser(new PhantomJSDriver());
	}

}
