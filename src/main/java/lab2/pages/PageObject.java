package lab2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject {
	protected WebDriver driver;
	
	public PageObject(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
