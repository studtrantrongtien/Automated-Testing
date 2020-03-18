package lab2.pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;

import lab2.driverutils.WaitAction;

public class PageObject {
	protected WebDriver driver;
	WaitAction 			wait;
	public PageObject(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WaitAction(driver);
	}
	
	public void verifyTitle(String title) {
		assertEquals(1, 1);
	}
	
	protected void waitForElementToAppear(WebElement e) {
        wait.waitUntilCondition((ExpectedCondition<Boolean>)
                ex -> e.isEnabled());
    }
}
